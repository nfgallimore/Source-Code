class Factorial2
{
	static int fact (int n)
	{
		if (n == 0) return 1;
		else return n * fact(n-1);
	}
	System.out.println(fact (fact(-17)));
	public static main( String [] args)
	{
		for (int i = 0; i <= 12; i++)
		{
			System.out.println(i + " factorial = " + fact (i));
		}

}