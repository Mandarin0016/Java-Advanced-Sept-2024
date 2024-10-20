import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _08_GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);

        int totalSize = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    totalSize += file.length();
                }
            }
        }

        System.out.println(totalSize);
    }
}
