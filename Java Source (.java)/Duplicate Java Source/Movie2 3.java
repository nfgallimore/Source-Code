class Movie2
{
	//3 instance variables
	private int acting;
	private int directing;
	private int script;

	// o-arg constructor
	public Movie2 ()
	{
	    acting = directing = script = 5;
	}

	// 3-arg constructor
	public Movie2 (int a, int d, int s)
	{
	    acting = a;
	    directing = d;
	    script = s;
	}

	public int rating ()
	{
	    return (acting + directing + script);
	}

}

