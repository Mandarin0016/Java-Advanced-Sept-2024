import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lector extends PersonParent {

    private List<String> courses;

    public Lector(String name, String email) {
        super(name, email);
        this.courses = new ArrayList<>();
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }
}
