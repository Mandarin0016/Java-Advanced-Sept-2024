import java.util.Scanner;

public class _07_FindTheRealQueen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        fillMatrix(matrix, scanner);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'q') {
                    boolean isUpPrimaryDiagonalClear = isUpPrimaryDiagonalClear(matrix, row - 1, col - 1);
                    boolean isDownPrimaryDiagonalClear = isDownPrimaryDiagonalClear(matrix, row + 1, col + 1);
                    boolean isUpSecondaryDiagonalClear = isUpSecondaryDiagonalClear(matrix, row - 1, col + 1);
                    boolean isDownSecondaryDiagonalClear = isDownSecondaryDiagonalClear(matrix, row + 1, col - 1);
                    int rowQueens = getRowQueensCount(matrix, row);
                    int colQueens = getColQueensCount(matrix, col);

                    boolean areDiagonalsClear = isUpPrimaryDiagonalClear && isDownPrimaryDiagonalClear && isUpSecondaryDiagonalClear && isDownSecondaryDiagonalClear;

                    if (areDiagonalsClear && rowQueens == 1 && colQueens == 1) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }

    }

    private static int getColQueensCount(char[][] matrix, int col) {

        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] == 'q') {
                count++;
            }
        }
        return count;
    }

    private static int getRowQueensCount(char[][] matrix, int row) {
        int count = 0;
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == 'q') {
                count++;
            }
        }
        return count;
    }

    private static boolean isDownSecondaryDiagonalClear(char[][] matrix, int row, int col) {

        while (row <= 7 && col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    private static boolean isUpSecondaryDiagonalClear(char[][] matrix, int row, int col) {

        while (row >= 0 && col <= 7) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    private static boolean isDownPrimaryDiagonalClear(char[][] matrix, int row, int col) {

        while (row <= 7 && col <= 7) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row++;
            col++;
        }

        return true;
    }

    private static boolean isUpPrimaryDiagonalClear(char[][] matrix, int row, int col) {

        while (row >= 0 && col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }
}
