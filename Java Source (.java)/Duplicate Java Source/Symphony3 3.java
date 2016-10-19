	class Symphony3 extends Attraction
{
   private int conducting;
   private int playing;
   private int music;

   public Symphony3()
   {
       System.out.println("In the 0-arg Symphony3 constructor!");
       conducting = playing = music = 5;
   }

   public Symphony3 (int c, int p, int m)
   {
      System.out.println("In the 3-arg Symphony3 constructor!");
      conducting = c;
      playing = p;
      music = m;
   }

   public Symphony3 (String nameOfSymphony, int c, int p, int m)
   {
       this (c, p, m);
       name = nameOfSymphony;
   }

   public int getMusic ()    // simple example of a "getter"
   {
       return music;
   }


   public void setMusic (int m)
   {
       music = m;
   }

   public int rating()
   {
       return (conducting + playing + music) ;
   }

   public double rating( double scaleFactor)
   {
       return (conducting + playing + music ) * scaleFactor;
   }

   public String toString ()
   {
        return name + " is a Symphony3 object!";
   }
}
