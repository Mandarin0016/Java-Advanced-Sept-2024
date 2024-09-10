import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _06_HotPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Sam John Sara
        String[] kidsNames = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, kidsNames);

        // 2
        int n = Integer.parseInt(scanner.nextLine());
        int rotations = 0;

        while (queue.size() > 1) {
            // 1. Вземам първото дете на опашката
            String firstKid = queue.poll();

            // 2. Увеличавам броят на завъртанията
            rotations++;

            // 3. Проверявам дали това е Nth завъртане
            if (rotations % n == 0) {
                // - Ако е Nth завъртане = не го добавям в краят на опашката
                System.out.println("Removed " + firstKid);
            } else {
                // - Ако НЕ е Nth завъртане = добавям го в краят на опашката
                queue.offer(firstKid);
            }
        }

        System.out.println("Last is " + queue.poll());
    }
}
