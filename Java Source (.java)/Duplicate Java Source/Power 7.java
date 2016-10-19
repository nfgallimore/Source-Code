class Power
{
	public static void main (String[] args)
	{
		double foobar = 2.0;

		// Recursive calls: 20
		System.out.println(power(foobar, 1023);
		
		// Recursive calls: 12
		System.out.println(power(foobar, 1024);
	}
	public static double power (double x, int n)
	{
		if (n == 0) return 1.0;
		else if (n % 2 == 0) return Math.pow(power(x, n / 2), 2);
		else if (n > 0) return x * power(x, n-1);
		else return 1.0 / power(x, -n);
	}
}