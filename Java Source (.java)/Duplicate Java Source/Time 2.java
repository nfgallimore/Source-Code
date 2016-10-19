class Time
{
  private int hour, minute;
  
  public Time (int h, int m) 
  {
    // 1
    this.hour = h;
    this.minute = m;
  }
  
  public Time addMinutes (int m)
  {
    int totalMinutes = (60*hour + minute + m) % (24*60);
    if (totalMinutes < 0)
      totalMinutes = totalMinutes + 24*60;
    return new Time (totalMinutes/60 , totalMinutes-(60*(totalMinutes/60))); // 2
  }
  
  public String toString ()
  {
    if ((hour == 0) && (minute == 0)) return "Midnight";
    else if ((hour == 12) && (minute == 0)) return "Noon"; // 3
    else
    {
      char c = 'P';
      if (hour < 12) c = 'A';
      int h = hour % 12;
      if (h == 0) h = 12;
      
      // this can also be accomplished by concatenating under conditionals
      return String.format("%d:%02d %cM", h, minute, c); // 4
    }
  }
  public boolean priorTo (Time t) 
  {
    // remember that we can conditional expressions resolve in boolean values
    return (60*hour + minute) % (24*60) < (60*t.hour + t.minute) % (24*60); //5
  }
  
  public static void main (String[] args)
  {
    Time dawn = new Time(6, 5);
    Time dusk = dawn.addMinutes(60*18);
    Time m = new Time (0, 0);
    System.out.println( dawn );
    System.out.println( dusk );
    System.out.println( m );
    
    if (m.priorTo(dusk)) System.out.println("Hello");
  }
}