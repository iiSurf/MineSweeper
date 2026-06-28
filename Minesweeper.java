import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Minesweeper {


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
    }
}