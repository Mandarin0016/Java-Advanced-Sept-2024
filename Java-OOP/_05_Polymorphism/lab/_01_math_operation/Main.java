package _01_math_operation;

public class Main {

    public static void main(String[] args) {

        //Method overloading: повече от 1 метод със същото име, но различен брой/вид аргументи и различен return type
        System.out.println(MathOperation.add(3, 3));
        System.out.println(MathOperation.add(3, 3, 3));
        System.out.println(MathOperation.add(3, 3, 3, 3));
    }
}
