import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_PiePursuit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> contestantsQueue = new ArrayDeque<>();
        Deque<Integer> pieStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(contestantsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(pieStack::push);


        while (!contestantsQueue.isEmpty() && !pieStack.isEmpty()) {
            int contestant = contestantsQueue.poll();
            int pie = pieStack.pop();

            if (contestant >= pie) {
                contestant -= pie;
                if (contestant > 0) {
                    contestantsQueue.offer(contestant);
                }
            } else {
                pie -= contestant;

                if (!pieStack.isEmpty()) {

                    if (pie == 1) {
                        Integer nextPie = pieStack.pop();
                        pieStack.push(nextPie + pie);
                    } else {
                        pieStack.push(pie);
                    }

                } else {
                    pieStack.push(pie);
                }
            }
        }

        if (pieStack.isEmpty() && contestantsQueue.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (pieStack.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.printf("Contestants left: %s", getQueueElements(contestantsQueue));
        } else {
            System.out.println("Our contestants need to rest!");
            System.out.printf("Pies left: %s", getStackElements(pieStack));
            // removes last ", "
            // getStackElements(pieStack).substring(0, getStackElements(pieStack).length() -2)
        }
    }

    private static String getStackElements(Deque<Integer> pieStack) {
        Iterator<Integer> stackIterator = pieStack.descendingIterator();
        StringBuilder sb = new StringBuilder();

        sb.append(stackIterator.next());

        while (stackIterator.hasNext()) {
            sb.append(", ");
            sb.append(stackIterator.next());
        }

        return sb.toString();
    }

    private static String getQueueElements(Deque<Integer> deque) {
        // works only for queues
        return deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
    }
}
