import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class _11_SerializeCustomObject {

    public static void main(String[] args) {


        Course course = new Course("Java Advanced", 300);
        String path = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))
        ) {
            // serializing
            objectOutputStream.writeObject(course);
            course.setStudents(350);
            // deserializing
            Object obj = objectInputStream.readObject();
            if (obj instanceof Course){
                Course deserializedCourse = (Course) obj;
                System.out.println(deserializedCourse.getStudents());
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
