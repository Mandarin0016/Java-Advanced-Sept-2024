
@Company(name = "SoftUni")
public class Employee {

    private String name;
    private String address;

    private Employee() {
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}
