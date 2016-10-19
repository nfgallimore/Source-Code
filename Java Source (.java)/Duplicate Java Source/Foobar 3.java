import java.util.*;
public class Foobar
{
	public static void main(String[] args)
	{
		final int ROWS = 3;
		final int COLS = 3;
		//String[][] foobar = new String[ROWS][COLS];
		char[][] foobar = { { 'O', ' ', ' ' },
							{ ' ', 'X', ' ' },
							{ 'X', 'O', 'X' } };
		int sum = 0;
		int count = 0;


		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				//foobar[i][j] = "Nick";
				sum ++;// foobar[i][j].length();
				count++;
				System.out.print(foobar[i][j] + " ");
			}
			System.out.println();
		}
		double avg = sum / count;

		System.out.println("The average length of all the strings in the array is " + avg);

	}
}

/*
for (int i = 0; i < ROWS; i++)
{
	for (int j = 0; j < COLS; j++)
	{
		sum += foobar[i][j].length();
		count++;
	}
}
double avg = sum / count;
*/

