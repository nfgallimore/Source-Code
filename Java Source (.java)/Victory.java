public class Victory
{
	
	public static void main(String[]args)
	{
		
		slashes(false);
		System.out.println("|| Victory is mine! ||");
		slashes(true);
	}
	
	private static boolean slashes(boolean slashed)
	{
		for (int i = 0; i <= 21; i++)
			if (slashed == false)
				System.out.print("/");
			else
				System.out.print("\\");
		System.out.println("");
		return slashed;
	}			
		
	
}