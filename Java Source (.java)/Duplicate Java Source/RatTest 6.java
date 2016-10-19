// RatTest.java

/**
 *  Driver program to demo the Rational class 
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified June 28, 2012
 */

class RatTest
{
    public static void main (String [] args)
    {
        Rational a = new Rational (9, 12);
        Rational b = new Rational (6);
        Rational c = new Rational (a);  // 'c' is a copy of 'a'
        Rational d = a;                 // 'd' is NOT a copy of 'a'

        System.out.println("a = " + a + " and b = " + b);
        System.out.println ("c = " + c);

        c = a.addRat (b);
        System.out.println("c = " + c + " and a = " + a);
        a = b.mulRat (c);
        System.out.println("a = " + a + " and d = " + d);   
    }
}
