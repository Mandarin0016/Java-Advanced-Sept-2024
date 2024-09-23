
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class DemoStreamsFilesAndDirectories {

    public static void main(String[] args) {

     /*
        FileInputStream, FileOutputStream - Read and Write byte by byte
        FileReader, FileWriter - Read and Write character by character
        Scanner(InputStream)
        PrintWriter - uses Writer
        BufferedReader, BufferedWriter - uses Reader, Writer

      */

        String path = "C:\\Users\\Kaloyan\\Desktop\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Scanner scanner = new Scanner(fileInputStream);

            System.out.println(scanner.nextLine());
            int oneByte = fileInputStream.read();

            while (oneByte != -1) {
                // System.out.print(Integer.toBinaryString(oneByte) + " ");
               // System.out.print((char) oneByte);
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(path)) {

            int read = fileReader.read();

            while (read != -1) {
                // System.out.print((char) read);
                read = fileReader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
