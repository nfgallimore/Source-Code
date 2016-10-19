import java.util.*;
public class TwoRandom
{
    public static void main(String[] args)
    {
        double num1 = Math.random() * 7 + 1;
        double num2 = Math.random() * 7 + 1;
        
        System.out.println((int)num1 + " " + (int)num2);
        
        int diff1 = (int)num2 - (int)num1;
        int diff2 = (int)num1 - (int)num2;
        
        if (diff1 == 0 || diff2 == 0)
            System.out.println("A tie!");
        
        else if ( (diff1 % 2 == 0) || diff2 % 2 == 0)
            System.out.println("You win!");
        else
            System.out.println("You lose!");
    }
}