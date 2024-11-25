package Builder;

// POJO -> Plain old java object
// Само полета, гетъри, сетъри и конструктори
// Builder design pattern
public class User {

    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String email;
    private String country;
    private String city;

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }
}
