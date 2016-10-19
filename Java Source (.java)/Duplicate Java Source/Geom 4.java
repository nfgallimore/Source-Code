/** Geom.java
 *  Plays with the geometry of line segments, using arrays & classes.
 *  It attempts to show that the median line-segments of
 *  the 3 sides of any triangle all meet at a single point.  
 *
 *  Uses classes Line and Point.
 *
 *      @author  Dr. Henry H. Leitner
 *      @version Last Modified June 28, 2013
 */

class Geom
{
    public static void main (String [] args)
    {   
        Point []  vertices = new Point [3]; 
        Point []  midpoints = new Point [3]; 
        Point []  intersections = new Point [3]; 
        Line  []  medians = new Line  [3];
     
        System.out.println 
                ("Type the coordinates of the vertices of a triangle:\n");
        for (int i = 0; i < 3; i++)  
        {    
           System.out.print ("\nVertex # "+ i + "\n"); 
           vertices[i] = new Point();
           vertices[i].input();
        }
        System.out.print ("\nVERTICES\n");
        for (int i = 0; i < 3; i++)     
            System.out.println ("  " + vertices[i]);

        midpoints[2] = vertices[0].midpoint( vertices[1] );
        midpoints[1] = vertices[2].midpoint( vertices[0] );
        midpoints[0] = vertices[1].midpoint( vertices[2] );
        System.out.print ("MIDPOINTS:\n");
        for (int i = 0; i < 3; i++)     
           System.out.println ("  " + midpoints[i]);
        
        System.out.print ("MEDIAN LINE EQUATIONS:\n");
        for (int i = 0; i < 3; i++)
        {   
           medians[i] = new Line (midpoints[i], vertices[i]);
           System.out.println ("  " + medians[i]);
        }
        intersections[2] =  medians[0].intersect( medians[1] );    
        intersections[0] =  medians[1].intersect( medians[2] );    
        intersections[1] =  medians[2].intersect( medians[0] );  
          
        System.out.print ("CENTERS\n");
        for (int i = 0; i < 3; i++)  
            System.out.print ("  " + intersections[i]);
        System.out.println();
    }
}
