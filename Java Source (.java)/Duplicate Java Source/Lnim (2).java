/** Lnim.java
 *  "learns" how to play the very simple game of NIM
 *  through experience with a human user.
 *
 *  @author:  Dr. Henry H. Leitner
 *  @version: Last Modified June 22, 2013
 */
import java.util.*;

public class Lnim
{
    static Scanner keyboard = new Scanner (System.in);
    static final int SCORE_ROW = 2;
    static final int A_SCORE_COL = 10;
    static final int B_SCORE_COL = 40;
    static final int GAME_INTERACTION_ROW = 13;
    static final int PLAY_AGAIN_PROMPT_ROW = 16;
    static final int PLAY_AGAIN_PROMPT_COL = 40;
    static final int TOTAL_MATCHES = 11;  // the number of matches to play with

    static Table aMoves  = new Table(4, TOTAL_MATCHES+1);
    static Table bMoves  = new Table(4, TOTAL_MATCHES+1);
    static Table history = new Table(4, TOTAL_MATCHES+1);

    static int aScore = 0, bScore = 0, matchesLeft = 0;

    static void play1GameOfNim()
    {
        int m;
        boolean gameOver = false;        // We haven't started playing yet!

        TxtGrph.position(GAME_INTERACTION_ROW, 1);
        matchesLeft = TOTAL_MATCHES;

        while ( ! gameOver )
        {                                               // Let player A go first
            m = history.takeSomeMatches (matchesLeft);
            aMoves.setValue(m, matchesLeft, 1);         // record that move
            matchesLeft -= m;                           // remove M matches
                                                        // from the pile
            System.out.println ("A takes " + m + " matches, leaving " +
                    matchesLeft);

            if (matchesLeft == 1)                      // did player A win??
            {
                history.reinforce (aMoves, bMoves);    // yes; remember
                                                       // the experience
                aScore++;                              // and tally the win.
                gameOver = true;
            }
            else                                       // Now player B goes
            {
                do
                {
                   System.out.print ("How many matches do you want? ");
                   m = keyboard.nextInt();
                } while (m < 1 || m > 3 || m >= matchesLeft);

                bMoves.setValue(m, matchesLeft, 1);    // record B's move
                matchesLeft -= m;                      // remove M matches
                                                       // from the pile
                System.out.println ("B takes " + m + " matches, leaving " +
                                     matchesLeft);

                if (matchesLeft == 1)                  // did player B win??
                {
                   history.reinforce (bMoves, aMoves); // yes; remember
                                                       // the experience
                   bScore++;                           // and tally the win.
                   gameOver = true;
                }
            }
        }
    }


    public static void main (String[] args)
    {
       String response;
       history.displayOutline();                      // show history boxes
       do
          {
            aMoves.initialize(0);
            bMoves.initialize(0);

            TxtGrph.position(GAME_INTERACTION_ROW, 1);
            TxtGrph.eraseDown();

            play1GameOfNim();

            TxtGrph.position (SCORE_ROW, A_SCORE_COL);
            System.out.print ("A score:  " + aScore);
            TxtGrph.position (SCORE_ROW, B_SCORE_COL);
            System.out.print ("B score: " + bScore);
            TxtGrph.beep();
            history.displayValues();
            TxtGrph.position(PLAY_AGAIN_PROMPT_ROW, PLAY_AGAIN_PROMPT_COL);
            System.out.print ("Do you want to play again? ");
            response = keyboard.next();
          } while (response.charAt(0)  != 'N' && response.charAt(0) != 'n');
          System.out.println("\n\n");
    }
}

