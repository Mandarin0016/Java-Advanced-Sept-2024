import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _04_ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
