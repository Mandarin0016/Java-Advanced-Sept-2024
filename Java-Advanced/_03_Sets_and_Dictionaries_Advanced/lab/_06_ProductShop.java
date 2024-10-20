import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> shopInformation = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {

            String[] token = input.split(", ");

            String shopName = token[0];
            String product = token[1];
            double price = Double.parseDouble(token[2]);

            shopInformation.putIfAbsent(shopName, new LinkedHashMap<>());

            Map<String, Double> productInformation = shopInformation.get(shopName);
            productInformation.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shopInformation.entrySet()) {

            System.out.println(entry.getKey() + "->");

            Map<String, Double> productInformation = entry.getValue();
            for (Map.Entry<String, Double> productPriceEntry : productInformation.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productPriceEntry.getKey(), productPriceEntry.getValue());

            }
        }
    }
}
