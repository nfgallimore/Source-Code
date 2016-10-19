public class Mystery
{
	public static void main(String[] args)
	{
		mystery(-2, -6);
		System.out.println();
		mystery(2, 3);
		System.out.println();
		mystery(4, 8);
		System.out.println();
		mystery(10, 31);
		System.out.println();
	}
	public static void mystery (int x, int y) 
	{ 
		int s = 0;
		
		while (x > 0 && 2 * y >= x) 
		{ 
			System.out.print(s + " "); 
			y = y - x;
			x--; 
			s = s + x; 
		}
		System.out.println(s);
	}
}