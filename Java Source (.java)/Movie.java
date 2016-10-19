class Movie
{
   // first, define the instance variables (state)

   int acting;
   int directing;
   int script;

   // second, define the instance methods (behavior)
   int rating ()
   {
      return  (acting + directing + script);
   }

   // third, define some constructors
   Movie ()
   {
      acting = directing = script = 5;
   }

   Movie (int s, int d, int a)
   {
       script = s;
       directing = d;
       acting = a;
   }     
}   
