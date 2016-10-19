import java.util.*;
import java.io.*;
public class K4
{
    public static void main (String[] foo) 
    throws IOException
    {
        System.out.println();
        boolean encipher = input();
        int shift = key();
        clear();
        File input = new File(fileInput());
        Scanner reader = new Scanner(input);
        FileWriter output = new FileWriter(fileOutput());
        if (encipher) 
            do output.write(caesarEncipher(reader.nextLine(), shift));
            while (reader.hasNextLine());
        
        else 
            do output.write(caesarEncipher(reader.nextLine(), -shift));
            while (reader.hasNextLine());

        output.close();
    }

    private static String caesarEncipher (String s, int key) 
    {
        String code = "";
        for (int i = 0; i < s.length(); i++) 
        {
            if (isAlpha(s.charAt(i))) code += shiftChars(s.charAt(i), key);
            else code += s.charAt(i);
        }
        return code;
    }
    private static char shiftChars(int tmp, int key) 
    {
        int a;
        if (isLower) a = 'a'; // checks caps
        else a = 'A';
        tmp -= a; // calculations
        tmp = (tmp + key) % 26;
        System.out.println("\nChar # " + tmp);
        tmp += a;

        return (char)tmp;
    }
    private static boolean isAlpha(char c) 
    {
        isUpper = false; isLower = false;
        // checks lowercase
        if (c >= 'a' && c <= 'z') isLower = true;
        // checks uppercase
        else if (c >= 'A' && c <= 'Z' ) isUpper = true;
        // checks alpha
        if ((isLower || isUpper) ) return true;
        else return false;
    }
    public static String caesarDecipher (String input, int shift)
    {
        return "";
    }
    public static boolean input()
    {
        clear(); // clears the screen
        Scanner keyboard = new Scanner(System.in);

        // if entry is invalid
        if (invalid) System.out.println("\nInvalid entry, please enter one of the following: ");

        // prints program usage
        if (!invalid) System.out.println("Welcome to CaesarCipher");
        System.out.println("Enter 1 to encipher, or 2 to decipher (-1 to exit): ");

        // if entry is invalid
        if (!keyboard.hasNextInt()) { invalid = true; input(); }
        
        // assigns tmp to user input
        int tmp = keyboard.nextInt();
        
        if (tmp == -1) System.exit(0); // exits
        else if (tmp == 1) return true; // encipher
        else if (tmp == 2) return false; // decipher

        // if entry is invalid
        if (tmp != 1 || tmp != 2) { invalid = true; input(); }

        return false; // impossible scenario
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
    public static String fileInput()
    {
        clear();
        Scanner keyboard = new Scanner (System.in);
        System.out.println("What is the input file name? ");
        if (keyboard.hasNext()) return keyboard.next();
        return fileInput();
    }
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
    public static boolean invalid = false;
    private static boolean isUpper = false;
    private static boolean isLower = false;
}