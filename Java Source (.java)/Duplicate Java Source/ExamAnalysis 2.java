import java.util.Scanner;
import java.io.*;

public class ExamAnalysis
{
  public static void main (String[] args)
  throws IOException
  {
    System.out.println("I hope you are ready to begin . . .");
    Scanner keyboard = new Scanner(System.in);
    String answerKey = "";
    
	System.out.println("Please type the correct answers to the exam questions, one right after the other: ");
    answerKey = keyboard.next();
  
	
    System.out.println("What is the name of the file containing each student's responses to the 10 questions? ");
    String fileString = keyboard.next();

    File responses = new File(fileString);
    Scanner responseScanner = new Scanner(responses);
    int studentNum = 0;

    do
    {
      responseScanner.nextLine();
      studentNum++;
    } while (responseScanner.hasNext());

    Scanner responseScannerNew = new Scanner(responses);
    String[] answerArray = new String[studentNum];
    for (int i = 0; i < studentNum; i++) {
      	answerArray[i] = responseScannerNew.nextLine();
		System.out.println("Student #" + (i+1) + "'s responses: " + answerArray[i]);
	}
    
    System.out.println("We have reached \"end of file!\"");
    System.out.println("\nThank you for the data on " + studentNum + " students. Here's the analysis:");
    analysis(answerArray, answerKey, studentNum);
    questionAnalysis(answerArray, answerKey);
  }
  


  public static void analysis(String[] answerArray, String answerKey, int studentNum)
  {
	int[][] data = new int[studentNum][4];
    System.out.printf("\nStudent #       Correct      Incorrect      Blank");
    System.out.printf("\n~~~~~~~~~       ~~~~~~~      ~~~~~~~~~      ~~~~~");
	for (int j = 0; j < studentNum; j++)
    {
      int correct = 0; 
      int incorrect = 0;
      int blank = 0;
      int question = 1;
      for (int i = 0; i < answerKey.length(); i++)
      {
        if (answerArray[j].charAt(i) == ' ') blank++;
        else if (answerKey.charAt(i) == answerArray[j].charAt(i))
        correct++;
        else incorrect++;
        data[j][question] = i;
      }
      System.out.printf("\n    %d                %d           %d           %d", (j+1), correct, incorrect, blank);
      //data[studentnum][0 = question#, 1 = correct, 2 = incorrect, 3 = blank]
    }
  }

	public static void questionAnalysis(String[] answerArray, String answerKey)
	{
	    System.out.println("\n\nQUESTION ANALYSIS (* marks the correct response)");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
	    for (int i = 1; i < answerKey.length(); i++)
		{
	  		System.out.println("Question #" + i + ":"); 	
		}
	}
}
