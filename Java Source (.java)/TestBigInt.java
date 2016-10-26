import java.io.IOException;
public class TestBigInt {
	public static void main(String[] args) throws IOException {
		BigInt b = new BigInt("33");
		BigInt b2 = new BigInt("31");
		b.positive = false;
		System.out.println(b.lessThan(b2));
		System.out.println(b.subtract(b2).ls.toString());
	}
}