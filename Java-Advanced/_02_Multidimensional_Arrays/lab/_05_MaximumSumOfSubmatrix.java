import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOfSubmatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        int biggestSubMatrixSum = 0;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {

                int sumOfSubmatrix = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sumOfSubmatrix > biggestSubMatrixSum) {
                    biggestSubMatrixSum = sumOfSubmatrix;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1]);
        System.out.println(biggestSubMatrixSum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
    }
}
