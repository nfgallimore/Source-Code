public class Calculator {
	public static void main(String[] args) throws java.io.IOException {
		do {
			System.out.println("Calculator $ ");
			new java.util.Scanner(System.in).next()
			update();
		while (new java.util.Scanner(System.in).hasNext())
	}
	public static void update() {
		BigInt b = new BigInt();
		System.out.println(add(a, b));
	}
	public static String addition(BigInt a, BigInt b) throws java.io.IOException {
		return a.getStr() + " + " + b.getStr() + " = " + a.add(b).getStr();
	}
	public static void options() {
		char[] {'+', '-', '*', '/', '<', '>', '=', '^', '%', '|'};
		System.out.println("Select an operation:");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. /");
		System.out.println("5. <");
		System.out.println("6. >");
		System.out.println("7. Equal");
		System.out.println("8. Exp");
		System.out.println("9. Log");
		System.out.println("10. Mod");
		System.out.println("11. Divisible");
	}
}