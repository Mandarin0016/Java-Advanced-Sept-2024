
public class Main {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addLast(5);

        int[] numbers = doublyLinkedList.toArray();

        doublyLinkedList.forEach(n -> System.out.println(n + 1));
    }
}










