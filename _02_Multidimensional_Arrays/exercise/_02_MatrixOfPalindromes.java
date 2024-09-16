package exercise;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        String[][] matrix = new String[r][c];

        fillPalindromesMatrix(matrix);

        printMatrix(matrix);
    }

    private static void fillPalindromesMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char outsideSymbol = (char) ('a' + row);
                char middleSymbol = (char) (outsideSymbol + col);
                matrix[row][col] = String.valueOf(outsideSymbol) + middleSymbol + outsideSymbol;
            }
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
