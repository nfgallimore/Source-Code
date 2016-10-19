class Symphony
{
    int music;
    int playing;
    int conducting;
    
    int rating()
    {
        return (music + playing + conducting);
    }
    
    double rating (double scaleFactor)  
    {
        return scaleFactor * (music + playing + conducting);
    }
}
