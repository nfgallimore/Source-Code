public class cat
{
    public static void main(String[] args)
    {
        line();
        System.out.println("Bought me a cat and the cat pleased me,\nI fed the cat under yonder tree.");
        list();
        System.out.println("Bought me a hen and the hen pleased me,\nI fed my hen under yonder tree.");
        list();
        System.out.println("Bought me a duck and the duck pleased me,\nI fed my duck under yonder tree.");
        list();
        System.out.println("Bought me a goose and the goose pleased me,\nI fed my goose under yonder tree.");
        list();
        System.out.println("Bought me a sheep and the sheep pleased me,\nI fed my sheep under yonder tree.");
        list();
        
    }
    public static int count = 0;
    
    public static void list()
    {
        if (count > 3)
            sheep();
        if (count > 2)
            goose();
        if (count > 1)
            duck();
        if (count > 0)
            hen();
        if (count >= 0)
            cat();
        count++;
        line();
    }
    public static void line()
    {
        System.out.println("");
    }
    public static void sheep()
    {
        System.out.println("Sheep goes baa, baa,");
    }
    public static void goose()
    {
        System.out.println("Goose goes hissy, hissy,");
    }
    public static void duck()
    {
        System.out.println("Duck goes quack, quack,");
    }
    public static void hen()
    {
        System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
    }
    public static void cat()
    {
        System.out.println("Cat goes fiddle-i-fee.");
    }
}