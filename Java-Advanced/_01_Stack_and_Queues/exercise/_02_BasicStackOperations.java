import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _02_BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        int n = tokens[0]; // the number of elements to push into the stack
        int s = tokens[1]; // number of elements to pop from the stack
        int x = tokens[2]; // element that you should check
        // whether is present in the stack

        Deque<Integer> stack = new ArrayDeque<>();

        // Add n elements to the stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(stack::push);

        // Remove s elements from the stack
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0); // check for empty stack
        } else if (stack.contains(x)) {
            System.out.println(true); // check whether x is present
        } else {
            System.out.println(Collections.min(stack)); // get the smallest element
        }

    }
}
