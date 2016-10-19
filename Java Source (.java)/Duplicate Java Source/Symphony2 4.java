class Symphony2
{
   private int conducting;
   private int playing;
   private int music;

   public Symphony2 ()
   {
      conducting = playing = music = 5;
   }

   public Symphony2 (int c, int p, int m)
   {
      conducting = c;
      playing = p;
      music = m;
   }

   public int getMusic()
   {
       return music;
   }

   public void setMusic (int m)
   {
      music = m;
   }

   public int rating ()
   {
      return (conducting + playing + music);
   }
    
   public double rating (double scaleFactor)
   {
      return (conducting + playing + music) * scaleFactor;
   }
}
