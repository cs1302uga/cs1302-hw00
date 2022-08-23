import java.util.Scanner;

/**
 * {@code TicTacToeRunner} is the main entry point for a command-line Tic-Tac-Toe
 * It relies on a working implementation of the {@code TicTacToeGame} class.
 * The game is meant for two players ('X' and 'O') and each player takes turns
 * trying to get three of their pieces in a row on the board. If a player gets
 * three in a row, then they win. If the board fills up and no one gets three in a
 * row, the game ends in a tie.
 *
 * This class is a modified version of the code found at
 * <a href="http://programmingbydoing.com/a/tic-tac-toe-oop.html">Original Project</a>
 */
public class TicTacToeRunner {
    /**
     * The main entry point of the application.
     *
     * @param args command-line arguments to the program.
     */
    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToeGame ttt = new TicTacToeGame();
        int r, c;

        // the main game loop
        while ( ! ( ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull() ) ) {
            ttt.displayBoard();
            System.out.print( "'" + p + "', choose your location (row, column): " );
            r = keyboard.nextInt();
            c = keyboard.nextInt();

            while ( ttt.isInBounds(r,c) == false || ttt.playerAt(r,c) != ' ' ) {
                if ( ttt.isInBounds(r,c) == false ) {
                    System.out.println("That is not a valid location. Try again.");
                } else if ( ttt.playerAt(r,c) != ' ' ) {
                    System.out.println("That location is already full. Try again.");
                } // if

                System.out.print( "Choose your location (row, column): " );
                r = keyboard.nextInt();
                c = keyboard.nextInt();
            }

            ttt.playMove( p, r, c );

            if ( p == 'X' ) {
                p = 'O';
            } else {
                p = 'X';
            } // if
        } // while

        ttt.displayBoard();

        if ( ttt.isWinner('X') ) {
            System.out.println("X is the winner!");
        } // if
        if ( ttt.isWinner('O') ) {
            System.out.println("O is the winner!");
        } // if
        if ( ttt.isCat() ) {
            System.out.println("The game is a tie.");
        } // if
    } // main
}
