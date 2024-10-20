import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Deque<Integer> numbersStack = new ArrayDeque<>();

        Stack<Integer> numbersStack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(numbersStack::push);

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
