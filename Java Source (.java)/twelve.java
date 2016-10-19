public class twelve
{
    public static void main(String[] args)
    {
        System.out.println("On the first day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the second day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the third day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the fourth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the fifth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the sixth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the seventh day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the eighth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the nineth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the tenth day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the eleventh day of Christmas,\nmy true love sent to me");
        list();
        System.out.println("On the twelveth day of Christmas,\nmy true love sent to me");
        list();
        
    }
    
    // list
    public static void list()
    {
        
        if (count == 11)
            twelveth();
        if (count >= 10)
            eleventh();        
        if (count >= 9)
            tenth();
        if (count >= 8)
            nineth();
        if (count >= 7)
            eighth();
        if (count >= 6)
            seventh();
        if (count >= 5)
            sixth();
        if (count >= 4)
            fifth();
        if (count >= 3)
            fourth();
        if (count >= 2)
            third();
        if (count >= 1)
            second();
        if (count >= 0)
            first();
        count++;
        System.out.println("");
    }
    
    // count
    public static int count = 0;
    
    // first
    public static void first()
    {
        System.out.println("a partridge in a pear tree.");
    }
    
    // second
    public static void second()
    {
        System.out.println("two turtle doves, and");
    }
    // third
    public static void third()
    {
        System.out.println("three French hens,");
    }
    public static void fourth()
    {
        System.out.println("four calling birds,");
    }
    public static void fifth()
    {
        System.out.println("five golden rings,");
    }
    public static void sixth()
    {
        System.out.println("six geese a-laying,");
    }
    public static void seventh()
    {
        System.out.println("seven swans a-swimming,");
    }
    public static void eighth()
    {
        System.out.println("eight maids a-milking,");
    }
    public static void nineth()
    {
        System.out.println("nine ladies dancing,");
    }
    public static void tenth()
    {
        System.out.println("ten lords a-leaping,");
    }
    public static void eleventh()
    {
        System.out.println("eleven pipers piping,");
    }
    public static void twelveth()
    {
        System.out.println("Twelve drummers drumming,");
    }
    
}