import java.io.File;
import java.nio.file.Files;

public class _07_ListFiles {

    public static void main(String[] args) {

        File folder = new File("C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\Files-and-Streams");

        File[] files = folder.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%s: [%d]\n", file.getName(), file.length());
            }
        }
    }
}
