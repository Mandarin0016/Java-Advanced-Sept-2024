import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        // Supplier: Ламбда израз, който НЕ ПРИЕМА аргументи, но връща резултат
        //Supplier<връща> | .get() извиквам действието на Supplier-a
        Supplier<Integer> genRandomInt = () -> new Random().nextInt(51);
        Supplier<LocalDateTime> getTimeNow = () -> LocalDateTime.now();

        int rnd1 = genRandomInt.get();
        int rnd2 = randomNumber();
        System.out.println(rnd1);
        System.out.println(rnd2);
        System.out.println(getTimeNow.get());
    }

    public static int randomNumber() {
        return new Random().nextInt(51);
    }
}
