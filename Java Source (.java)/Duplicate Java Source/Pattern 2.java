public class Pattern
{
    public static void main(String[] args)
    {
        final int HEIGHT = 5;
        

        for (int line = 0; line < HEIGHT; line++)
        {
            for (int spaces = 0; spaces < line; spaces++)
                System.out.print(" ");
            for (int stars = line; stars < HEIGHT; stars++)
                System.out.print("*");
            System.out.println();
        }
    }
}