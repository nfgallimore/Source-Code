import java.util.Collections;
import java.util.ArrayList;
import java.util.*;
public class Lottery
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);                         // Gets users input using Scanner
        
        int[] userNums = new int[4];                                    // User's numbers array
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$ Please enter four digits (e.g. 1 2 3 4) $$ \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        
        boolean same = false;                                           // sets same to false by default
        for (int j, i = 0; i < 4; i++)                                  
        {
            userNums[i] = input.nextInt();                              // iterates through userNums array to fill it with keyboard input
            for (j = 0; j < i; j++)
            {
                if (userNums[i] == userNums[j])                         // definition for same boolean, forces unique digits
                {
                    same = true;                                        
                    System.out.println("\n\n** Invalid entry, digits must be UNIQUE! **");
                    System.out.println("** Invalid entry, digits must be UNIQUE! ** ");
                    System.out.println("** Invalid entry, digits must be UNIQUE! ** \n\n");
                    break;
                }
            }
            if (same == true)
                break;
            
        }
        if (same == false)                                              // Keeps user input limited to unique digits
        {
            ArrayList <Integer> numbers = new ArrayList<Integer>();     // Creates a new array of numbers
            for(int i = 1; i < 10; i++)                                 // with digits 1-9
                numbers.add(i);                                         // fills the array
            
            
            int[] winners = new int[4];                                 // Creates a winners array
            Collections.shuffle(numbers);                               // Shuffles numbers array
            
            
            System.out.println("\n\n\nWinning Numbers\n");                      // Prints winning numbers.
            for(int j = 0; j < 4; j++)
            {
                System.out.print(numbers.get(j) + " ");                       // gets the actual numbers from numbers array
                winners[j] = numbers.get(j);                            // fills winners array with selected numbers
            }
            /*
            System.out.println("\n\nYour numbers ");                         // Prints users guess's.
            System.out.print("      ");
            for (int i = 0; i < 4; i++)
                System.out.print(userNums[i]);
            System.out.println("\n");
            */
            compareArrays(userNums, winners);                           // Calls compare function to search both arrays to see if user won.
            
            if (b == 4)                                                 // if user gets all four numbers right this prints winner.
                System.out.println("\nWINNER!!! COLLECT $100.00\n\n");
            else
                System.out.println("\n\n\nSorry, try again!\n\n");
    }
    }
    public static void compareArrays(int[] array1, int[] array2)        // Function to compare two arrays
    {
        for (int i = 0; i < array2.length; i++)
            for (int a = 0; a < array1.length; a++)
                if (array2[i] == array1[a])
                    b++;                                               // each time a user guesses right b is increased by 1
    }
    
    public static int b = 0;                                           // Global variable to count number of digits guessed correctly
}