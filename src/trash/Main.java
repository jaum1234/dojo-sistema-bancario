package trash;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        String sequence = readSequence();

        int rows = 5;
        int cols = 5;
        Integer[][] matrix = new Integer[rows][cols];

        int counter = 0;

        for (int i = 0; i < rows; i++) {
            if (i == 0 || i == 4) {
                System.out.print("---------");
                if (i == 0) {
                    System.out.print("\n");
                }
                continue;
            }

            for (int j = 0; j < cols; j++) {
                if ((j == 0 || j == 4)) {
                    System.out.print("|");
                    if (j == 0) {
                        System.out.print(" ");
                    }
                    continue;
                }
                printSymbol(j, sequence, counter);
                counter++;
            }

            System.out.print("\n");
        }
    }

    private static String readSequence()
    {
        String sequence;

        while (true) {
            sequence = scanner.nextLine();

            if (sequence.length() == 9) {
                break;
            }
        }
        return sequence;
    }

    private static void printTopBottomBorder(int row)
    {
        System.out.print("---------");
        if (row == 0) {
            System.out.print("\n");
        }
    }


    public static void printSymbol(int j, String sequence, int counter)
    {

        System.out.print(sequence.charAt(counter));


        if (j != 4) {
            System.out.print(" ");
        }

    }
}
