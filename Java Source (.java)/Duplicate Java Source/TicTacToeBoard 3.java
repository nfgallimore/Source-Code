/*
*	Tic-Tac-Toe Board
*
*	Nick Gallimore & Daniel Borges
*
*	Counterpart program to TicTacToe
*/


class TicTacToeBoard
{  
 	public char[][] grid = new char [3][3];				// creates 3x3 grid

 	public TicTacToeBoard()
 	{
  		this.reset();									// resets the board each new game
 	}
 
 	public TicTacToeBoard (int a, int b, int playerTurn, TicTacToeBoard board)
 	{
  		this.grid = board.grid;
  		if (grid[a][b] == ' ')							// If the character at row a, column b is blank...
  		{
   			if (playerTurn == 1) grid[a][b] = 'X';		// ...draws X for player 1...
    			else grid[a][b] = 'O';						// ...or O for player 2.
  		}
	} 
	
 	public char[][] reset()								// resets the grid board to blanks
 	{
  		for (int i = 0; i < grid.length; i++)
   			for (int j = 0; j < grid[i].length; j++)
    			grid[i][j] = ' ';
   		return grid;
 	}

 	public void print(TicTacToeBoard board)				// prints the board
 	{
  		System.out.println("\nGame board:");
  		for (int i = 0; i < board.grid.length; i++) 
  		{
   			System.out.print("| ");
   			for (int j = 0; j < board.grid[i].length; j++)
        		System.out.printf("%c ", board.grid[i][j] );
   			System.out.println("|");
  		}
  		System.out.println();
 	}
 
 	public boolean gridCheck(TicTacToeBoard board)		// if any winning circumstance exists, returns true
 	{
 		if ((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X' || grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') ||
   			(grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X' || grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') ||
   			(grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X' || grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') ||
   			(grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X' || grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') ||
   			(grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X' || grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') ||
   			(grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X' || grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') ||
   			(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X' || grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') ||
   			(grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X' || grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O'))
   			return true;
   		else return false;
  	} 
}
