package Task;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Vik", "Aleksandrov", 23, 999999);
        Person person2 = new Person("Ivan", "Ivan", 25, 999999);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        Person capitan = new Person("Ivan", "Ivanov", 25, 999999);
        Team team = new Team("SoftUni", people, capitan);

        team.getPeople().remove(0);

        Person teamCapitan = team.getCapitan();
        teamCapitan.setSalary(1000);

        System.out.println();

    }
}
