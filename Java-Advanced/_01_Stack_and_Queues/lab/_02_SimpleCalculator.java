import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //2 - 2 + 5
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            // 1. Вземам 3 елемента от моят стек (число1, оператор, число2)
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            // 2. Калкулирам резултата
            int result = 0;
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }

            // 3. Поставям резултата отново в стека
            stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
