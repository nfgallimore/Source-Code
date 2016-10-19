class Symphony
{
    int music;
    int playing;
    int conducting;

    Symphony (int m, int p, int c)    // Constructor
    {
       music = m;
       playing = p;
       conducting = c;
    }

    int rating ()
    {
        return (music + playing + conducting);
    }  

    double rating (double scaleFactor)
    {
        return  scaleFactor * (music + playing + conducting);
    }
}
