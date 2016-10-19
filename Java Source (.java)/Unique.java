public class Unique
{
	public static void main(String[] args)
	{
		int i = numUnique(18, 3, 4);
		System.out.println(i);
		
		i = numUnique(6, 3, 3*2);
		System.out.println(i);
	}
	public static int numUnique(int a, int b, int c)
	{
		int count = 1;
		if (b != a)
			count++;
		if (a != c && b != c)
			count++;
		return count;
	}
}