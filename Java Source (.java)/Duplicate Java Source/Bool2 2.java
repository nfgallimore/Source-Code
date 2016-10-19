public class Bool2
{
    public static void main(String[] args)
    {
        boolean p = true;
        boolean q = false;
        boolean r = true;
        if ((p && q) || (!r))
            System.out.println("true");
        else System.out.println("false");   
        if (!(p && (q || !r)))
            System.out.println("true");
        else System.out.println("false");
    }
}

