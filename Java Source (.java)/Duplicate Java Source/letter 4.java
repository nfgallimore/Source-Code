public class letter
{
    public static void main(String[] args)
    {
        parents();
        john();
        sister();
    }

    // classes
    public static void classes()
    {
        System.out.println("My classes are awesome!");
    }

    // friends
    public static void friends()
    {
        System.out.println("I've made tons of friends since I've been here, but I can't do anything with them.");
    }

    // lovelife
    public static void lovelife()
    {
        System.out.println("I've gone on quite a few dates since I've been here, but I haven't found the right girl yet.");
    }

    // hobbies
    public static void hobbies()
    {
        System.out.println("I played ultimate frisbee the other day, it was super fun and I am looking forward to playing dodgeball next week.");
    }

    // money
    public static void money()
    {
        System.out.println("Can I borrow some money please? I promise I'll pay you back.");
    }

    // parents
    public static void parents()
    {
        System.out.println("Dear Mom,");
        classes();
        friends();
        money();
        line();
    }

    // friends
    public static void john()
    {
        System.out.println("Dear Kyle,");
        lovelife();
        classes();
        hobbies();
        line();
    }

    // sister
    public static void sister()
    {
        System.out.println("Dear Jenn,");
        hobbies();
        friends();
        money();
        line();
    }
    
    //new line
    public static void line()
    {
        System.out.println("\n");
    }
}

