import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Object> numbers = List.of(5, 10, 15, 20);
        List<String> names = List.of("Desi", "Gosho", "Ivan", "Vik");

//        print(names);
        print(numbers);
    }

    // ? - какъвто и да е тип данни
    // ? extends Number - какъвто и да е тип данни, но той трябва да е наследник на класа Number - upper bound
    // ? super Number - какъвто и да е тип данни, но той трябва да е бащин класа на класа Number - lower bound
    public static void print(List<?> list) {

        // в рамките на този метод, елементите на този списък мога да ги третирам само като Object
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
