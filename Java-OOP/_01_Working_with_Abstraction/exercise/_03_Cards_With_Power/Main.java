package _03_Cards_With_Power;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        CardRank cardRankEnum = CardRank.valueOf(cardRank);
        CardSuit cardSuitEnum = CardSuit.valueOf(cardSuit);

        Card card = new Card(cardRankEnum, cardSuitEnum);
        System.out.println(card);
    }
}
