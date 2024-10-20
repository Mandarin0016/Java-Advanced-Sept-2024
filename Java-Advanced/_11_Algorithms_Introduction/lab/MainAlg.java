import java.util.Scanner;

public class MainAlg {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        for (int number = 10; number >= 1; number--) {
//            System.out.print(number + " ");
//        }
//        System.out.println();

        while (true){
            System.out.println("Hi Nasko!");
        }

//        decrementAndPrintNumbers(10);

//        System.out.println();
//        System.out.println("Finish");

    }

    private static void decrementAndPrintNumbers(int number) {

        // Проверка дали съм стигнал дъното на моята рекурсия
        if (number == 0) {
            return;
        }

        System.out.print(number + " ");
        decrementAndPrintNumbers(number - 1);
    }
}
