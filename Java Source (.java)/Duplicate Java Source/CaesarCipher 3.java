import java.util.*;
import java.io.*;
public class CaesarCipher
{
    public static void main (String[] foo) 
    throws IOException
    {
        // determines whether user wants to encode or decode
        boolean encipher = input();

        // prompts user for shift increment
        int shift = key(); 

        // clears the screen
        clear(); 

        // creates input File
        File input = new File(fileInput());

        // creates Scanner
        Scanner reader = new Scanner(input);

        // creates output FileWriter
        FileWriter output = new FileWriter(fileOutput());

        // if user wants to encode
        if (encipher) 
            do output.write(caesarEncipher(reader.nextLine(), shift));
            while (reader.hasNextLine());
        
        // if user wants to decode
        else 
            do output.write(caesarDecipher(reader.nextLine(), shift));
            while (reader.hasNextLine());
        output.close();

        // DONE!
        System.out.println("DONE!");

    }

    // encrypts a string
    public static String caesarEncipher (String s, int key) 
    {
        key %= 26;
        String code = "\n";
        for (int i = 0; i < s.length(); i++) {
            if (isAlpha(s.charAt(i)) && isUpper) code += shiftChars(s.charAt(i), key, false);
            else code += s.charAt(i);
        }
        return code;
    }

    // decrypts a string
    public static String caesarDecipher (String s, int key)
    {
        String code = "\n";
        key %= 26;
        key = 26 - key;
        for (int i = 0; i < s.length(); i++) {
            if (isAlpha(s.charAt(i)) && isUpper) code += shiftChars(s.charAt(i), key, true);
            else code += s.charAt(i);
        }
        return code;
    }

    // shifts char by given amount
    private static char shiftChars(int c, int key, boolean negative) 
    {

        int a = 'A';
        if (isLower) a = 'a'; // checks caps
        
        c += key;
        c -= a;
        c %= 26;
        c += a;

        return (char)c;
    }

    // determines whether char is alphabetical (preferred over java's default)
    private static boolean isAlpha(char c) 
    {
        isUpper = false; isLower = false;

        // checks if char is lowercase
        if (c >= 'a' && c <= 'z') isLower = true;

        // checks if char is uppercase
        else if (c >= 'A' && c <= 'Z' ) isUpper = true;

        // checks if char is in the alphabet
        if ((isLower || isUpper) ) return true;
        else return false;
    }

    // determines whether user wants to encode or decode
    public static boolean input()
    {
        clear(); // clears the screen
        Scanner keyboard = new Scanner(System.in);

        // if entry is invalid
        if (invalid) System.out.println("\nInvalid entry, please enter one of the following: ");

        // prints welcome message only once
        if (!invalid) System.out.println("Welcome to CaesarCipher");

        // prints program usage
        System.out.println("Enter 1 to encipher, or 2 to decipher (-1 to exit): ");

        // if entry is invalid recursively calls function
        if (!keyboard.hasNextInt()) { invalid = true; input(); }
        
        // assigns tmp to user input
        int tmp = keyboard.nextInt();
        
        // exits program
        if (tmp == -1) System.exit(0);

        // assigns bool encipher to true if user wants to encipher
        else if (tmp == 1) return true;

        // assigns bool encipher to false if user wants to decode
        else if (tmp == 2) return false;

        // if entry is invalid recursively calls function
        if (tmp != 1 || tmp != 2) { invalid = true; input(); }

        // impossible scenario
        return false; 
    }

    // prompts user for shift key
    public static int key()
    {
        clear();
        System.out.println("What shift should I use? ");
        Scanner keyboard = new Scanner (System.in);
        if (keyboard.hasNextInt()) return keyboard.nextInt();
        else return key();
    }

    // prompts user for file input name
    public static String fileInput()
    {
        clear();
        Scanner keyboard = new Scanner (System.in);
        System.out.println("What is the input file name? ");
        if (keyboard.hasNext()) return keyboard.next();
        return fileInput();
    }

    // prompts user for file output name
    public static String fileOutput()
    {
        clear();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the output file name? ");
        if (keyboard.hasNext()) return keyboard.next();
        return fileOutput();
    }

    // clears the screen
    public static void clear() 
    {
        for (int i = 0; i < 23; i++)
            System.out.println();
    }

    // used to to test input validity
    private static boolean invalid = false;   
    private static boolean isUpper = false;
    private static boolean isLower = false;
}