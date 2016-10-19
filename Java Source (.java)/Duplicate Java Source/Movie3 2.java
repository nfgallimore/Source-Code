class Movie3 extends Attraction
{
    protected int script;
    protected int directing;
    protected int acting;

    Movie3 ()
    {
        System.out.println("In the 0-arg Movie3 constructor!");
        script = 5;
        directing = 5;
        acting = 5;
    }

    Movie3 (int s, int d, int a)
    {
        System.out.println("In the 3-arg Movie3 constructor!");
        script = s;
        directing = d;
        acting = a;
    }

    Movie3 (String nameOfMovie, int s, int d, int a)
    {
        this( s, d, a);
        System.out.println("In 4-arg Movie3 constructor!");
        name = nameOfMovie;
    }

    public String toString()
    {
        return name + " is a Movie3 object!";
    }

    Movie3 (String nameOfMovie, int runningTime, int s,
             int d, int a)
    {
        this (nameOfMovie, s, d, a);
        System.out.println("In 5-arg Movie3 constructor!");
        time = runningTime;
    }


    public int rating ()
    {
        return ( script+directing+acting );
    }
}
