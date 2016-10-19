import java.util.Scanner;
public class Congress
{
    public static void main (String[] args)
    {
        // initializes
        int age = 0;
        int lengthOfCitizenship = 0;
        
        // new scanner called input
        Scanner input = new Scanner(System.in);
        
        // title screen
        System.out.println ("CONGRESS ELIGIBILITY\n");
        
        // gets age
        System.out.print ("Enter age of candidate: ");
        age = input.nextInt();
        
        // new line
        System.out.println();
        
        // gets length of citizenship
        System.out.print ("Enter years of U.S. citizenships: ");
        lengthOfCitizenship = input.nextInt();
        
        // neither
        if ( !eligibleForHouse(age, lengthOfCitizenship) )
            System.out.println("The candidate is NOT eligible for election to either\nthe House of Representatives or the Senate.");
        
        // eligible for house but not senate
        if ( eligibleForHouse(age, lengthOfCitizenship) &&
            !eligibleForSenate(age, lengthOfCitizenship) )
            
            System.out.println("The candidate is eligible for election to the House of\nRepresentatives but is NOT eligibie for election to \nthe Senate.");
        
        // eligible for both
        if ( eligibleForSenate(age, lengthOfCitizenship) )
            System.out.println("The candidate is eligible for election to both the \nHouse of Representatives and the Senate.");
        
    }
    // new variable named eligibleForSenate
    private static boolean eligibleForSenate (int age, int lengthOfCitizenship)
    {
        if (age >= 30 && lengthOfCitizenship >= 9)
            return true;
        else
            return false;
    }
    // private variable named eligibleForHouse
    private static boolean eligibleForHouse (int age, int lengthOfCitizenship)
    {
        if (age >= 25 && lengthOfCitizenship >= 7)
            return true;
        else
            return false;
    }
}