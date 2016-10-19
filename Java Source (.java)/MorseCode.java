import java.util.*;
import java.io.*;

public class MorseCode
{
	public static void main (String[] args)
		throws IOException
	{
		// command line argument for input file
		File input = new File(args[0]);

		// scanner to get count
		Scanner count = new Scanner(input);

		// scanner to print into array
		Scanner scan = new Scanner(input);

		int words = 0; // gets word count of file
		while (count.hasNext()) { words++; count.next(); };

		// new array to store both english and morse versions
		String[][] wordsArray = new String[words][words];

		// iterates through each word
		for (int i = 0; i < words; i++) 
		{

			// stores english string at index 0
			String english = wordsArray[i][0]; 
			
			// stores morse string at index 1
			String morse = wordsArray[i][1];   

			// gets next string from file
			english = scan.next();
			
			// converts english to morse
			morse = stringToMorse(english);

			// formats morse string to remove space at char 0 and adds 4 more dots to separate words by 7
			morse = morse.substring(1, morse.length() - 1) + ".... ";

			// prints english then morse equivalent
			System.out.println(english + "\n" + morse + "\n\n");

		}
	}

	// recursively converts string to morse code
	static String stringToMorse(String s)
	{
		// base case
		if (s.length() == 0) return "";

		// converts last letter first
		return stringToMorse(s.substring(0, s.length() - 1)) + charToMorse(s.charAt(s.length() - 1)) + " ..." ; 
	}

	// converts character into morse code 
	static String charToMorse(char c)
	{
		c = Character.toUpperCase(c); // converts to uppercase
		if (c == 'A') return " . . ..."; 					// 13
		if (c == 'B') return " ... . . . . . ."; 			// 3111
		if (c == 'C') return " ... . . . ... . ."; 			// 3131
		if (c == 'D') return " ... . . . ."; 				// 311
		if (c == 'E') return " .";							// 1
		if (c == 'F') return " . . . . ... . .";			// 1131
		if (c == 'G') return " ... . ... . .";				// 331
		if (c == 'H') return " . . . . . . .";				// 1111
		if (c == 'I') return " . . .";						// 11
		if (c == 'J') return " . . ... . ... . ...";		// 1333
		if (c == 'K') return " ... . . . ...";				// 313
		if (c == 'L') return " . . ... . . . .";			// 1311
		if (c == 'M') return " ... . ...";					// 33
		if (c == 'N') return " ... . .";					// 31
		if (c == 'O') return " ... . ... . ...";			// 333
		if (c == 'P') return " . . ... . ... . .";			// 1331
		if (c == 'Q') return " ... . ... . . . ...";		// 3313
		if (c == 'R') return " . . ... . .";				// 131
		if (c == 'S') return " . . . . .";					// 111
		if (c == 'T') return " ...";						// 3
		if (c == 'U') return " . . . . ...";				// 113
		if (c == 'V') return " . . . . . . ...";			// 1113
		if (c == 'W') return " . . ... . ...";				// 133
		if (c == 'X') return " ... . . . . . ...";			// 3113
		if (c == 'Y') return " ... . . . ... . ...";		// 3133
		if (c == 'Z') return " ... . ... . . . .";			// 3311
		return intToMorse(c);

	}
	// converts integer into morse code
	static String intToMorse(char i)
	{
		if (i == '1') return " . . ... . ... . ... . ... ...";
		if (i == '2') return " . . . . ... . ... . ... ...";
		if (i == '3') return " . . . . . . ... . ... ...";
		if (i == '4') return " . . . . . . . . ... ...";
		if (i == '5') return " . . . . . . . . . ...";
		if (i == '6') return " ... . . . . . . . . ...";
		if (i == '7') return " ... . ... . . . . . . ...";
		if (i == '8') return " ... . ... . ... . . . . ...";
		if (i == '9') return " ... . ... . ... . ... . . ....";
		if (i == '0') return " ... . ... . ... . ... . ... ...";
		return "";
	}
	// tests if char is alphabetical
	static boolean isAlpha(char c)
	{
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
	}
}