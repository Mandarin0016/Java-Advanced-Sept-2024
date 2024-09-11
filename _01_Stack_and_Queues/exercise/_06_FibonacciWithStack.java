import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _06_FibonacciWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Long> stack = new ArrayDeque<>();

        stack.push(0L);
        stack.push(1L);

        int n = Integer.parseInt(scanner.nextLine());

        if (n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            // n - 1
            long num1 = stack.pop();
            // n - 2
            long num2 = stack.pop();

            // Put num1 back to the stack
            stack.push(num1);
            // Calculate num2
            stack.push(num1 + num2);
        }

        System.out.println(stack.peek());
    }
}












