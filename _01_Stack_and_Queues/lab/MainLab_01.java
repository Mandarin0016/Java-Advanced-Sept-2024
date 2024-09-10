import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class MainLab_01 {

    public static void main(String[] args) {

        // Стек (структура от данни, която подрежда своите елементи като на купчина)
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // добавяне .push
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);

        // премахване .pop
        int removedElement = stack.pop();

        // вземам последният добавен елемент  .peek
        int topElement = stack.peek();

        // Опашка
        ArrayDeque<String> queue = new ArrayDeque<>();

        // добавяне
        queue.offer("Vik");
        queue.offer("Desi");
        queue.offer("Marti");
        queue.offer("Ivan");

        // премахване
        String name = queue.poll();

        // вземам първият елемент на опашката
        String firstElement = queue.peek();


        PriorityQueue<String> fruits = new PriorityQueue<>();

        fruits.offer("Banana");
        fruits.offer("Apple");
        fruits.offer("Cherry");

        System.out.println();
    }
}
