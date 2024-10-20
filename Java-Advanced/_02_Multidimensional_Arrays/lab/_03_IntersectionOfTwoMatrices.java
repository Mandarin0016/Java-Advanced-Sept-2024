import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //3
        //4
        //a b c d
        //a b c d
        //a b c d
        //k b c k
        //a b g d
        //a k c d

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrixA = new char[rows][cols];
        char[][] matrixB = new char[rows][cols];

        fillMatrix(matrixA, scanner);
        fillMatrix(matrixB, scanner);

        printMatrix(matrixA, matrixB);
    }

    private static void printMatrix(char[][] matrixA, char[][] matrixB) {

        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < matrixA[row].length; col++) {

                if (matrixA[row][col] != matrixB[row][col]) {
                    System.out.print("* ");
                } else {
                    System.out.print(matrixA[row][col] + " ");
                }
            }
            System.out.println();
        }

    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        //a b c d
        //a b c d
        //a b c d
        for (int row = 0; row < matrix.length; row++) {

            // 1. Прочитам 1 ред
            // "a b c d" -> "abcd"
            String input = scanner.nextLine().replace(" ", "");
            // ['a', 'b', 'c', 'd']
            char[] currentRow = input.toCharArray();
            matrix[row] = currentRow;
        }

    }
}
