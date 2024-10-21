package _02_Point_in_Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //0 0 3 3
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        //5
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //x y
            //0 0
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            System.out.println(rectangle.contains(point));
        }
    }
}
