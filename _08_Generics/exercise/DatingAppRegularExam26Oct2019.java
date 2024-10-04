import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingAppRegularExam26Oct2019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // male - LIFO - Stack
        Deque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(males::push);
        // female - FIFO - Queue
        Deque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(females::offer);

        int matches = 0;

        // You need to stop matching people when you have no more females or males
        while (!males.isEmpty() && !females.isEmpty()) {
            // If someone’s value is equal to or below 0, you should
            // remove him/her from the records before trying to match him/her with anybody.

            while (males.peek() <= 0) {
                males.pop();
                if (males.isEmpty()) {
                    break;
                }
            }
            while (females.peek() <= 0) {
                females.poll();
                if (females.isEmpty()) {
                    break;
                }
            }

            if (males.isEmpty() || females.isEmpty()) {
                break;
            }

            int male = males.peek();
            int female = females.peek();
            // Special case - if someone’s value is divisible by 25 without remainder,
            // you should remove him/her and the next person of the same gender.
            if (male % 25 == 0) {
                males.pop();
                if (males.isEmpty()) {
                    break;
                }
                males.pop();
            }

            if (female % 25 == 0) {
                females.poll();
                if (females.isEmpty()) {
                    break;
                }
                females.poll();
            }

            if (males.isEmpty() || females.isEmpty()) {
                break;
            }

            //	If their values are equal, you have to match them and remove both of them.
            //	Otherwise, you should remove only the female
            //	and decrease the value of the male by 2.
            male = males.peek();
            female = females.peek();
            if (male == female) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                Integer currentMale = males.pop();
                males.push(currentMale - 2);
            }
        }

        System.out.printf("Matches: %d\n", matches);

        System.out.print("Males left: ");
        String malesResult = males.isEmpty() ? "none" : getElements(males);
        System.out.print(malesResult);
        System.out.println();

        System.out.print("Females left: ");
        String femalesResult = females.isEmpty() ? "none" : getElements(females);
        System.out.print(femalesResult);
    }

    private static String getElements(Deque<Integer> deque) {
        return deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
    }
}
