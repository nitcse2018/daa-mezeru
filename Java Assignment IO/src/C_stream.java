import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.io.IOException;
public class C_stream
{ 
    public static void main(String[] args) throws IOException 
    { 
    	FileWriter out = null;
    	FileReader in = null;
    	
    	try {
    		in = new FileReader("Char\\R.txt");  // in is referencing to R.txt
    		out = new FileWriter("Char\\W.txt"); // W is referencing to W.txt
    		int i;
    		while((i = in.read())!= -1) {         // loop to read each  char and write it in W.txt
    			out.write((char)i);
    		}
	
    		
    	}
    	
    	catch(Exception e) {     //error will be diplayed
        	
    		System.out.println(e);
    	}
    	
    	finally 
        {   
            in.close();
            out.close();
        }
    	
    }
} 