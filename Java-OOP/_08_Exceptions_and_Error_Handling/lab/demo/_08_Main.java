package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _08_Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Когато мой клас наследи:
        // RuntimeException -> unchecked exception
        // Exception -> check exception

        // НАЧИН 1: обработвам използвайки try/catch
        // НАЧИН 2: не обработвам и предавам нагоре по веригата
        Book book = new Book("Vik", -20);

        // checked excpetion - IOException
        try {
            FileWriter writer = new FileWriter("text.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printBook(Book book) {
        System.out.println(book);
    }
}
