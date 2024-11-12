import java.lang.reflect.InvocationTargetException;

public class Exercise1 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Reflection.class;

        //This class type
        System.out.println(reflectionClass.getSimpleName());

        //Super class type
        System.out.println(reflectionClass.getSuperclass().getSimpleName());

        //All interfaces that are implemented by this class
        for (Class anInterface : reflectionClass.getInterfaces()) {
            System.out.println(anInterface.getSimpleName());
        }

        //Instantiate object using reflection and print it too
        Reflection object = (Reflection) reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(object);
    }
}
