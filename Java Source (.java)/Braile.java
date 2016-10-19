import java.util.*;
import java.io.*;

public class HolyBraille
{
	public static void main (String[] args)	
	{
		// Creates a new scanner so we can get user input
		Scanner in = new Scanner(System.in);
		// Prints message to user 
		System.out.println("Enter a character to be converted to Braile:  ");
		// User Input
		String userInput = in.nextLine();
		// Converts user input to Braile and saves in string braileOutput
		String braileOutput = "";
		braileOutput = charToBraile(userInput);
		System.out.println(charToBraile(userInput));
		Bool mat[] = new Bool[5];
		mat[0] = true;
		mat[1] = false;
		mat[2] = false;
		mat[3] = false;
		mat[4] = false;
		mat[5] = false;
		System.out.println(printfun(mat));
	}
	// It's fucking complicated ^_^ Don't ask. --- It just magically prints shit. 
	public static printfun(Bool[] inputMatrix) 
	{
		for (int i = 0; i < 5; i++) {
			Bool[] matrix = new Bool[5];
			for (int i = 0; i < matrix.length; i++) matrix[i] = inputMatrix[i];
			int cnt = 0;
			for (int i = 0; i < matrix.length; i++) {
				if (cnt > 1) System.out.println();
				if (matrix[i] == true) System.out.print ("."); 
				else System.out.print (" ");
				cnt++;
			}
		}
	}
}