import java.util.List;
import java.util.Objects;

public class Student {

    private Long id;
    private String name;
    private String email;
    private List<String> courses;

    public Student() {

    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(long id, String name, String email, List<String> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = courses;

    }

    public Student(long id, String name, String email) {
        this(id, name, email, List.of("Java Advanced", "Java OOP"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, courses);
    }
}
