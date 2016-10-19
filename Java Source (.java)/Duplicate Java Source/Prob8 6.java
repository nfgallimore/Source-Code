public class Prob8
{
    public static void main(String[] args)
    {
        print64x();
    }
    static void print4x()
    {
        System.out.println("Controlling complexity is the essence of programming!");
        System.out.println("Controlling complexity is the essence of programming!");
        System.out.println("Controlling complexity is the essence of programming!");
        System.out.println("Controlling complexity is the essence of programming!");
    }
    static void print8x()
    {
        print4x();
        print4x();
    }
    static void print16x()
    {
        print8x();
        print8x();
    }
    static void print32x()
    {
        print16x();
        print16x();
    }
    static void print64x()
    {
        print32x();
        print32x();
    }
    
    
}