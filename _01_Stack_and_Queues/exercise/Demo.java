import java.awt.font.LineMetrics;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack - LIFO - Last in First out
        // push(element) - insert element on the top of the stack
        // pop() - remove topmost element
        // peek() - get topmost element

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(8);
        stack.push(15);
        stack.push(14);
        stack.push(7);

        //        System.out.println(stack.peek());

        while (!stack.isEmpty()) {
            Integer element = stack.pop();
            //            System.out.println(element);
        }

        // Queue - FIFO - First in First out
        // offer(element) - add element at the start of the Queue
        // poll() - remove first element of the Queue
        // peek() - get first element of the Queue

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()){
            Integer element = queue.poll();
//            System.out.println(element);
        }


        // PriorityQueue

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.offer(19);
        priorityQueue.offer(15);
        priorityQueue.offer(25);
        priorityQueue.offer(10);
        priorityQueue.offer(1);

//        while (!priorityQueue.isEmpty()){
//          //  System.out.println(priorityQueue.poll());
//        }

        Stack<Integer> someStack = new Stack<>();

        someStack.push(1);
        someStack.push(2);
        someStack.push(3);
        someStack.push(4);
        someStack.push(5);

        while (!someStack.isEmpty()){
            System.out.println(someStack.pop());
        }
    }
}
