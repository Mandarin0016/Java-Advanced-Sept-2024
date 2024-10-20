package _01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList.add(person);

        }

        personList.stream()
                  .filter(person -> person.getAge() > 30)
//                  .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                  .sorted(Comparator.comparing(Person::getName))
                  .forEach(person -> System.out.println(person));
    }
}
