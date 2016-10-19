import java.util.Scanner;

class Roulette
{
	public static void main (String[] args)
	{
		int money = 1000;
		
		final int JACKPOT = money * 2;
		Scanner keyboard = new Scanner(System.in);
		int amount;
		String color;
		char c;
		while (money > 0) 
		{
			System.out.printf("You currently have %d dollars: \n How much would you like to bet? ", money);
			amount = keyboard.nextInt();
			System.out.printf("What color do you want?");
			color = keyboard.next();
			c = color.charAt(0);
			money += spin(c, amount);
			if (money > JACKPOT) 
			{
				System.out.println("You win!");
				return;
			}
		}
	
	}
	// spin - returns amount to change money by
	// 1-18 black
	// 19-36 red
	// 0 green automatic lose

	public static int spin(char color, int bet)
	{
		// spin
		int number = (int)Math.random() * (36 - 0 + 1);
		// black
		if (color == 'b' && ((number >= 18) && number < 0)) return bet;
		else return (-bet);

	}
}