import java.util.Arrays;
import java.util.Scanner;

public class _08_WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int valueToReplace = matrix[indexes[0]][indexes[1]];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = getNearbySum(matrix, r, c, valueToReplace);
                    System.out.print(correctValue + " ");
                } else {
                    System.out.print(matrix[r][c] + " ");
                }
            }

            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {

        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }

        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }

        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }

        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

