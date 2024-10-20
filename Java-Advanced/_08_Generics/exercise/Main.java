import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        int n = Integer.parseInt(scanner.nextLine());
        //
        //        List<Box<String>> boxList = new ArrayList<>();
        //
        //        for (int i = 0; i < n; i++) {
        //            Box<String> stringBox = new Box<>(scanner.nextLine());
        //            boxList.add(stringBox);
        //        }
        //        Box<String> box = new Box<>(scanner.nextLine());
        //        System.out.println(countGreaterElements(boxList, box));

        //        String[] tokens = scanner.nextLine().split("\\s+");

        //        swap(boxList, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        //
        //        boxList.forEach(System.out::println);

        String line = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!"END".equals(line)) {

            CommandInterpreter.interpretCommand(line, customList);

            line = scanner.nextLine();
        }
    }

    private static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }

    private static <T extends Comparable<T>> int countGreaterElements(List<T> data, T element) {
        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);
            if (res > 0) {
                count++;
            }
        }

        return count;
    }
}
