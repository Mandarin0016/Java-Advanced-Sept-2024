import java.util.Scanner;

public class NavyBattleRetakeExam14Dec2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        int submarineRow = 0;
        int submarineCol = 0;

        for (int row = 0; row < n; row++) {
            // *--*-
            char[] currentRow = scanner.nextLine().toCharArray();
            field[row] = currentRow;
            for (int col = 0; col < n; col++) {
                if (field[row][col] == 'S') {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }

        int submarineHits = 0;
        int cruiserHits = 0;

        while (submarineHits < 3 && cruiserHits < 3) {
            String command = scanner.nextLine();
            field[submarineRow][submarineCol] = '-';

            switch (command) {
                case "up" ->
                // "up"   ->  row--
                submarineRow--;
                case "down" ->
                // "down" -> row++
                submarineRow++;
                case "left" ->
                // "left" -> col--
                submarineCol--;
                case "right" ->
                // "right" -> col++
                submarineCol++;
            }

            // - , * , C

            if (field[submarineRow][submarineCol] == '*') {
                submarineHits++;
            } else if (field[submarineRow][submarineCol] == 'C') {
                cruiserHits++;
            }

            field[submarineRow][submarineCol] = 'S';
        }

        if (cruiserHits == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n",
                              submarineRow, submarineCol);
        }

        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
