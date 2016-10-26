import java.io.IOException;
public class GCD {
	// GCD(a, b)
	public int res;
	public int a;
	public int b;

	public GCD(int _a, int _b) {
		a = _a;
		b = _b;
		res = a % b;
		while (a != 0 && b != 0 && (res != 1 && res != 0)){
			res = a % b;
			b = res;
			a = b;
		}
		if (res == 0) {
			res = b;
		}
		System.out.println(res);
	}
	// TODO
	public GCD(BigInt a, BigInt b) throws IOException {

	}
}