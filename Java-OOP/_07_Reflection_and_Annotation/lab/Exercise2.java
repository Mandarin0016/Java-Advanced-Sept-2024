import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise2 {

    public static void main(String[] args) {

        //Print to console each getter on a new line in the format:
        //"{name} will return class {Return Type}"
        //Then print all setters in the format:
        //"{name} and will set field of class {Parameter Type}"

        Class reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();

        //Getters
        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get"))
                .forEach(getter -> System.out.printf("%s will return class %s\n", getter.getName(), getter.getReturnType().getSimpleName()));

        //Setters
        for (Method method : allMethods) {
            if (method.getName().startsWith("set")) {
                Class[] parameterTypes = method.getParameterTypes();
                System.out.printf("%s and will set field of class %s\n", method.getName(), parameterTypes[0].getSimpleName());
            }
        }
    }
}
