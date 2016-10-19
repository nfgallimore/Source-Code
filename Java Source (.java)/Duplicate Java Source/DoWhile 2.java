public class DoWhile
{
	public static void main(String[] args)
	{
		int j = 1;
		int i = 1;
		
		do
		{
			i++;
			++j;
			System.out.println( i * j);
		}
		while ((i < 10) && (j*j != 25));
		
		i = 1;
		j = 1;
		while ((i < 10) && (j*j != 25))
		{ 
			i++; 
			++j;
			System.out.println( i * j );
		} 
		// 1 4 9 16 25

	}
}