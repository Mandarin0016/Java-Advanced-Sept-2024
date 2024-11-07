package examples.DIP;

public interface Database {

    void saveUser(String firstName, String lastName);
    void remove(String firstName);
}
