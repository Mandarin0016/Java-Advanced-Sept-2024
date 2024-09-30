import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // [5, 5]
        int[] input = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        char[][] matrix = new char[input[0]][input[1]];
        fillMatrix(matrix, scanner);

        // Намирам кординатите на мишлето
        int[] coordinates = findMyCoordinates(matrix);
        int myRow = coordinates[0];
        int myCol = coordinates[1];
        int countCheeses = getCheeseCount(matrix);

        String command = scanner.nextLine(); // up, down, left, right
        while (!command.equals("danger")) {

            int newRow = myRow;
            int newCol = myCol;

            switch (command) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }

            // Проверявам дали новите ред и колона са валидни
            if (!isRowValid(newRow, matrix) || !isColValid(newCol, matrix)) {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }

            // Вземам символа на новият ред и колона
            char symbol = matrix[newRow][newCol];

            // Придвижвам мишлето
            if (symbol != '@') {
                // 1. Премествам мишлето на новите ред и колона
                matrix[newRow][newCol] = 'M';
                // 2. На старият ред и колона слагам '*'
                matrix[myRow][myCol] = '*';
                // 3. Обновявам сегашният ред и колона на мишлето
                myRow = newRow;
                myCol = newCol;
            }

            switch (symbol) {
                case 'C':
                    countCheeses--;
                    if (countCheeses == 0) {
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case 'T':
                    System.out.println("Mouse is trapped!");
                    printMatrix(matrix);
                    return;
            }

            command = scanner.nextLine();
        }

        System.out.println("Mouse will come back later!");
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isColValid(int colIndex, char[][] matrix) {
        return colIndex >= 0 && colIndex < matrix[0].length;
    }

    private static boolean isRowValid(int rowIndex, char[][] matrix) {
        return rowIndex >= 0 && rowIndex < matrix.length;
    }

    private static int getCheeseCount(char[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] findMyCoordinates(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[row] = currentRow;
        }
    }
}
