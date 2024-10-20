import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionDemo {

    public static void main(String[] args) {

        //BiFunction<приема1, приема2, връща> извършва действие и връща резултат .apply()
        BiFunction<Integer, Integer, String> sum = (x, y) -> "Sum is " + (x + y);
        System.out.println(sum.apply(5, 2));

        BiFunction<Integer, Integer, Integer> sumTwoNumbers = (x, y) -> x + y;
        System.out.println(sumTwoNumbers.apply(5, 2));

        BiFunction<String, String, String> greeting = (firstName, secondName) -> "Hi, my name is " + firstName + " " + secondName;
        System.out.println(greeting.apply("Vik", "Aleksandrov"));

        //BiConsumer<приема1, приема2> извършва действие без да връща резултат .accept()
        BiConsumer<String, String> printGreeting = (firstName, secondName) -> System.out.printf("Hi, my name is %s %s\n", firstName, secondName);
        printGreeting.accept("Vik", "Aleksandrov");

        //BiPredicate<приема1, приема2> връща булева стойност .test()
        BiPredicate<String, String> sameLength = (firstText, secondText) -> firstText.length() == secondText.length();
        System.out.println(sameLength.test("Vik", "Desi"));

    }
}
