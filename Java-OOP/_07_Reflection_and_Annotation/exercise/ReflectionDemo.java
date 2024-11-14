import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //        Employee employee1 = new Employee("Kaloyan", "Sofia");

        // access class
        Class<Employee> employeeClass = Employee.class;
        // Class<Employee> employee = (Class<Employee>) Class.forName("Employee");
        // Class<? extends Employee> employee1Class = employee1.getClass();

        // access fields
        Field[] allFields = employeeClass.getDeclaredFields(); // return all fields(public, private, protected)
        Field[] publicFieldsOnly = employeeClass.getFields(); // return only public fields

        for (Field field : allFields) {
            System.out.println(field.getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println(Modifier.isPrivate(field.getModifiers()));
        }

        // access constructors
        Constructor<Employee> allArgConstructor = employeeClass.getDeclaredConstructor
                                                               (String.class, String.class);
        Constructor<Employee> noArgConstructor = employeeClass.getDeclaredConstructor();

        Employee employee = allArgConstructor.newInstance("Kaloyan", "Sofia");

        noArgConstructor.setAccessible(true);

        Employee employee1 = noArgConstructor.newInstance();

        // access methods
        Method[] allMethods = employeeClass.getDeclaredMethods(); // return all methods(public, private, protected)
        Method[] publicMethods = employeeClass.getMethods();// return all public methods and
        // also all inherited public methods

        Method toStringMethod = allMethods[1];
        System.out.println(toStringMethod.invoke(employee));

        Field privateField = allFields[0];
        privateField.setAccessible(true);
        privateField.set(employee, "Peter");
        System.out.println();
        System.out.println(toStringMethod.invoke(employee));
    }
}
