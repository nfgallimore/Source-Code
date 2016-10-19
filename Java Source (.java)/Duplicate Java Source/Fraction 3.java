import java.util.Scanner;
public class Fraction
{
    public static void main(String[] args)
    {
        char amPm = 'A';
        int noon = 0;
        
        System.out.println(" Time         Fraction since midnight");
        for (int hour = 12; hour <= 12; hour++)
        {
            if (hour == 12 && noon == 3) return;
            if (hour < 10) System.out.print(" ");
            if (hour == 12 && noon < 2)
            {
                if (noon == 1) { amPm = 'P'; noon = 3; hour = 0; }
                if (noon == 0) noon = 1;
                hour = 0;
            }
            if (hour == 0)
                System.out.print("12:00 " + amPm + "M      ");
            else
                System.out.print(hour + ":" + "00 " + amPm + "M      ");
                System.out.printf("%.3f\n", fractionOfDay((double)hour, 0, 0, amPm));
        }
    }
    public static double fractionOfDay(double hour, double min, double sec, char amPm)
    {
        if (amPm == 'P') hour += 12;
        return (
                ((double)hour / 24) +
                ((double)min / 60 / 24) +
                ((double)sec / 60 / 60 / 24)
                );
    }
    
}


