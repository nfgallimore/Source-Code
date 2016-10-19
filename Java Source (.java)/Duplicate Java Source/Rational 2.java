  /* Euclid's Algorithm for Greatest Common Divisor
   Given m, and n ...
   Step 1:  Divide first number by second number
             In other words, divide m by n
   Step 2:  If there's a remainder of 0, all done
             because n is the GCD
   Step 3:  Otherwise replace m by the value of n
             replace n by the remainder of previous
             division.
            Now GO BACK TO STEP #1
  */
class Rational
{
    // first defining the instance variabls
    private int numerator;
    private int denominator;

    // Step 2: define constructors
    Rational (int a, int b)
    {
        // Tells how to make a Rational or a Pizza
    }
    Rational (int n)
    {
      numerator = n;
      denominator = 1;
    }
    Rational (Rational r)
    {
      numerator = r.numerator;
      denominator = r.denominator;
    }
    Rational ()
    {
      numerator = 0;
      denominator = 1;
    }
    Rational mulRat (Rational multiplier)
    {
      int top = this.numerator * multiplier.numerator;
      int bottom = this.denominator * multiplier.denominator;
      return new Rational (top, bottom);
    }
    Rational addRat (Rational addend)
    {
      int bottom = denominator * addend.denominator;
      int top = numerator * addend.denominator +
	          denominator * addend.numerator;
      return new Rational (top, bottom);
    }
    boolean lessThanRat(Rational a)
    {
      if ( (this.numerator / this.denominator) < (a.numerator / a.denominator) )
        return true;
      else
        return false;
    }
    public String toString()
    {
         return numerator + " / " + denominator;
    }
    
} 