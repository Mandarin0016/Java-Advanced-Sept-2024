import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //3, 6
        //7, 1, 3, 3, 2, 1
        //1, 3, 9, 8, 5, 6
        //4, 6, 7, 9, 1, 0

        int[] size = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSum(matrix));
    }

    private static int getSum(int[][] matrix) {
        
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        //7, 1, 3, 3, 2, 1
        //1, 3, 9, 8, 5, 6
        //4, 6, 7, 9, 1, 0
        for (int row = 0; row < matrix.length; row++) {
            // ВСЕКИ РЕД ОТ МОЯТА МАТРИЦА Е МАСИВ!
            //[7, 1, 3, 3, 2, 1]
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentRow;
        }
    }
}
