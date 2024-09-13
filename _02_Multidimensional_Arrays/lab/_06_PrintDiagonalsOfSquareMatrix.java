import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //3
        //1 2 3
        //1 2 3
        //1 2 3

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, scanner);

        // 1. Намирам първостепенен диагонал
        printPrimaryDiagonal(matrix);
        System.out.println();
        // 2. Намирам второстепенен диагонал
        printSecondaryDiagonal(matrix);
    }

    private static void printSecondaryDiagonal(int[][] matrix) {

        // 2, 0
        // 1, 1
        // 0, 2
        int col = 0;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
    }

    private static void printPrimaryDiagonal(int[][] matrix) {

        // Главен диагонал: индекса на реда е същият като индекса на колоната!
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
