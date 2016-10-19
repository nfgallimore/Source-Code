public class Diamond
{
	public static void main(String[]args)
	{
	
		for (int line = 0; line < 3; line++)
		{
			int spaces = 0;
			for (int i = 0; i <= spaces; i++)
			{
				System.out.println("#");
				do
					System.out.print(" ");
				while (spaces == 6 - line);
				for (int j = -1; j < line; j++)
				{
					slashes(true);
				}
			}
		//	System.out.println("");
		}

	}
	
	private static boolean slashes(boolean backwards)
	{
		if (backwards == true)
			System.out.print("\\");
			System.out.print("/");
		return backwards;
	}	
}