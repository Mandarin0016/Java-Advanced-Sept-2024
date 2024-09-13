import java.util.Scanner;

public class _02_PositionsOf {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //2 3
        //1 2 3
        //4 2 2
        //2

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // 1. Създавам матрица
        int[][] matrix = new int[rows][cols];
        // 2. Пълня матрицата
        fillMatrix(matrix, scanner);

        int number = scanner.nextInt();
        boolean isNumberFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    isNumberFound = true;
                }
            }
        }

        if (!isNumberFound) {
            System.out.println("not found");
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
