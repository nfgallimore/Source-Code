public class Triangle
{
    public static void main(String[] args)
    {
        // alignment supported up to 52 ROWS
        final int ROWS = 9;
        
        // Prints ROW # of rows
        for (int row = 1; row <= ROWS; row++)
        {
            // Sets the amount of numbers per row
            for (int numsInRow = 1; numsInRow <= row; numsInRow += row)
            {
                // Set j to 0 to start at 100, set j to 2 to start at 300
                for (int j = 0, horizSum = 0; j < row; j++)
                {
                    // adds row * 2 as iterating towards the bottom of each column
                    horizSum = row * 2 - 2;
                    int result = row * 100 + j * horizSum;
                    
                    // fix for alignment with numbers larger than 1000
                    if (row < 10)
                        System.out.print(result + "  ");
                    else
                        System.out.print(result + " ");
                }
                // prints a new line
                System.out.println();
            }

        }
    }
}