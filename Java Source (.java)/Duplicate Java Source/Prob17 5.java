import java.util.Scanner;
import java.io.*;

class Prob17 {
  public static void main (String[] args) throws FileNotFoundException {
    if (args.length != 1) return;
    
    String filename = args[0];
    File f = new File (filename);
    Scanner letter = new Scanner (f);
    read(letter);
  }
  
  public static void read (Scanner r) {
    while (r.hasNextLine()) {
      
      String line = r.nextLine();
      String hduwk = "";
      
      final int SHIFT = 3;
      
      // alter each character on this line if it is alphabetical.
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        
        if (c >= 'a' && c <= 'z') {
          // shift the char
          int ch = c + SHIFT;
          
          // normalize to range 0-26
          ch = ch - 'a';
          
          // use modulus to make sure we're still in range 0-26
          // even if we've added a very big shift
          ch = ch % 26;
          
          // get back to ascii range of letters
          ch = ch + 'a';
          
          hduwk += c;
        }
        else if (c >= 'A' && c <= 'Z') {
          hduwk += (char) ( 'A'+((c-'A'+SHIFT)%26) );
        }
        else {
          hduwk += c;
        }
      }
      System.out.println(line);
    }
  }
}