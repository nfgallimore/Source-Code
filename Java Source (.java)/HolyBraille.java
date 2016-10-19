import java.util.*;
import java.io.*;

public class HolyBraille
{
	public static void main (String[] args)	
	{
		// User Input
		String userInput = args[0];
		// Converts user input to Braile and saves in string braileOutput
		String braileOutput = "";

		boolean mat[] = new boolean[6];
		if (args[0] == 1) mat[0] = true;
		mat[args[1]] = false;
		mat[args[2]] = false;
		mat[args[3]] = false;
		mat[args[3]] = false;
		mat[args[3]] = false;
		printfun(mat);
		reset(mat);


	}
	// It's fucking complicated ^_^ Don't ask. --- It just magically prints shit. 
	public static void printfun(boolean[] inputMatrix) 
	{
		boolean[] matrix = new boolean[6];

		for (int i = 0; i < matrix.length; i++) 
		{
			matrix[i] = inputMatrix[i];
		}

		int cnt = 0;

		for (int i = 0; i < matrix.length; i++) 
		{
			if (cnt > 1)
			{ 
				System.out.println();
			}
			if (matrix[i] == true) 
			{
				System.out.print ("."); 
			}
			else 
			{
				System.out.print (" ");
			}
			cnt++;
		}
	}

	public static void reset(boolean[] mat) 
	{
		for (int i = 0; i < mat.length; i++)
		{
			mat[i] = false;
		}
	}
}