import java.io.*;

public class _09_SerializeCustomObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Person person = new Person("Ivan", 24);
//
//        FileOutputStream fos = new FileOutputStream("C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\demo");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//        oos.writeObject(person);

        FileInputStream fis = new FileInputStream("C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\demo");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Human person = (Human) ois.readObject();
    }
}
