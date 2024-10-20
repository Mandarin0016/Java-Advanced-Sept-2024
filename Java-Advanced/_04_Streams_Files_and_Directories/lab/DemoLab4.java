import java.io.*;
import java.util.Scanner;

public class DemoLab4 {

    public static void main(String[] args) throws IOException {

        // 2 вида потоци от данни:
        // - Input (четем информация) stream (отваряме този поток от данни към някакъв ресурс)
        // - Output (пишем информация) stream (отваряме този поток от данни към някакъв ресурс)

        String path = "C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\demo";
//        FileInputStream fileInputStream = new FileInputStream(path);

//        FileReader fileReader = new FileReader(path);
//        FileWriter fileWriter = new FileWriter(path);
//        fileWriter.write("Вик");
//        fileWriter.write("Вик");
//
//        // отразява всички чакащи промени на файла
//        fileWriter.flush();
//
//        // четене от същият файл
//        fileWriter.write("Вик");
//        fileWriter.close();

        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thirdLine = scanner.nextLine();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Softuni\\Java-Advanced-Sept-2024\\_04_Streams_Files_and_Directories\\lab\\resources\\demo");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.println(firstLine);
        printWriter.println(secondLine);
        printWriter.println(thirdLine);
        printWriter.close();

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
        bufferedWriter.write("sdsdsd");




    }
}
