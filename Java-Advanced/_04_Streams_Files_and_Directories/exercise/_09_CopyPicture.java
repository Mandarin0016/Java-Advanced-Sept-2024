import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class _09_CopyPicture {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\copy-picture.jpg";

        try (InputStream fis = Files.newInputStream(Path.of(inputPath));
             OutputStream ous = Files.newOutputStream(Path.of(outputPath))
        ) {
            byte[] inputBytes = fis.readAllBytes();
            ous.write(inputBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
