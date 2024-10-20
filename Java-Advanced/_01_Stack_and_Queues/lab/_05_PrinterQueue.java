import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                // cancel
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                // file name
                queue.offer(input);
            }

            input = scanner.nextLine();
        }

        for (String filename : queue) {
            System.out.println(filename);
        }
    }
}
