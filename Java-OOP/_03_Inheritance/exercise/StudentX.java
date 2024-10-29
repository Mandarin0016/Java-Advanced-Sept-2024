import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentX extends PersonParent {

    private List<Integer> grades;

    public StudentX(String name, String email) {
        super(name, email);
        this.grades = new ArrayList<>();
    }

    public List<Integer> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }
}















