// This program does not compile.  How come?
public class BadExample
{
    public static void main(String[] args)
    {
        int x = 3;
        int y = 7;
        computeSum(x, y);
    }
    public static void computeSum(int x, int y)
    {
        int sum = x + y;
        System.out.println ("sum = " + sum);
    }
}