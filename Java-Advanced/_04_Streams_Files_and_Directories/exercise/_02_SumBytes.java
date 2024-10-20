import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _02_SumBytes {

    public static void main(String[] args) {
        String path = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
//            int read = bufferedReader.read();
//            while (read != -1) {
//
//                System.out.print((char)read);
//                read = bufferedReader.read();
//            }

            String line = bufferedReader.readLine();
            while (line != null) {

                for (char c : line.toCharArray()) {
                    System.out.print(c);
                    sum += c;
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       // System.out.println(sum);
    }
}
