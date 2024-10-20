package _01_task;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //9 5 8 18 stack (LIFO)
        //18 12 10 5 queue (FIFO)
        ArrayDeque<Integer> myMoneyStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(myMoneyStack::push);

        ArrayDeque<Integer> foodPriceQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(foodPriceQueue::offer);

        int foodCount = 0;

        while (!myMoneyStack.isEmpty() && !foodPriceQueue.isEmpty()) {

            //18 парите на Хенри
            int myMoney = myMoneyStack.pop();
            //18 цената на храната
            int foodPrice = foodPriceQueue.poll();

            // Сравнявам двете стойности
            if (myMoney == foodPrice) {
                foodCount++;
            } else if (myMoney > foodPrice) {
                foodCount++;
                if (!foodPriceQueue.isEmpty() && !myMoneyStack.isEmpty()) {
                    // 9 (парите на Хенри) - 4 (цената на храната) = 5 (ресто)
                    int change = myMoney - foodPrice;
                    int nextMoneyAmount = myMoneyStack.pop();
                    myMoneyStack.push(nextMoneyAmount + change);
                }
            }
        }

        if (foodCount >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", foodCount);
        } else {
            if (foodCount == 0) {
                System.out.println("Henry remained hungry. He will try next weekend again.");
            } else if (foodCount == 1) {
                System.out.println("Henry ate: 1 food.");
            } else {
                System.out.printf("Henry ate: %d foods.", foodCount);
            }
        }
    }
}
