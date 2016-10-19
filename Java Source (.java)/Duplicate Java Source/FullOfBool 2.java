class FullOfBull
{
    public static void main (String[] args)
    {
        boolean [] test1 = { false, true, true, true } ;
        boolean [] test2 = { true } ;
        boolean [] test3 = { true, true, true, true, false };
        
        fullOfBool(test1);
        System.out.println();
        fullOfBool(test2);
        System.out.println();
        fullOfBool(test3);
    }
    public static void fullOfBool(boolean [] array)
    {
        int count = 0;
        boolean found = false;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == true)
            {
                count++;
                if (found == false)
                {
                    System.out.println("The first true occurs at index " + i + ".");
                    found = true;
                }
            }
        }
        for (int i = array.length - 1; i >= 0; i-- )
            if (array[i] == true) { System.out.println("The last true occurs at index " + i + "."); break; }
        
        System.out.println("The total number of true values is " + count + ".");
    }
}
