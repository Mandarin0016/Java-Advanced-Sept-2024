public class Person {

    private final String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.address = address;
        this.name = name;
        this.age = age;
        //        this.setName(name);
        //        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    //    public void setName(String name) {
    //        if (name.isEmpty() || name.isBlank()) {
    //            throw new IllegalArgumentException("Name cannot be empty or blank!");
    //        }
    //        this.name = name;
    //    }

    public int getAge() {
        return age;
    }

    //    public void setAge(int age) {
    //        if (age <= 0){
    //            throw new IllegalArgumentException("Age cannot be negative or zero!");
    //        }
    //        this.age = age;
    //    }

    public Address getAddress() {
        return address;
    }
}
