import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class _05_BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //   (){[()]} - This is a balanced parenthesis.
        // {}{[()]} - This is a balanced parenthesis.
        // {[(])} - This is not a balanced parenthesis.

        List<String> brackets = Arrays.stream(scanner.nextLine().split(""))
                                      .toList();

        String result = isBalanced(brackets) ? "YES" : "NO";

        System.out.println(result);
    }

    private static boolean isBalanced(List<String> brackets) {

        Deque<String> openBracketsStack = new ArrayDeque<>();
        //  {[(()]}
        for (String bracket : brackets) {

            // Check for close bracket
            switch (bracket) {
                case "}":
                    if (openBracketsStack.isEmpty()) {
                        return false;
                    }
                    String openBracket = openBracketsStack.pop();
                    if (!openBracket.equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    if (openBracketsStack.isEmpty()) {
                        return false;
                    }
                    openBracket = openBracketsStack.pop();
                    if (!openBracket.equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    if (openBracketsStack.isEmpty()) {
                        return false;
                    }
                    openBracket = openBracketsStack.pop();
                    if (!openBracket.equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openBracketsStack.push(bracket);
                    break;
            }

        }

        return openBracketsStack.isEmpty();
    }
}
