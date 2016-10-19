class July9d
{
	public static void (String[] args)
	{
		for (int i = 1; i <= 9; i++)
		{
			int iCubed = i * i * i;
			for (int j = 0; j <= 9; j++)
			{
				int jCubed = j * j * j;
				for (int k = 0; k <= 9; k++)
				{
					int kCubed = k * k * k;
					int value = i * 100 + j * 10 + k;
					if (iCubed + jCubed + kCubed == value)
						System.out.println(value);
				}
			}
		}
	}
}