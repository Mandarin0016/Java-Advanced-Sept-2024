import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_Voina {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(number -> firstPlayerCards.add(number));

        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(number -> secondPlayerCards.add(number));

        int rounds = 50;
        while (rounds > 0 && !firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {

            int firstPlayerCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerCard);

            int secondPlayerCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            }

            rounds--;
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

//    public static int getFirstElement(Set<Integer> cards) {
//        for (Integer card : cards) {
//            return card;
//        }
//        return 0;
//    }
}
