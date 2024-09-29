package _03_defining_classes;

public class Person {

    public static String country = "Bulgaria";
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    // Utility/помощтна логига
    public static void sayHello(){
        System.out.println("Hi, I am a person!");
    }
}
