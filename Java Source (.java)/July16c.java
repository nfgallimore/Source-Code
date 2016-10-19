class July16c
{
    static void foobar (int a, double d)
    {
       System.out.println ("Hello!");
    }


    static void foobar (double d, int a)
    {
        System.out.println ("World!");
    }

    public static void main (String [] args)
    {
        foobar (3.141, 17);

        foobar (19, 2.2);

        foobar (34, 35);
    }
 }   

