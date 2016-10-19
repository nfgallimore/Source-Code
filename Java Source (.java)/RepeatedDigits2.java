import java.util.Scanner;
public class RepeatedDigits2
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter an integer: "); 
        String input = keyboard.nextLine(); 
        String parsedInput = input.replaceAll("[^0-9]", "");
        parsedInput = parsedInput.replaceFirst("^0+(?!$)", "");
        
        int[] occurrences = new int[10];
        for (int index = 0; index < parsedInput.length(); index++) 
        {
            int occurrencesAtIndex = parsedInput.charAt(index) - '0';
            occurrences[occurrencesAtIndex]++;
        }
        System.out.print("Digit:      ");
        for (int digit = 0; digit < 10; digit++)
            System.out.printf("   %d", digit);
        System.out.println();
        
        System.out.print("Occurrences:");
        for (int i = 0; i < occurrences.length; i++)
            System.out.printf("   %d", occurrences[i]);
        System.out.println();
    }
}