public class song
{
    public static void main(String[] args)
    {
        // fly
        line();
        swallowed();
        System.out.println("fly");
        System.out.println("I don't know why she swallowed the fly");
        System.out.println("Perhaps she'll die");
        System.out.println("But it's only a fly");
        System.out.println("I think I'll cry");
        System.out.println("She gulped it out of the sky\nOh, my!\n");
        swallowed();
        
        // spider
        System.out.println("spider");
        System.out.println("That wiggled and jiggled and tickled inside her.");
        System.out.println("She swallowed the spider to catch the fly");
        why();
        die();
        System.out.println("Gone to the by and by\nSigh");
        line();
        
        // bird
        swallowed();
        System.out.println("bird.");
        System.out.println("How absurd! She swallowed a bird!");
        bird();
        System.out.println("She swallowed the spider to catch the bird");
        why();
        die();
        System.out.println("She'll leave us high and dry.");
        line();
        
        // cat
        swallowed();
        System.out.println("cat.");
        System.out.println("Imagine that! She swallowed a cat.");
        cbswd();
        System.out.println("I hope it's a lie.");
        line();
        
        // dog
        swallowed();
        System.out.println("dog.");
        System.out.println("She went whole hog to swallow the dog.");
        dog();
        cbswd();
        System.out.println("There's a tear in my eye");
        line();
        
        // cow
        swallowed();
        System.out.println("cow.");
        System.out.println("I don't know why the swallowed the cow.\nShe swallowed the cow to catch the dog.");
        dog();
        cbswd();
        System.out.println("I'd rather have ham on rye.");
        System.out.println("And she had a frog on the sly.");
        System.out.println("She did it in one try.");
        line();
        
        // horse
        swallowed();
        System.out.println("horse.");
        System.out.println("She died, of course.");
        System.out.println("It was the last course.");
        System.out.println("I' filled with remorse.");
        System.out.println("What's left to say...");
        System.out.println("Even the artist is crying.");
        System.out.println("We'll miss her dearly.\nIt is such a loss.\nShe had no time to floss.\nShe missed out on the sauce.\n\nMoral: Never swallow a horse.");
        line();
        
        
        
        
    }
    
    // fly, spider, bird, cat, dog, cow
    public static void swallowed()
    {
        System.out.print("There was an old lady who swallowed a ");
    }
    public static void line()
    {
        System.out.println("");
    }
    public static void die()
    {
        System.out.println("Perhaps she'll die.");
    }
    public static void why()
    {
        System.out.println("I don't know why\nShe swallowed the fly");
    }
    public static void cat()
    {
        System.out.println("She swallowed the cat to catch the bird.");
    }
    public static void bird()
    {
        System.out.println("She swallowed the bird to catch the spider.");
    }
    public static void spider()
    {
        System.out.println("She swallowed the spider to catch the fly.");
    }
    public static void cbswd()
    {
        cat();
        bird();
        spider();
        why();
        die();
    }
    public static void dog()
    {
        System.out.println("She swallowed the dog to catch the cat.");
    }
            
}