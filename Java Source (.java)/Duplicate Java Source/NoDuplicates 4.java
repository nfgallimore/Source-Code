import java.util.*;
import java.io.*;

public class NoDuplicates
{
	public static void main (String[] args)
		throws IOException
	{
		File in = new File(args[0]);
		Scanner inRead = new Scanner(in);
		File out = new File(args[1]);
		FileWriter outWrite = new FileWriter(args[1]);
		Scanner outRead = new Scanner(out);
		System.out.println("ORIGINAL FILE: " + args[0] + " contains the values");
		Scanner inReadTmp = new Scanner(in);
		
		int next = 0;
		int tmp = 0;
		int count = 0;

		String s = inRead.next();
		tmp = Integer.parseInt(s);

		System.out.println(tmp); 
		outWrite.write(tmp + "\n");
		
		while (inRead.hasNextInt())
		{
			s = inRead.next();
			next = Integer.parseInt(s);
			count++;
			
			if (tmp != next)
			{
				outWrite.write(next + "\n");
				for (int i = 0; i <= count; i++)
					s = inReadTmp.next();
				tmp = Integer.parseInt(s);
			}
		} 

		outWrite.close();
		do
			System.out.println(outRead.nextLine());
		while(outRead.hasNext());
		
	}
}