import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class DemoInheritance {

       /*
                    ----- Inheritance ------

          One of the 4 OOP principles ( Abstraction, Encapsulation, Inheritance, Polymorphism )

          Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.

          Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

          When you inherit from an existing class, you can reuse methods and fields of the parent class.
          Moreover, you can add new methods and fields in your current class also.

          To inherit from a class, use the extends keyword.
          - subclass (child) - the class that inherits from another class
          - superclass (parent) - the class being inherited from

          ----- Inheritance - Benefits -----
          - For Method Overriding (so runtime polymorphism can be achieved).
          - For Code Reusability.

          * Multiple Inheritance is not allowed in Java

        */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        StudentX studentX = new StudentX("Kaloyan", "asd@abv.bg");

        Lector lector = new Lector("Peter", "peter@gmail.com");

        List<PersonParent> persons = List.of(studentX, lector);

        //        System.out.println(lector.getClass().getName());
        //        System.out.println(lector.getClass().getSimpleName());

        Field[] declaredFields = studentX.getClass().getDeclaredFields();
        Constructor<? extends StudentX> declaredConstructor = studentX.getClass().getDeclaredConstructor(String.class, String.class);

        StudentX studentX1 = declaredConstructor.newInstance("Kaloyan Kostadinov", "asdf@mail.com");

        Arrays.stream(declaredFields).forEach(declaredField -> System.out.println(declaredField.getName()));

        //        persons.forEach(PersonParent::printInfo);

        //        lector.printInfo();
        //        System.out.println();
        //        studentX.printInfo();
    }


}
