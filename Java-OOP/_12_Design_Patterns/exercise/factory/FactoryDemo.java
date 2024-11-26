package factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class FactoryDemo {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        String cakeType = scanner.nextLine();
        double diameter = Double.parseDouble(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        int pieces = Integer.parseInt(scanner.nextLine());

        Cake cake = CakeFactory.createCake(cakeType, diameter, price, pieces);
        cake.prepare();
        cake.bake();
        cake.box();
    }
}
