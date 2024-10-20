import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_MergeTwoFiles {

    public static void main(String[] args) {

        String inputPath1 = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPath2 = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output3.txt";

        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inputPath1));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inputPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader1.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader1.readLine();
            }

            line = reader2.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader2.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
