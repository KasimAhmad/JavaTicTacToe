import java.util.Scanner;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args){
        char player1 = 'X';
        char player2 = 'O';
        Scanner sc = new Scanner(System.in);

        Board gameBoard = new Board(3,3);
        gameBoard.printBoard();
        //Playing 
        char turn = player1;
        boolean stop = false;

        String winner = "";
        gameBoard.printBoard();
        while (!stop)
        {
            //Intializing boolean to check if playable
            boolean goodPlay = false;
            if (turn == player1)
            {
                //Check if available space on the Board before asking player to do turn
                if (gameBoard.spaceAvailable())
                {
                    //If space available, take user input
                    do
                    {
                        System.out.print("Please enter row & column:" );
                        int row = sc.nextInt();
                        int col = sc.nextInt();

                        goodPlay = gameBoard.play(turn, row - 1, col -1);
                    } while (!goodPlay);
                    //If not playable, keep boolean at false
                } else
                {
                    goodPlay = false;
                }
                //Move to next player's turn (autoplay)
            } else
            {
                goodPlay = gameBoard.autoPlay(turn);
            }
            if (goodPlay)
            {
                //AutoPlay sucessful! Check if there's a winner
                if (gameBoard.haveAWinner())
                {
                    //If there is a winner, end the game
                    winner = "Player " + turn + " is our winner!!!";
                    stop = true;

                } else
                {
                    //No winner decided - Turn switches back to other player
                    turn = (turn==player1)?player2:player1;
                }
            } else
            { //AutoPlay cannot make a move
                winner = "Draw!";
                stop = true;
            }
            gameBoard.printBoard();
        }
    }
}
