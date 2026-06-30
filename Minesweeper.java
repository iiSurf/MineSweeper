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
                    System.out.print(neighbors(board, i, j));
                }
            }
            System.out.println();
        }
    }

    private static int neighbors(char[][] board, int i, int j) {
        int nums = 0;
        if (i - 1 >= 0 && board[i - 1][j] == '*') {
            nums = nums + 1;
        }
        if (i + 1 < board.length && board[i + 1][j] == '*') {
            nums = nums + 1;
        }
        if (j - 1 >= 0 && board[i][j - 1] == '*') {
            nums = nums + 1;
        }
        if (j + 1 < board[i].length && board[i][j + 1] == '*') {
            nums = nums + 1;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == '*') {
            nums = nums + 1;
        }
        if (i - 1 >= 0 && j + 1 < board[i].length && board[i - 1][j + 1] == '*') {
            nums = nums + 1;
        }
        if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == '*') {
            nums = nums + 1;
        }
        if (i + 1 < board.length && j + 1 < board[i].length && board [i + 1][j + 1] == '*') {
            nums = nums + 1;
        }
        return nums;
    }
}