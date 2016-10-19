public class expression
{
    
    // macro to give x a real number variable
    public static final double X = 0;
    
    public static void main(String[] args)
    {
        // breaks down function by operands
        double y0 = 12.3;
        double y1 = 9.1;
        double y2 = 19.3;
        double y3 = 4.6;
        double y4 = 34.2;
        
        // sets a changable variable for x
        double x = X;
        
        for (double i = 0; i <= 4; i++)
        {
            x = Math.pow(X,i);
            if (i == 4)
                y0 *= x;
        
            if (i == 3)
                y1 *= x;

            if (i == 2)
                y2 *= x;
            
            if (i == 1)
                y3 *= x;
            
        }
      
        
        
        // final computation
        double y = y0 - y1 + y2 + y3 + y4;
        
        // prints results
        System.out.println("\nThe result when x = " + X + " is " + y + "\n\n y0 = " + y0 + "\n y1 = " + y1 + "\n y2 = " + y2 + "\n y3 = " + y3 + "\n y4 = " +  y4 + "\n");
        
    }
}

        
        
        
        

        
        /*
   
   
        // decrements x's exponent
        int exp = 4;
        
        // calculates 12.3x^4
        for (int j = 0; j < exp; j++)
            y0 * powerup();
        exp--;
            
        // calculates 9.1x^3
        for (int j = 0; j < exp; j++)
            y1 (x *= x);
        exp--;
            
        // calculates 19.3x^2
        for (int j = 0; j < exp; j++)
            y2 (x *= x);
        exp--;
            
        // calculates 4.6x
        for (int j = 0; j < exp; j++)
            y3 *= x;
        exp--;
    }
        

    
    }

} */