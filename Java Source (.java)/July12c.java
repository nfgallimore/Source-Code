class July12c
{
	static int fact (int n)
	{
		if (n == 0) return 1;
		else return n * fact(n-1);
	}
	public static main( String [] args)
	{
		for (int i = 0; i <= 12; i++)
		{
			System.out.println(i + " factorial = " + fact (i));
		}

}