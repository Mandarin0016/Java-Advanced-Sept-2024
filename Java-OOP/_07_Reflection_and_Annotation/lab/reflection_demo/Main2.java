package reflection_demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class personClass = Person.class;

        Person person = new Person();
        Field field = personClass.getDeclaredField("name");
        field.setAccessible(true);

        int mask = field.getModifiers();
        System.out.println(Modifier.isPrivate(mask));
        System.out.println(Modifier.isFinal(mask));
        System.out.println(Modifier.isPublic(mask));

        // Мога да вземам стойност за това поле от конкретни обекти от класа Person
        System.out.println(field.get(person));

        // Мога да променям стойност за това поле в конкретни обекти от класа Person
        field.set(person, "Vik");

        System.out.println(field.get(person));


        Method[] allMethods = personClass.getDeclaredMethods();
        Method tellSumMethod = personClass.getDeclaredMethod("tellSum", int.class, int.class, int.class);
        // Начин 1: С рефлекшън
        tellSumMethod.setAccessible(true);
        tellSumMethod.invoke(person, 2, 3, 4);
        // Начин 2: Чрез обекта
        //person.tellSum(2, 3, 4);

        Method helloMethod = personClass.getDeclaredMethod("hello", String.class);
        helloMethod.setAccessible(true);
        helloMethod.invoke(null, "Ivan");

        int modifiers = helloMethod.getModifiers();
    }
}
