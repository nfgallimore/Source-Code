public class Drawing
{
    public static void main(String[] args)
    {
        shape();
        newline();
        line();
        newline();
        shape();
        newline();
        line();
        bottom();
        newline();
        top();
        line();
        bottom();
        
    }
    static void top()
    {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }
    static void bottom()
    {
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }
    static void line()
    {
        System.out.println("-\"-'-\"-'-\"-");
    }
    static void shape()
    {
        top();
        bottom();
    }
    static void newline()
    {
        System.out.println();
    }
}