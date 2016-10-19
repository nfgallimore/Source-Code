public class PPTest
{
    public static void main(String [] args)
    {
        boolean quiz[] = new boolean[20];
        for (int i = 0; i < 20; i++)
        {
            if (i % 2 == 0)
                quiz[i] = true;
            else
                quiz[i] = false;
            System.out.println(quiz[i]);
        }
        double family[] = new double[12];
        int year = 1900;
        for (int i = 0; i < 12; i++)
        {
            
            System.out.print(year + " ");
            family[i] = i;
            System.out.print(family[i] + "\n");
            year += 10;
        }
        double rainfall[][] = new double[12][5];
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                rainfall[i][j] = j;
                System.out.print(rainfall[i][j] + 1 + " ");
            }
            System.out.println();
        }
       // System.out.println(family[0]);
        class
    }
}