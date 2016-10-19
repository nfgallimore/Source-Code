import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.lang.*;

public class ExecuteShellComand
{
	public static void main(String[] args)
	{
		ExecuteShellComand obj = new ExecuteShellComand();

    	Scanner kb = new Scanner (System.in);
  		System.out.println("What is the URL?");
  		
  		String url = kb.nextLine();
  		String command = "./ner.sh " + url;
  		String output = obj.executeShellCommand(command);

  		System.out.println(output);

	}
	private String executeShellCommand(String command) 
	{
		StringBuffer output = new StringBuffer();
		Process p;
		try 
		{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
 			String line = "";			
			while ((line = reader.readLine())!= null) 
			{
				output.append(line + "\n");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return output.toString();
 
	}
}