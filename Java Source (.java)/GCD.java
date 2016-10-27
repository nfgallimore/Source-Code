import java.io.IOException;
public class GCD {
	public static void main(String[] args) throws IOException {
		// generates a random 1024 bit bigint
		BigInt b = new BigInt(new BigInt("").randBigInt(1).getStr());
		BigInt b2 = new BigInt(new BigInt("").randBigInt(1).getStr());
		System.out.println(b.getStr());
		System.out.println(b2.getStr());
		System.out.println(b.multiply(b2).getStr());

	}
	public static int gcd(int a, int m) {
		return (a % m == 0 ? m : gcd(m, a % m));
	}
}