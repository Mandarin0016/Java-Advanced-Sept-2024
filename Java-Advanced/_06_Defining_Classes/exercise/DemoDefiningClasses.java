import java.util.List;
import java.util.Set;

public class DemoDefiningClasses {

    public static void main(String[] args) {

        Student student = new Student(1, "Kaloyan", "asd@gmail.com", List.of("Java Advanced"));
        Student student3 = new Student(2, "Peter", "asd@gmail.com");

        Student student1 = new Student();

        student1.setName("Ivan");
        student.setName("Kaloyan Kostadinov");

        System.out.println(student.getName());

        Set<Student> studentSet = Set.of(student, student1, student3);
    }
}
