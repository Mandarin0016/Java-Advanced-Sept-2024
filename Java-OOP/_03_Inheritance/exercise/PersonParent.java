public class PersonParent {

    private String name;
    private String email;

    public PersonParent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void printInfo() {
        System.out.printf("Type: %s, Name: %s, Address: %s\n",
                          this.getClass().getSimpleName(),
                          this.name, this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
