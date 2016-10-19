// Authored by Nicholas F. Gallimore on July 4th, 2013.
// Intended for Great Ideas in Computer Science Using Java at Harvard University Summer of 2013.
// Prof. Henry Leitner PHD Harvard University

import java.util.*;
import java.io.*;
import java.text.DateFormatSymbols;

public class Easter
{
    // note - I went above and beyond and implemented BC, but then I remembered Easter was the day that marked AD / BC
    // derp.
    
    public static void main(String[] args)
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nInput a year followed by BC if applicable (e.g. 2001 or 2001 BC):\n ");
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String s = in.nextLine();
        boolean bc = false;
        int y = year;
        if (s.equals(" BC") == true)
        {
            y -= y * 2;
            bc = true;
        }
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;
        String month = getMonth(n);
        
        /* Debugging 
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d + ", e = " + e);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("j = " + j + ", k = " + k);
        System.out.println("m = " + m);
        System.out.println("r = " + r);
        System.out.println("n = " + n);
        System.out.println("p = " + p);
        */ 

        System.out.println();
        if (bc == true)
            System.out.println("Easter day in " + y * -1 + " B.C. WOULD have been on " + month + " " + p + " if Jesus would've arrived ahead of schedule.");
        else if (year < 2014)
            System.out.println("Easter day in " + y + " was on " + month + " " + p + ".");
        else
            System.out.println("Easter day in " + y + " is on " + month + " " + p + ".");
        System.out.println();
        
    }
    
    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }
}