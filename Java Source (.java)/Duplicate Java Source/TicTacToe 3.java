import java.util.*;

class TicTacToe
{
 	public static void main (String[] args)
 	{
   		Scanner keyboard = new Scanner(System.in);
   		System.out.println("Welcome! Tic-Tac-Toe is a two player game.");

 		String playerOne;
 		do { System.out.println("Enter player one's name: "); playerOne = keyboard.next(); }
 		while (keyboard.nextLine() == "");

 		String playerTwo;
 		do { System.out.println("Enter player two's name: "); playerTwo = keyboard.next(); }
 		while (keyboard.nextLine() == "");

 		System.out.println("Players take turns marking a square. Only squares\n" + 
 		"not already marked can be picked. Once a player has marked three squares in a row, he or she wins! If all squares\n" + 
 		"are marked an no three squares are the same, a tied game is declared. Have Fun!");

 		TicTacToeBoard board = new TicTacToeBoard();
 		board.reset();
 		board.print(board);
 		int player = 0;
 		for (int round = 0; round < 10; round++)
 		{
   			// player one's turn
   			player = 1;
   			playerGet(playerOne, board, player);
   			if ( board.gridCheck(board) ) 
   				{
   					System.out.println ("Game over! "+playerOne+" is the winner!");
   					return;
   				}

   			round++;    
  
  			// player two's turn
  			player = 2;
  			playerGet(playerTwo, board, player);
  			if ( board.gridCheck(board) ) 
   				{
   					System.out.println ("Game over! "+playerTwo+" is the winner!");
   					return;
   				}

 		}
 		System.out.println ("Game over! It's a tie!");
 	}
 	public static TicTacToeBoard playerGet(String playerName, TicTacToeBoard playerBoard, int playerTurn)
 	{
		// player name
  		Scanner input = new Scanner(System.in);
  		System.out.println("It is " + playerName + "'s turn.");

  		// player row
  		do System.out.println("Pick a row between 1 and 3: ");
  		while (input.hasNextInt() == false && input.nextInt() < 1 && input.nextInt() > 3 );
  		int row = input.nextInt()  - 1;

  		// player column
  		do System.out.println("Pick a column between 1 and 3: ");
  		while (input.hasNextInt() == false && input.nextInt() < 1 && input.nextInt() > 3);
  		int col = input.nextInt() - 1;
  		
  		if (playerBoard.grid[row][col] == ' ')
  		{
  			playerBoard = new TicTacToeBoard(row, col, playerTurn, playerBoard);
  			playerBoard.print(playerBoard);
  			return playerBoard;
  		}
  		System.out.println("INVALID INPUT, PLEASE TRY AGAIN");
  		return playerGet(playerName, playerBoard, playerTurn);
   	}
}
