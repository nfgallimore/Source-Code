public class Power
{
	static double power (double x, int n)
	{
		if (n == 0) return 1;
		else if (n > 0) return x * (power(x, n-1));
		else return 1.0 / power (x, -n);
	}
	public static void main(String[] args)
	{
		System.out.println ( power (7, 3));
	}
}