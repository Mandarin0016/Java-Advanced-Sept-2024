package reflection_demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main3 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class<Person> personClass = Person.class;

        Author annotation = personClass.getDeclaredAnnotation(Author.class);
        System.out.println(annotation.name());
        System.out.println(annotation.salary());
        System.out.println(annotation.age());




        Person person = new Person("Vik", 20);

        Positive positiveAnnotation = personClass.getDeclaredAnnotation(Positive.class);

        // Логика за валидиране на поле дали то е положителна стойност
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Positive.class)) {
                field.setAccessible(true);
                int value = (int) field.get(person);
                if (value < 0) {
                    throw new IllegalStateException("Invalid number for age!");
                }
            }
        }
    }
}
