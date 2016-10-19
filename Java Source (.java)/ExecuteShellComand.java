import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.lang.*;

public class ExecuteShellComand
{
	public static void main(String[] args)
	{
		ExecuteShellComand obj = new ExecuteShellComand();
  		System.out.println(obj.executeShellCommand("ner.sh ~/Documents/data.html"));

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