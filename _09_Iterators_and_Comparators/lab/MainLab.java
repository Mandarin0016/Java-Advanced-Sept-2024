import java.util.List;

public class MainLab {

    public static void main(String[] args) {

        // A: Масив
        String[] names = new String[5];
        names[0] = "Vik";
        names[1] = "Desi";
        names[2] = "Pesho";
        names[3] = "Gosho";
        names[4] = "Ivan";
        print("Bulgaria", names);


        // B: Varargs = позволява ни да подаваме стойности (от 0 до n)
        // Правила:
        // 1. Имаме право само на 1 varargs аргумнет за един метод
        // 2. Тип varargs се ползва само за аргументи на методи   НЕ МОЖЕ String... books = "Harry Potter", "Hobbit";
        // 3. Тип varargs аргумент се слага последен в сигнатурата на метода
        print("Bulgaria", "Desi", "Pesho", "Gosho", "Ivan");
        print("Bulgaria", "Desi");
//        print("Bulgaria", 2, 3, 4, 5, 6, 7, 8);

        printLists(List.of("0", "1"), List.of("Ivan", "Gosho"));
    }

    private static void print(String country, String... names) {

        // този varargs параметър ще работи като масив
        //System.out.println(firstNames[0]);

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void print2(String country, String[] names) {

        // този varargs параметър ще работи като масив
        //System.out.println(firstNames[0]);

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void printLists(List<String>... lists) {

        System.out.println(lists[1]);
        for (List<String> list : lists) {

        }
    }
}
