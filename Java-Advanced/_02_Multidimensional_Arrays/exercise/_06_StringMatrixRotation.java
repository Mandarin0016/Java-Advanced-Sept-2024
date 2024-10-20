package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().split("\\(")[1]
                                        .replaceAll("\\)", ""));

        int rotationAngle = rotation % 360;

        String input = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        int maxColLength = Integer.MIN_VALUE;
        while (!"END".equals(input)) {
            lines.add(input);
            if (input.length() > maxColLength) {
                maxColLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = lines.size();
        int cols = maxColLength;
        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, lines);

        switch (rotationAngle) {
            case 90:
                matrix = rotate90(matrix, rows, cols);
                break;
            case 180:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                break;
            case 270:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                matrix = rotate90(matrix, rows, cols);
                break;
        }
        printMatrix(matrix);
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        char[][] rotatedMatrix = new char[cols][rows];
        for (int col = 0; col < cols; col++) {
            int columnCounter = 0;
            for (int row = rows - 1; row >= 0; row--) {
                rotatedMatrix[col][columnCounter++] = matrix[row][col];
            }
        }
        return rotatedMatrix;
    }

    private static void fillMatrix(char[][] matrix, List<String> lines) {
        for (int row = 0; row < matrix.length; row++) {
            String currentLine = lines.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < currentLine.length()) {
                    matrix[row][col] = currentLine.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
