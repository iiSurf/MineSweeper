import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Minesweeper {

// Reading from a file or standard input
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan;
        
        if (args.length > 0) {
            scan = new Scanner(new File(args[0]));
        } else {
            scan = new Scanner(System.in);
        }

        while (scan.hasNextLine()) {
            String textLine = scan.nextLine();
            System.out.println(textLine);
        }

        scan.close();
        gameBoard();
    }

    private static void gameBoard() {
        char[][] board = {
            {'*', '.', '.', '.'},
            {'.', '.', '.', '.'},
            {'.', '*', '.', '.'},
            {'.', '.', '.', '.'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    System.out.print(board[i][j]);
                } else {
                    System.out.println('.');
                }
            }
            System.out.println();
        }
    }
}