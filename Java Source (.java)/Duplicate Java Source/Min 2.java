public class Min
{
    public static void main(String[] args)
    {
        int min = myMin(4, 4, 4);
        System.out.println(min);
    }
    public static int myMin(int a, int b, int c)
    {
        return Math.min(a, Math.min(b,c));
    }
}
