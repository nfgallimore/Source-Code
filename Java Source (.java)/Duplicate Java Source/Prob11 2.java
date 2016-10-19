public class Prob11
{
    public static void main(String[] args)
    {
        drawFigure();
    }
    static void drawFigure()
    {
        for (int line = 1; line <= 5; line++)
        {
            for (int i = 1; i <= 20 - (line * 4); i++)
            {
                System.out.print("/");
            }
            for (int i = 1; i < (line * 4 - 4) * 2 + 1; i++)
            {
                System.out.print("*");
            }
            for (int i = 1; i <= 20 - line * 4; i++)
            {
                System.out.print("\\");
            }
            System.out.println();
        }
    }
}
