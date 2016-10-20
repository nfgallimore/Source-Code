class Expression {
	   String a;
	   String b;
	   char operator;
}
public class Calculator
{

	private final static char[] operators = new char[] {'+', '-', '*', '/', '<', '>', '=', '^', '%', '|'};
	private static Boolean run;
	public static void main(String[] args) throws java.io.IOException {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		do {
			update(scanner.nextLine());
		} while (scanner.hasNextLine() && !run);
	}

	public static void update(String input) throws java.io.IOException {
		Expression exp = parse(input);
		if (exp.operator == '+') {
			System.out.println(": " + new BigInt(exp.a).add(new BigInt(exp.b)).getStr());
		}
		else if (exp.operator == '-') {
			System.out.println(": " + new BigInt(exp.a).subtract(new BigInt(exp.b)).getStr());
		}
		else if (exp.operator == '*') {
			BigInt product = new BigInt("");
			for (BigInt i = new BigInt(exp.b); !i.equal(new BigInt("0")); i = i.subtract(new BigInt("1"))) {
				product = product.add(new BigInt(exp.a));
			}
			System.out.println(product.getStr());
		}
		run = false;
	}
	public static Expression parse(String input) {
		String str = input.replaceAll("\\s","");
		char operator = '\0';
		String a = "", b = "";
		for (char c : str.toCharArray()) {
			for (char o : operators) {
				if (c == o) {
					operator = o;
					break;
				}
			}
			if (operator == '\0') {
				a += c;
			}
			else {
				b += c;
			}
		}
		b = b.substring(1, b.length());
		Expression exp = new Expression();
		exp.a = a;
		exp.b = b;
		exp.operator = operator;
		return exp;
	}
}