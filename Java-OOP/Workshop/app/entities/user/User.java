package entities.user;

import java.util.UUID;

public class User {

    private UUID id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.id = UUID.randomUUID();
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
