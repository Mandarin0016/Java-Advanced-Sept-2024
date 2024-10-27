package Task;

public class Person {

    // 1. Полета - private
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    // 2. Конструктор: създава нови обекти
    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    // 3. Методи
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    //Salary can't be less than 460.0
    public void setSalary(double salary) {
        if (salary < 460) {
            // Хвърлянето на грешка = спиране на програмата
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    //Names must be at least 3 symbols
    public void setFirstName(String firstName) {
        // Валидирам дали името на човека е повече от 3 символа
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    //Names must be at least 3 symbols
    public void setLastName(String lastName) {
        // Валидирам дали името на човека е повече от 3 символа
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    //Age must not be zero or negative
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary(double bonus) {
        // 20% bonus
        if (this.age < 30) {
            // age < 30 -> salary + 10%
            this.salary += this.salary * (bonus / 200);
            //this.salary += this.salary * ((bonus / 100) * 0.5);
        } else {
            // age >= 30 -> salary + 20%
            this.salary += this.salary * (bonus / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", this.firstName, this.lastName, this.salary);
    }
}
