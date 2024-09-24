import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        // Ламбда израз, който приема 1 аргумент, но НЕ ВРЪЩА резултат (просто извършва действие)
        // Consumer<приема> | .accept()
        Consumer<String> print = message -> System.out.print(message);

//        print.accept("Peter");

        List<String> names = List.of("Desi", "Ivan", "Pesho", "Vik");
        Consumer<String> sayHello = text -> System.out.printf("Hi, my name is %s!\n", text);

        names.forEach(sayHello);
    }

    public static void print(String message) {
        System.out.print(message);
    }
}
