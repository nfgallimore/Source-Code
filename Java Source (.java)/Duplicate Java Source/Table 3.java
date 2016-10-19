// Table class is part of the Lnim program
// Author: Henry H. Leitner
// Last modified: June 23, 2012

class Table
{
   private int [] [] array;
	
   Table (int numberOfRows, int numberOfColumns)
   {
       array = new int [numberOfRows] [numberOfColumns];
   }
	
   void initialize( int aValue)
   {
      for (int row = 0; row < array.length; row++ )
	   for (int col = 0; col < array[row].length; col++ )
		    array[row][col] = aValue;
   }
   
    
    void setValue(int row, int col, int aValue)
    {
         array[row][col] = aValue;
    }
   
    void displayValues()
    {      
       for (int row = 1; row < array.length; row++)
         for (int col = 2; col < array[row].length; col++)
         {
             TxtGrph.position (2*row+2, 5*col+1);
             System.out.printf ("%3d", array[row][col]);
         }
     }
     
    
     void displayOutline()
     {
        int numberOfColumns = array[0].length-1;
        TxtGrph.eraseAll();         // first, clear the screen
        for (int i = 0; i < array.length-1; i++)
        {
            TxtGrph.position (2*i+3, numberOfColumns-1);
            System.out.print ("+----+----+----+----+----+----+----+----+----+----+");
            TxtGrph.position (2*i+4, numberOfColumns-1);
            System.out.print ("|    |    |    |    |    |    |    |    |    |    |");
        }
        TxtGrph.position (2*array.length+1, numberOfColumns-1);
        System.out.print ("+----+----+----+----+----+----+----+----+----+----+");
	    TxtGrph.setReverse();
        for (int i = 2; i <= numberOfColumns; i++)
        {
            TxtGrph.position (2*array.length+2, 5*i+2);
            System.out.printf ("%3d", i);
        }
        for (int i = 1; i <= 3; i++)
        {
            TxtGrph.position (2*i+2, 62);
            System.out.printf ("%2d", i);
        }
	    TxtGrph.setNormal();
        displayValues();
        TxtGrph.position (20,1);
    }
     
    
    void reinforce (Table winning, Table losing)
    {
       for (int row = 1; row < array.length; row++)
           for (int col = 2; col < array[row].length; col++)
              array [row][col] += winning.array [row][col] 
                                 - losing.array [row][col];
     
        // we rewarded every move made by the winning player,
        // and punished every move made by the losing player.
    }
    
    // This function looks at the "triple" of values in column left and
    // returns the index of the largest entry in the triple,
    // "Random numbers" are used to resolve ties.  This number
    // will tell function TAKE_SOME_MATCHES the optimal number
    // of matches to take from the NIM pile!
        
    int chooseOneToThree (int left)
    {
        if (array[1][left] == array[2][left] && 
		 array[2][left] == array[3][left]) 
            return (int) (Math.random()*3) + 1;
        int i = 1;          // start by assuming that box #1 
                            // contains the largest entry! 
        for (int j = 2; j <= 3; j++)
            if (array[i][left] < array[j][left] || 
               (array[i][left] == array[j][left] && Math.random() > 0.5))
                i = j;
     
        // in the FOR loop, we changed i to j in case entry j is
        // larger than entry i, or -- with probability .5 -- in
        // case they are equal
            
        return i ;   // convert subscript to # of matches to take 
    }
     
     

    // Parameter LEFT specifies how many matches currently
    // are left in the NIM pile.  This function will return
    // how many matches should be taken from the pile, by looking
    // at the past HISTORY table (based on the number of matches
    // left right now)

    int takeSomeMatches (int left)
    {
        int choice;
     
        do
            choice = chooseOneToThree (left);
        while (choice >= left);
     
        return choice;
    }
     
 }
