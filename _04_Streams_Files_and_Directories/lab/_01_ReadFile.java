import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01_ReadFile {

    public static void main(String[] args) throws IOException {

        // 2 вида потоци от данни:
        // - Input (четем информация) stream (отваряме този поток от данни към някакъв ресурс)
        // - Output (пишем информация) stream (отваряме този поток от данни към някакъв ресурс)

        // 1. Задавам пътя до файла
        String path = "C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\input.txt";

        // чете байт по байт (1 символ) от файл
        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = fileStream.read();
        }
    }
}
