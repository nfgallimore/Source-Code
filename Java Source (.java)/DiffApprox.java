import java.util.Scanner;

public class DiffApprox
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		double x = 2;
		double newX = 2.001;
		double f = 10;
		double fPrime = -7;
		double g = -7;
		double gPrime = 8;

		System.out.println("x : ");
		x = keyboard.nextDouble();

		System.out.println("new x : ");
		newX = keyboard.nextDouble();

		System.out.println("f(x) : ");
		f = keyboard.nextDouble();

		System.out.println("f'(x) : ");
		fPrime = keyboard.nextDouble();

		System.out.println("g(x) : ");
		g = keyboard.nextDouble();

		System.out.println("g'(x) : ");
		gPrime = keyboard.nextDouble();



		double deltaX = newX - x;

		double methodOne = method1(x, deltaX, f, fPrime, g, gPrime);
		double methodTwo = method2(x, deltaX, f, fPrime, g, gPrime);

		System.out.println(methodOne);
		System.out.println(methodTwo);

	}
	public static double method1(double x, double deltaX, double f, double fPrime, double g, double gPrime)
	{
		return (fPrime * deltaX + f) * (gPrime * deltaX + g);
	}
	public static double method2(double x, double deltaX, double f, double fPrime, double g, double gPrime)
	{
		return (f * g + (f * gPrime + fPrime * g) * deltaX);
	}
	public static double fixedAbscissa(double x, double f, double fPrime, double g, double gPrime)
	{
		return (f * gPrime + fPrime * gPrime);
	}
}