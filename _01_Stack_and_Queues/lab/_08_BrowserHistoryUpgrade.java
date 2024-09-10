import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardPages.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardPages.peek());
                    browserHistory.push(forwardPages.pop());
                }
            } else {
                System.out.println(command);
                browserHistory.push(command);
                forwardPages.clear();
            }
            command = scanner.nextLine();
        }
    }
}
