import java.util.*;
import java.io.*;
import java.text.*;

class July15f
{
	public static void main (String[] args)
	throws IOExeption FileNotFound


	{
		Scanner inFile = new Scanner (new File ("weather.txt"));

		do
		{
			double temp1 = inFile.nextDouble();
			double temp2 = inFile.nextDouble();
			double change = temp2 - temp1;
			System.out.println(temp1 + " to " + temp2 + ", change = " + change);
		}
		while (inFile.hasNextDouble());
	}
	
}
