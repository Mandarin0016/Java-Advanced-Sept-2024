import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _08_CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // sorts all even numbers before all odd ones in ascending order
        // comparator -> function accepts 2 parameters and return int ( 0, 1, -1)
        // 0 -> first == second
        // 1 -> first > second
        // -1 -> first < second
        // 5 , 3 -> 3, 5
        //sorted(0) -> not swap the elements
        // sorted(1) -> swap the elements
        // sorted(-1) -> not swap the elements

        //  2 1 3 5 4 -> 2 4 1 3 5
        // (2, 1) ->  -1 not swap
        // (1, 3) ->  -1 not swap
        // (3, 5) ->  -1 not swap
        // (5, 4) ->  1 swap
        // 2 1 3 4 5
        // (2, 1) ->  -1 not swap
        // (1, 3) ->  -1 not swap
        // (3, 4) ->  1 swap
        // 2 1 4 3 5
        // (2, 1) ->  -1 not swap
        // (1, 4) ->  1 swap
        // 2 4 1 3 5

        CustomComparator customComparator1 = new CustomComparator();
        System.out.println(customComparator1.compare(5, 4));

        Comparator<Integer> customComparator = (first, second) -> {
            // first even, second odd -> not swap
            if (first % 2 == 0 && second % 2 != 0) {
                return -101;
            }
            // first odd, second even -> swap
            else if (first % 2 != 0 && second % 2 == 0) {
                return 101;
            } else { // sort ascending order
                return first.compareTo(second);
            }
        };

      //  System.out.println(customComparator.compare(5, 4));

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .sorted(customComparator1)
              .forEach(n -> System.out.print(n + " "));
    }
}
