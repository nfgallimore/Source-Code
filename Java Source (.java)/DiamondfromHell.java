// Note to self, next time don't spend 12 hours trying to do a simple problem     //
// take the easy way out and do it in five minutes                                //

public class DiamondfromHell
{
	public static void main(String[]args)
	{
		// line one
		for (int space = 0; space < 2; space++)
			System.out.print(" ");
		System.out.println("\\/");
		
		// line two
		for (int space = 0; space < 1; space++)
			System.out.print(" ");
		System.out.println("\\\\//");
		
		// line three
		System.out.println("\\\\\\///");
		
		// line four
		System.out.println("\\\\\\///");
		
		// line five
		for (int space = 0; space < 1; space++)
			System.out.print(" ");
		System.out.println("//\\\\");
		
		// line six
		for (int space = 0; space < 2; space++)
			System.out.print(" ");
		System.out.println("/\\");
	}
}	

