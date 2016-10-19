// partnered with Burak Sertsoz

import java.util.Scanner;
import java.io.*;

public class ExamAnalysis
{
  public static void main (String[] args)
  throws IOException
  {
    System.out.println("\nI hope you are ready to begin . . .\n");
    Scanner keyboard = new Scanner(System.in);
    String answerKey = "";
    
	System.out.println("Please type the correct answers to the exam questions,\none right after the other: ");
    answerKey = keyboard.next();
  
	
    System.out.println("\nWhat is the name of the file containing each student's responses\nto the " + answerKey.length() + " questions? ");
    String fileString = keyboard.next();

    File responses = new File(fileString);
    Scanner responseScanner = new Scanner(responses);
    int studentNum = 0;

    do
    {
      responseScanner.nextLine();
      studentNum++;
    } while (responseScanner.hasNext());
	System.out.println();
    Scanner responseScannerNew = new Scanner(responses);
    String[] answerArray = new String[studentNum];
    for (int i = 0; i < studentNum; i++) {
      	answerArray[i] = responseScannerNew.nextLine();
		System.out.println("Student #" + (i+1) + "'s responses: " + answerArray[i]);
	}
    
    System.out.println("We have reached \"end of file!\"");
    System.out.println("\nThank you for the data on " + studentNum + " students. Here's the analysis:");
	int[][] data = new int[5][studentNum];
    
	data = analysis(answerArray, answerKey, studentNum);
    questionAnalysis(answerArray, answerKey, data);
  }
  
  public static int[][] analysis(String[] answerArray, String answerKey, int studentNum)
  {
	int[][] data = new int[studentNum][5];
    System.out.printf("\n\nStudent #       Correct      Incorrect      Blank");
    System.out.printf("\n~~~~~~~~~       ~~~~~~~      ~~~~~~~~~      ~~~~~");
	for (int j = 0; j < studentNum; j++)
    {
      	int correct = 0; 
      	int incorrect = 0;
      	int blank = 0;
      	int question = 0;
      	for (int i = 0; i < answerKey.length(); i++)
      	{
        	if (answerArray[j].charAt(i) == ' ') blank++;
        	else if (answerKey.charAt(i) == answerArray[j].charAt(i))
        	correct++;
        	else incorrect++;
			if (answerKey.charAt(i) != answerArray[j].charAt(i))
                data[j][question] = i;
      	}
		if (correct > 9 || incorrect > 9 || blank > 9)
      		System.out.printf("\n    %d             %d             %d            %d", (j+1), correct, incorrect, blank);
		else System.out.printf("\n    %d              %d             %d            %d", (j+1), correct, incorrect, blank);
      	//data[studentnum][0 = question#, 1 = correct, 2 = incorrect, 3 = blank]
		
		}
		return data;
	}
	public static void questionAnalysis(String[] answerArray, String answerKey, int[][] data)
	{
		int studentNum = data.length;
	    System.out.println("\n\n\n\nQUESTION ANALYSIS (* marks the correct response)");
		System.out.println("~~~~~~~~~~~~~~~~~");
	    for (int i = 0; i < answerKey.length() ; i++)
		{
			int correct = 0;
			int incorrect = 0;
			int blank = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
	

			for (int j = 0; j < studentNum; j++) 
			{
				correct += data[j][1];
				incorrect += data[j][2];

				if (answerArray[j].charAt(i) == 'A') a++;
				else if (answerArray[j].charAt(i) == 'B') b++;
				else if (answerArray[j].charAt(i) == 'C') c++;
				else if (answerArray[j].charAt(i) == 'D') d++;
				else if (answerArray[j].charAt(i) == 'E') e++;
				else if (answerArray[j].charAt(i) == ' ') blank++;
			}
	  		System.out.println("\nQuestion #" + (i+1) + ":\n");
		
			if (answerKey.charAt(i) == 'A')			
				System.out.printf("     A*      B       C       D       E       Blank");

			else if (answerKey.charAt(i) == 'B')
				System.out.printf("     A       B*      C       D       E       Blank");

			else if (answerKey.charAt(i) == 'C')
				System.out.printf("     A       B       C*      D       E       Blank");

			else if (answerKey.charAt(i) == 'D')
				System.out.printf("     A       B       C       D*      E       Blank");

			else if (answerKey.charAt(i) == 'E')
				System.out.printf("     A       B       C       D       E*      Blank");

			double percentA = a / (double)studentNum * 100;
			double percentB = b / (double)studentNum * 100;
			double percentC = c / (double)studentNum * 100;
			double percentD = d / (double)studentNum * 100;
			double percentE = e / (double)studentNum * 100;
			double percentBlank = (double)blank / studentNum * 100;

			System.out.printf("\n\n     %d       %d       %d       %d       %d         %d\n\n", a, b, c, d, e, blank);
			printPercent(percentA, false);
			printPercent(percentB, false);
			printPercent(percentC, false);
			printPercent(percentD, false);
			printPercent(percentE, false);
			printPercent(percentBlank, true);
			System.out.println("\n\n");
		}

	}
	public static void printPercent(double d, boolean blank)
	{
		if (blank) System.out.printf("  ");
		if (d == 100) System.out.printf("  %.1f%%",d);
		else if (d < 10 && d < 100) System.out.printf("    %.1f%%",d);
		else System.out.printf("   %.1f%%",d);
	}
}
