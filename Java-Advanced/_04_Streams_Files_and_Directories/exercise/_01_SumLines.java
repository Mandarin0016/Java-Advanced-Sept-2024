import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _01_SumLines {

    public static void main(String[] args) {
        String path = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                long sum = 0;

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
