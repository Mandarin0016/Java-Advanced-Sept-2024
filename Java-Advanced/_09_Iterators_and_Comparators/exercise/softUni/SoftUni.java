package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private List<Student> data;
    private int capacity;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    // getCapacity()
    public int getCapacity() {
        return capacity;
    }

    // getCount() method – returns the number of students in the course.
    public int getCount() {
        return this.data.size();
    }

    // insert(Student student) method – adds an entity to the data if there is a hall for it.
    // Returns "Added student {firstName} {lastName}." –  if the student is successfully added.
    // Returns "Student is already in the hall." –  if the student is already in the hall.
    // Returns "The hall is full." - if the hall is full.
    public String insert(Student student) {

        Student student1 = this.data.stream().filter(s -> s.getFirstName().equals(student.getFirstName()) &&
                                                          s.getLastName().equals(student.getLastName()))
                                    .findFirst()
                                    .orElse(null);

        if (this.data.size() == this.capacity) {
            return "The hall is full.";
        } else if (student1 != null) {
            return "Student is already in the hall.";
        }

        this.data.add(student);

        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    //remove(Student student) method – removes the student
    //Returns "Removed student {firstName} {lastName}." –  if the student is successfully removed.
    //Returns "Student not found." if the student is not in the hall.
    public String remove(Student student) {
        boolean isRemoved = this.data.remove(student);

        if (isRemoved) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }

        return "Student not found.";
    }

    // getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        return this.data.stream().filter(s -> s.getFirstName().equals(firstName) &&
                                              s.getLastName().equals(lastName))
                        .findFirst()
                        .orElse(null);
    }

    // getStatistics() – returns a String in the following format:
    //	"Hall size: {addedStudentsCount}
    // Student: {firstName} {lastName}, Best Course = {bestCourse}
    // Student: {firstName} {lastName}, Best Couse = {bestCourse}
    // (…)"
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %s", this.data.size()));

        this.data.forEach(student -> {
            sb.append(System.lineSeparator());
            sb.append(student.toString());
        });

        return sb.toString();
    }
}
