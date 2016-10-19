public class Kelvin
{
    public static void main(String[] args)
    {
        final double K = 273.16;
        for (int farenheight = 32; farenheight <= 100; farenheight++)
        {
            double kelvin = 5.0/9.0 * (farenheight - 32.0) + K;
            System.out.println("The Kelvin equivalent of " + farenheight + " degrees Farenheight is: " + kelvin);
    
        }
    }
}