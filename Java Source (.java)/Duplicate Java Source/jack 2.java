public class jack
{
    // main function
    public static void main(String[] args)
    {
        line();
        System.out.println("This is the house that Jack built.");
        list();
        System.out.println("This is the malt");
        list();
        System.out.println("This is the rat,");
        list();
        System.out.println("This is the cat,");
        list();
        System.out.println("This is the dog,");
        list();
        System.out.println("This is the cow with the crumpled horn,");
        list();
        System.out.println("This is the maiden all forlorn");
        list();
    }
    
    // count for list
    public static int count = 0;
    
    // list
    public static void list()
    {
        if (count > 5)
            cow();
        if (count > 4)
            dog();
        if (count > 3)
            cat();
        if (count > 2)
            rat();
        if (count > 1)
            malt();
        if (count > 0)
            house();
        count++;
        line();
    }
    23
    
    /******************************************************************
    // prints line functions
    ******************************************************************/
    
    public static void line()
    {
        System.out.println("");
    }
    public static void house()
    {
        System.out.println("That lay in the house that Jack built.");
    }
    public static void malt()
    {
        System.out.println("That ate the malt");
    }
    public static void rat()
    {
        System.out.println("That killed the rat,");
    }
    public static void cat()
    {
        System.out.println("That worried the cat,");
    }
    public static void dog()
    {
        System.out.println("That tossed the dog,");
    }
    public static void cow()
    {
        System.out.println("That milked the cow with the crumpled horn,");
    }
                    
}