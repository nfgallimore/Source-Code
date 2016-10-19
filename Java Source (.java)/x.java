import java.io.*;

class x
{ 
   public static void main (String [] args)
   {
          File f = new File("x.java");
          if (f.exists() && f.canRead()) 
           System.out.println("length = " + f.length());
           else System.out.println("File does not exist!");
   } 
 }

