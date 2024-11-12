package reflection_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class Main1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Вземам достъп до информацията на класа Person
        Class personClass = Person.class;

        // getSimpleName -> само името на класа без пакета
        // getName -> пакета + името на класа
        System.out.println(personClass.getName());

        Class superclass = personClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

        Class[] interfaces = personClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        Constructor[] constructors = personClass.getDeclaredConstructors();

        // В една променлива запазих референция за конструктор на класа Person
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        // Временно променя достъпа до този конструктор да е публичен (само в рамките на изпълнението на нашата програма)
        constructor.setAccessible(true);
        Person ivan = constructor.newInstance("Ivan");
        //new Person()

        // Нормален начин:
        // Person person = new Person("Ivan");
    }
}
