package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        Field[] declaredFields = richSoilLandClass.getDeclaredFields();

        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {

            if ("all".equals(input)) {
                Arrays.stream(declaredFields)
                      .forEach(field -> System.out.printf("%s %s %s\n",
                                                          Modifier.toString(field.getModifiers()),
                                                          field.getType().getSimpleName(),
                                                          field.getName()
                                                         ));
            } else {
                String accessModifier = input;
                Arrays.stream(declaredFields)
                      .filter(field -> Modifier.toString(field.getModifiers()).equals(accessModifier))
                      .forEach(field -> System.out.printf("%s %s %s\n",
                                                          Modifier.toString(field.getModifiers()),
                                                          field.getType().getSimpleName(),
                                                          field.getName()
                                                         ));
            }


            input = scanner.nextLine();
        }
    }
}
