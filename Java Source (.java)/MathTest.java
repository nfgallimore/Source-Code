import java.util.*;

public class MathTest 
{
	public static void main(String[] args) {
		int var1 = (int) Math.floor(Math.random() * 101),var2 = (int) Math.floor(Math.random() * 101), var3 = (int) Math.floor(Math.random() * 101);
		// (var1 * x^var2)^var3
		String expr1 = "What is the answer to (" + var1 + "x^" + var2 + ")^" + var3 + "?";
		System.out.println(expr1);
		Scanner kb = new Scanner(System.in);
		String answer = kb.nextLine();
		if (correct(answer, var1, var2, var3)) {
			System.out.println(answer + " is the correct ansewr.");
		}
		else {
			System.out.println(answer + " is the wrong answer.");
			int x = 1;
			System.out.println("The correct answer is " + (Double.toString(Math.pow(var1 * Math.pow(x, var2), var3))));
		}
	}
	public static Boolean correct(String ans, int var1, int var2, int var3) {	
		int x = 1;
		return ans.equals((Double.toString(Math.pow(var1 * Math.pow(x, var2), var3))));
	}
}