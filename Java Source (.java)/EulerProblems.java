import java.io.IOException;
import java.math.*;
public class EulerProblems
{

	public static void main(String[] args) throws IOException {

		System.out.println(problemOne(3, 5, 1000));
		System.out.println(problemTwo());
		System.out.println(problemThree());
		System.out.println(problemFour());
	}

	// when n1 = 3, n2 = 5, max = 1000 finds the sum of all of the multiples of 3 or 5 less than 1000
	public static int problemOne(double n1, double n2, double max) {

		return (int)(

			// sum of all of the multiples of 3
			.5 * Math.floor((max - 1) / n1) 
				* (n1 + (n1 * Math.floor((max - 1) / n1)))

			// sum of all of the multiples of 5
			+ .5 * Math.floor((max - 1) / n2) 
				* (n2 + (n2 * Math.floor((max - 1) / n2)))

			// sum of the multiples of 15
			- .5 * Math.floor((max - 1) / (n1*n2))
				* (n1*n2 + (n1*n2 * Math.floor( (max - 1) / (n1*n2) )))
			
			);
	}

	public static int problemTwo() {

		int a1 = 1, a2 = 2, sum = 0;
		// 4 million
		while (a2 < 4000000) {
			int a3 = a1 + a2;
			if (a2 % 2 == 0) sum += a2;
			a1 = a2;
			a2 = a3;
		}
		return sum;

	}

	// finds the greatest prime factor of 600,851,475,143
	public static BigInteger problemThree() {

		BigInteger
		numConst = new BigInteger("600851475143"),
		num = numConst,
		zero = new BigInteger("0"),
		one = new BigInteger("1"),
		count = new BigInteger("2"), // 2 is the first prime number
		largestFactor = zero,
		countSq = zero;

		while (num.compareTo(countSq) == 1 || num.compareTo(countSq) == 0) {
			if (num.mod(count).compareTo(zero) == 0) {
				num = num.divide(count);
				largestFactor = count;
			}
			else {
				count = count.add(one);
				countSq = count.multiply(count);
			}
		}
		if (num.compareTo(largestFactor) == 1) largestFactor = num;
		return largestFactor;

	}

	// Finds the largest palindrome made from the product of two 3-digit numbers.
	public static int problemFour() {
		int max = 0;
		for (int i = 999; i > 0; i--) {
			for (int j = 999; j > 0; j--) {
				String str = Integer.toString(i * j);
				String rev = "";
				for (int k = 0; k < str.length(); k++) {
					int len = str.length() - 1 - k;
					rev += str.charAt(len);
				}
				if (str.equals(rev)) {
					if (i * j > max) {
						max = i * j;
					}
				}
			}
		}
		return max;
	}
	
}