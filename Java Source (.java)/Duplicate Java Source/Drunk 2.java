import java.lang.Math;

public class Drunk
{
    public static void main(String[] args)
    {
        final int N = 5;
        double sum = 0;
        for (int i = 0; i < N; i++)
            sum += drunkWalk();
        System.out.println("Average # of steps equals " + sum / N);
    }
    public static int drunkWalk()
    {
        int count = 5;
        int steps = 0;
        System.out.println("Here we go again... time for a walk!");
        do
        {
            steps++;
            if (Math.random() > .5)
                count++;
            else
                count--;
        }
        while (count < 10 && count > 0);
        System.out.print("Took " + steps + " steps, and\nLanded at ");
        if (count == 0)
            System.out.println("HOME\n");
        else
            System.out.println("JAIL\n");
        return steps;
    }
}