public class ProducerConsumer{
   public static void main(String[] args) {
      Conent c = new Conent();
      Producer p1 = new Producer(c, 1);
      Consumer c1 = new Consumer(c, 1);
      p1.start(); 
      c1.start();
   }
}
class Conent {
   private int contents;
   private boolean available = false;
   
   public synchronized int get() {
      while (available == false) {
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      available = false;
      notifyAll();
      return contents;
   }
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         } catch (InterruptedException e) { } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}
class Consumer extends Thread {
   private Conent Conent;
   private int number;
   
   public Consumer(Conent c, int number) {
      Conent = c;
      this.number = number;
   }
   public void run() {
      int value = 0;
      for (int i = 0; i < 4 ; i++) {
         value = Conent.get();
         System.out.println("Consumer of the number " + this.number + " got: " + value);
      }
   }
}
class Producer extends Thread {
   private Conent conent;
   private int number;
   public Producer(Conent c, int number) {
      conent = c;
      this.number = number;
   } 
   public void run() {
      for (int i = 0; i < 4; i++) {
         conent.put(i);
         System.out.println("Producer of the number " + this.number + " put: " + i);
         try {
            sleep((int)(Math.random() * 100));
         } catch (InterruptedException e) { }
      } 
   }
} 