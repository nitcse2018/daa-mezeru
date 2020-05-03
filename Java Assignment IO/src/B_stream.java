import java.io.*;
import java.util.*;  
public class B_stream
{ 
    public static void main(String[] args) throws IOException 
    { 
    	FileInputStream in = null; 
    	FileOutputStream out = null;
    	int read; 
    	
    	
    	  Scanner inp = new Scanner(System.in);  
    	
    	try {
    		
    		in = new FileInputStream("Byte//R.txt");     // R is referencing to R.txt
    		out = new FileOutputStream("Byte//W.txt");    // W is referencing to W.txt
    		
    		
    	
    		
            while ((read = in.read()) != -1)     // loop to read each byte  and write it in W.txt
                 out.write((char)read);   
            
                   
                        
        } 
    		
    	
    	catch(Exception e) {     //error will be diplayed
    	
    		System.out.println(e);
    	}
    	
    	finally 
        {   
            if(in != null) {
            	in.close();
            }
            if(out != null) {
            	out.close();
            }
        }
   }
    
}