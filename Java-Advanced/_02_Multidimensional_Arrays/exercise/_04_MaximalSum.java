package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int startRowIndex = 0;
        int startColIndex = 0;

        // for loop from 0 to rows - 2
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
                        sum += matrix[currentRow][currentCol];
                    }
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    startRowIndex = row;
                    startColIndex = col;
                }
            }
        }

        System.out.printf("Sum = %d\n", maxSum);
        printMaxSumMatrix(matrix, startRowIndex, startColIndex);
    }

    private static void printMaxSumMatrix(int[][] matrix, int startRowIndex, int startColIndex) {
        for (int row = startRowIndex; row < startRowIndex + 3; row++) {
            for (int col = startColIndex; col < startColIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            // 11 2 4
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }
    }
}
