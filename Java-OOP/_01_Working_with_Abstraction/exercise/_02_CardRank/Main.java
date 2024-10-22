package _02_CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");
        Arrays.stream(CardRank.values())
              .forEach(System.out::println);

    }
}
