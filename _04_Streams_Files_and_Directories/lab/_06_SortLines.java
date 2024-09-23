import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\input.txt");
        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
