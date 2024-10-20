import java.util.List;

public class DemoIterator {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 10, 15, 20);
        for (Integer number : numbers) {
            System.out.println(number);
        }

        // Искам да мога да обходя всички страници на моята книга
        Book book = new Book("page1", "page2", "page3");
        // Как работи foreach цикъла?
        // 1. Взема достъп до итератора на класа!
        // 2. Пита итератор има ли следващ елемент!
        // 3. Ако има следващ елемент, пита итератора да му даде този елемент.
        for (String page : book){
            System.out.println(page);
        }
    }
}
