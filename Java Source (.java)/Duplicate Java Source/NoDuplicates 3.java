import java.util.*;
import java.io.*;

public class NoDuplicates
{
	public static void main (String[] args)
		throws IOException
	{
		File in = new File(args[0]);
		File out = new File(args[1]);
        
        PrintWriter writeOut = new PrintWriter(args[1]);
        
		Scanner inRead = new Scanner(in);
		Scanner outRead = new Scanner(out);

		System.out.println("\nORIGINAL FILE: " + args[0] + " contains the values");
		
		int current = 0;
		int tmp = 0;

		writeOut.println(inRead.nextInt());
		do {
			current = inRead.nextInt();
			System.out.println(current);
			if (current > tmp) { writeOut.println(current); tmp = current; }
		}
		while (inRead.hasNextInt());

		writeOut.close();
		System.out.println("\nNEW FILE: " + args[1] + " contains the values");
		do System.out.println(outRead.nextLine());
		while(outRead.hasNext());
		
	}
	
}
