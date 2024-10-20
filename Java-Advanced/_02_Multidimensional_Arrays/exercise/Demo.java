package exercise;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[6][6];

        filMatrix(matrix);
        int row = 3;
        int col = 10;
        // up -> row--
        // down -> row++
        // left -> col--
        // right -> col++

        System.out.println(isInside(matrix, row, col));

        printMatrix(matrix);

    }

    private static boolean isInside(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isOutside(int matrix, int row, int col){
        //TODO implement me...
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void filMatrix(int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = count++;
            }
        }
    }
}
