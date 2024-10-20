import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoGenerics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<Integer> customList = new CustomList<>();
        customList.add(4);
        customList.add(9);
        customList.add(2);
        customList.add(8);
        customList.add(7);
        Sorter.sort(customList);
        List<Integer> numbers = new ArrayList<>();
        // List numbers = new ArrayList();
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);


        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        print(numberList);
        print(objectList);

        multiplyBy2(numbers);

        MyList<Integer> myList = new MyList<>();
        myList.someMethod(numbers);

        print2(numbers);
        print2(objectList);
        print2(numberList);

    }

    // Всички деца на Number
    private static <T extends Number> void multiplyBy2(List<T> numbers) {
        numbers.forEach(n -> System.out.println((int) n * 2));


        T element = numbers.get(0);
    }

    // Всички родители на Numbers
    static void print(List<? super Number> numbers) {
        numbers.forEach(System.out::println);

        Object object = numbers.get(0);
    }

    // List<?>
    static void print2(List list) {
    }


}
