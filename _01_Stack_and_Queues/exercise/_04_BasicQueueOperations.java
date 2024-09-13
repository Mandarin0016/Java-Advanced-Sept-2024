import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _04_BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        int n = tokens[0]; // the number of elements to offer into the queue
        int s = tokens[1]; // number of elements to poll from the queue
        int x = tokens[2]; // element that you should check
        // whether is present in the queue

        Deque<Integer> queue = new ArrayDeque<>();

        // Add n elements to the queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(queue::offer);

        // Remove s elements from the queue
        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0); // check for empty queue
        } else if (queue.contains(x)) {
            System.out.println(true); // check whether x is present
        } else {
            System.out.println(Collections.min(queue)); // get the smallest element
        }
    }
}
