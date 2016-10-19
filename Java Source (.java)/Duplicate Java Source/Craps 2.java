import java.lang.Math;
public class Craps
{
	public static void main(String[] args)
	{
         // first roll
        int a = 0;
        while (a != 4 && a != 5 && a != 6 && a != 8 && a != 9 && a != 10)
            a = rollDice();
        System.out.println(a + " is now the established POINT.");
        
        // second roll
        int b = 0;
        while (a != b && b != 7) b = rollDice();
        if (a == b) System.out.println("YOU WIN");
        else System.out.println("YOU LOSE");
	}
	public static int rollDice()
	{
        int dice1 = 1 + (int)( (6 - 1 + 1) * Math.random() );
        int dice2 = 1 + (int)( (6 - 1 + 1) * Math.random() );
        int point = dice1 + dice2;
        System.out.println("Computer rolls a " + dice1 + " and a " + dice2 + ", for a total of " + point + ".");
        return point;
	}
}