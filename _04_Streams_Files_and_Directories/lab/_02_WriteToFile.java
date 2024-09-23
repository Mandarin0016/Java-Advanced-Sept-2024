import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _02_WriteToFile {

    public static void main(String[] args) throws IOException {


        // четене на файл
        String pathToRead = "C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathToRead);

        // писане на файл
        String pathToWrite = "C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\02.WriteToFileOutput.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(pathToWrite);

        //Skip the following symbols: ",", ".", "!", "?".

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            char currentChar = (char) oneByte;
            if (currentChar != ',' && currentChar != '.' && currentChar != '!' && currentChar != '?') {
                fileOutputStream.write(oneByte);
            }
            oneByte = fileInputStream.read();
        }
    }
}
