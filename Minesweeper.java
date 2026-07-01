import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Minesweeper {

// Reading from a file or standard input
    public static void main(String args[]) throws FileNotFoundException {

        int fieldCounter = 1;
        Scanner scan;

        if (args.length > 0) {
            scan = new Scanner(new File(args[0]));
        } else {
            scan = new Scanner(System.in);
        }

        while (scan.hasNextLine()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            // System.err.println("Read field: " + n + " x " + m);
            if (n == 0 && m == 0) {
                break;
            }
            scan.nextLine();
            gameBoard(scan, n, m, fieldCounter);
            fieldCounter = fieldCounter + 1;
        }
        scan.close();
    }

    private static void gameBoard(Scanner scan, int n, int m, int fieldCounter) {
        System.out.println("Field #" + fieldCounter + ":");
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

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
        System.out.println();
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