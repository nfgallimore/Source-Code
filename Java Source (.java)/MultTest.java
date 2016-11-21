import java.io.IOException;
import java.math.*;
public class EulerProblems {
	public static void main(String[] args) throws IOException {
		System.out.println(problemOne(3, 5, 1000));
	}
	public static int problemOne(double n1, double n2, double max) {
		return (int)(.5 * Math.floor((max - 1) / n1) * (n1 + (n1 * Math.floor((max - 1) / n1))) + .5 * Math.floor((max - 1) / n2) * (n2 + (n2 * Math.floor((max - 1) / n2))) - .5 * Math.floor((max - 1) / (n1 * n2)) * (n1 * n2 + (n1 * n2 * Math.floor((max - 1) / (n1 * n2)))));
	}
}