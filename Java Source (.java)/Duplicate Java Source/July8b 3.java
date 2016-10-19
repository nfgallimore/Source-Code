import Duck.java;
class July8b.java
{
    public static void main (String[] args)
    {
        Duck d = new Duck();
        d.size = 18;
        d.quack();

        
        Movie argo = new Movie(9, 10, 8);
        Movie lincoln = new Movie(8, 9, 7);
        Movie silverLinings = new Movie();
        
        System.out.println("rating of Argo = " + argo.rating());
        System.out.println("rating of Lincoln = " + lincoln.rating());
    }
}
