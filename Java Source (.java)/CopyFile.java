/** CopyFile.java
 *
 *  Copies an input file to an output file;
 *  also echoes it to the screen.  Both files user-specified.
 *  Superficially similar to the Unix cp command
 *  
 *  Uses the simplest file I/O classes
 *      Doesn't catch exceptions. 
 *  Demonstrates how to use COMMAND-LINE ARGUMENTS
 *
 *      Dr. Henry H. Leitner
 *      Last Modified on July 5, 2012
 */

import java.io.*;               // for the File class
import java.util.*;	            // for the Scanner class

class CopyFile 
{

  public static void main (String [] args) 
         throws IOException          // simply pass all errors on...
  {

    if (args.length != 2) 
    {
        System.out.println("Precisely 2 arguments are required! Bye... ");
        System.exit (0);
    } 
    Scanner inFile =  new Scanner (new File (args[0])); 
    PrintWriter outFile = new PrintWriter (args[1]);

    while ( inFile.hasNextLine())  	    // while not at end-of-file
    {           
        String s = inFile.nextLine();
        System.out.println (s);  // .. echo current char to screen,
        outFile.println (s);     // .. and write to user's output file
    }
    System.out.println ("\nAll Done!\n");
    inFile.close();
    outFile.close();
  }
}
