package _01_Card_Suit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Suits:");
        Arrays.stream(CardSuit.values())
        .forEach(System.out::println);
    }
}
