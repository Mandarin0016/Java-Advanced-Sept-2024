import java.util.Scanner;

public class _02_Beesy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        // fill matrix and get 'B' coordinates
        int[] coordinates = new int[2];

        coordinates = fillMatrix(scanner, n, field);
        int energy = 15;
        boolean isHiveReached = false;
        int nectar = 0;
        boolean isRestored = false;
        //until the bee runs out of energy or reaches the hive.
        while (!isHiveReached) {

            if (energy <= 0) {
                break;
            }

            String command = scanner.nextLine();

            move(coordinates, command, field);
            moveBeeToOppositeSideIfNeeded(n, coordinates);

            char currentSymbol = field[coordinates[0]][coordinates[1]];
            // check for digit, 'H' or '-'
            if (currentSymbol == 'H') {
                isHiveReached = true;
            } else {
                nectar += Character.isDigit(currentSymbol) ?
                          Character.getNumericValue(currentSymbol) :
                          0;
            }
            energy--;

            // restore energy if needed
            if (!isRestored) {
                if (energy <= 0 && nectar > 30) {
                    int restValue = nectar - 30;
                    energy += restValue;
                    nectar -= restValue;
                    isRestored = true;
                }
            }

            field[coordinates[0]][coordinates[1]] = 'B';
        }

        if (isHiveReached) {
            if (nectar >= 30) {
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n"
                , energy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }
        printMatrix(field);
    }

    private static void moveBeeToOppositeSideIfNeeded(int n, int[] coordinates) {
        // check for out of bounds and move the Bee to the opposite side
        int row = coordinates[0];
        int col = coordinates[1];

        if (row < 0) {
            coordinates[0] = n - 1;
        } else if (row >= n) {
            coordinates[0] = 0;
        }

        if (col < 0) {
            coordinates[1] = n - 1;
        } else if (col >= n) {
            coordinates[1] = 0;
        }
    }

    private static void move(int[] coordinates, String command, char[][] field) {

        field[coordinates[0]][coordinates[1]] = '-';

        switch (command) {
            case "up" ->
            // up -> row--
            coordinates[0]--;
            case "down" ->
            // down -> row++
            coordinates[0]++;
            case "left" ->
            // left -> col--
            coordinates[1]--;
            case "right" ->
            // right -> col++
            coordinates[1]++;
        }
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            System.out.println(row);
        }
    }

    private static int[] fillMatrix(Scanner scanner, int n, char[][] field) {
        int[] coordinates = new int[2];

        for (int r = 0; r < n; r++) {
            field[r] = scanner.nextLine().toCharArray();
            // search for 'B' coordinates
            for (int c = 0; c < n; c++) {
                if (field[r][c] == 'B') {
                    coordinates[0] = r;
                    coordinates[1] = c;
                    break;
                }
            }
        }
        return coordinates;
    }
}
