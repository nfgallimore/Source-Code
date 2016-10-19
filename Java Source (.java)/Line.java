/** Line.java
 *  Defines the class Line
 *
 *      Dr. Henry H. Leitner
 *      Last Modified June 23, 2013
 */

public class Line   // represents line as "ax + by = c"
{   
    private double a, b, c;
    
    public Line ()
    {
          a = 1.0; b = 1.0; c = 1.0;
    }
    
    public  Line (double a1, double b2, double c3) 
    { 
          a = a1; b = b2; c = c3;  
    } 
    
    // construct the line defined by points 'p1' and 'p2'.
    public Line (Point p1, Point p2)
    {   
        a = p1.getY() - p2.getY();
        b = p2.getX() - p1.getX();
        c = p1.getY() * p2.getX() - p2.getY() * p1.getX();
        if (a < 0)
        {  
            a = - a;
            b = - b;
            c = - c;
        }
    }

    // return the point at which 'this' and 'L2' intersect
    public Point intersect (Line L2) 
    {    
        double denominator = a * L2.b - b * L2.a;    
        return new Point ( (c * L2.b - b * L2.c) / denominator, 
                               (a * L2.c - c * L2.a) / denominator); 
    }
               
    // return the line defined by points 'p1' and 'p2'.
    // DUPLICATES Line (pt1, pt2) above
    public static Line connect (Point p1, Point p2)
    {   
        double a, b, c;

        a = p1.getY() - p2.getY();
        b = p2.getX() - p1.getX();
        c = p1.getY() * p2.getX() - p2.getY() * p1.getX();
        if (a < 0)
        {   a = - a;
            b = - b;
            c = - c;
        }
        return new Line (a, b, c);
    }

    public String toString()
    { 
        return a + " * x + " + b + "  * y = " + c;
    }
    
    /* for testing
    public static void main (String[] args)
    {
        Line L1 = new Line (new Point(0, 2), new Point(2,0));
        Line L2 = new Line (new Point(0,0), new Point(2,2));

        System.out.println (L1);    // applies toString() automatically!
        System.out.println (L2);
        System.out.println (L1.intersect(L2));
    }
    */
}
