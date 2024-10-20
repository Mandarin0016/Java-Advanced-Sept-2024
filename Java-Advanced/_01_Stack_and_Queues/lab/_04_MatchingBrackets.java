import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //(2 + 3) - (2 + 3)
        String expression = scanner.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {

            char symbol = expression.charAt(index);
            if (symbol == '(') {
                indexes.push(index);
            } else if (symbol == ')') {
                int startIndex = indexes.pop();
                String substring = expression.substring(startIndex, index + 1);
                System.out.println(substring);
            }
        }

    }
}
