import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class Resume {
   Resume()
   { Choice c=new Choice();  
     c.setBounds(100,100, 75,75);  
     c.add("Mr.");  
     c.add("Mrs.");  
     c.add("Ms.");  
   
     
      Frame fr=new Frame();       
      Label l1 = new Label("FullName : ");
      TextField t1 = new TextField(35);
      
      Label l2 = new Label("Date of Birth : ",Label.LEFT); 
      TextField t2 = new TextField(15);
      Label l2_1 = new Label("                                                    ");
    
      Label l2_2 = new Label("Contact - Info : ",Label.LEFT);  
      TextField t2_2 = new TextField(15);
      
      Label l2_3 = new Label(" Email Address : ");
      TextField t2_3 = new TextField(15);
     
      
      Label l3 = new Label("Permanant Address : ",Label.LEFT);        
      TextArea t3=new TextArea("");  
      Label l3_1 = new Label(" "); 
      
      
      Label l4 = new Label("About Me : ",Label.LEFT);        
      TextArea t4 = new TextArea("");
      
      
      Label l5_1 = new Label("\nEducation : 1)",Label.LEFT);        
      TextField t5_1 = new TextField(10);
      Label l5_2 = new Label("2)");
      TextField t5_2 = new TextField(10);
      Label l5_3 = new Label("3)");
      TextField t5_3 = new TextField(10);

      
      
      Label l6 = new Label("Skills : ",Label.LEFT);      
      Label l6_1 = new Label("                                                                                                                                                             "); 
      TextArea t6 = new TextArea();
      
      

      
      
      Label l7 = new Label("Click the button to build Resume ",Label.LEFT);          
      Button B1 = new Button ("SUBMIT");B1.setSize(10,500);

   
             
     fr.add(c);
     fr.add(l1);
     fr.add(t1);
    
     fr.add(l2);
     fr.add(t2);
     fr.add(l2_1);
     
     fr.add(l2_2);
     fr.add(t2_2);
     
     fr.add(l2_3);
     fr.add(t2_3);
     
	 fr.add(l3_1);
     fr.add(l3);
     fr.add(t3);
     
     fr.add(l4);
     fr.add(t4);
    
     fr.add(l6_1); 
     fr.add(l5_1);fr.add(t5_1);
     fr.add(l5_2);fr.add(t5_2);
     fr.add(l5_3);fr.add(t5_3);

     fr.add(l6_1);
     fr.add(l6);
     fr.add(t6);
     fr.add(l6_1);
     
     fr.add(l7);
     fr.add(B1);
     

     B1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae){
         
         String RT;
      
         RT = "\n RESUME ";
          
         RT = inputFile(RT, c.getItem(c.getSelectedIndex()),"\nName:");
         RT = inputFile(RT, t1.getText()," ");    
         RT = inputFile(RT, t2.getText(), "\nDate of Birth :");
         RT = inputFile(RT, t2_2.getText(), "\nContact no.");
         RT = inputFile(RT, t2_3.getText(), "\nEmail Address ");
         RT = inputFile(RT, t3.getText(), "\nPermanant Address : ");
         RT = inputFile(RT, t4.getText(), "\nAbout Me : ");
         RT = inputFile(RT, t5_1.getText(), "\nEducational Background:\n1) ");
         RT = inputFile(RT, t5_2.getText(), "2) ");
         RT = inputFile(RT, t5_3.getText(), "3) ");
         RT = inputFile(RT, t6.getText(), "\nSkills:\n");
         
         
         System.out.println(RT);
         try{
             File file = new File("./Generated_resume.txt");
         FileOutputStream fos = new FileOutputStream(file);
         if(!file.exists())
             file.createNewFile();
         byte[] bytesArray = RT.getBytes();
         fos.write(bytesArray);
         fos.flush();
         fos.close();
         }
         catch(IOException ioe){
             ioe.printStackTrace();
         }
         
     }});
      
     
     
      fr.setSize(500,900);  
      fr.setBackground(Color.CYAN);
      fr.setLayout(new FlowLayout());      
      fr.setVisible(true);                
   }
   public static void main(String args[])
   {
       Resume R_ = new Resume(); 
   }
   public static String inputFile(String RT, String temp, String adder){
	   if(adder == " ") {
		   adder=" "+adder;
	       return (RT+adder+temp);
	   }
	   else {
       adder="\n"+adder;
       return (RT+adder+temp);
	   }
   }
}