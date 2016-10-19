public class PrintPowersOf2
{
	public static void main(String[] args)
	{
		final int POWER = 10;
		printPowersof2(POWER);
	}
	public static void printPowersof2(int power)
	{
		for (int i = 0, num = 1; i <= power; i++, num *= 2)
			System.out.print(num + " ");
	}
}
