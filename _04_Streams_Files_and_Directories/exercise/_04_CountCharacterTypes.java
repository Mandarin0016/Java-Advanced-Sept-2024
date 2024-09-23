import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class _04_CountCharacterTypes {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";

        // vowels, other symbols, and punctuation marks
        int vowels = 0;
        int punctuations = 0;
        int others = 0;

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationsSet = Set.of('!', ',', '.', '?');

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath));
             PrintStream printStream = new PrintStream(Files.newOutputStream(Path.of(outputPath)))
        ) {

            String line = br.readLine();

            while (line != null) {
                line = line.replaceAll(" ", "");
                for (char symbol : line.toCharArray()) {
                    if (vowelsSet.contains(symbol)) {
                        vowels++;
                    } else if (punctuationsSet.contains(symbol)) {
                        punctuations++;
                    } else {
                        others++;
                    }
                }

                line = br.readLine();
            }

            printStream.printf("Vowels: %d\n", vowels);
            printStream.printf("Other symbols: %d\n", others);
            printStream.printf("Punctuation: %d", punctuations);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
