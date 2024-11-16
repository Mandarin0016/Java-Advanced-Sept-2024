package entities.user;

import java.util.UUID;

public class User {

    // Уникалност на потребителите
    private UUID id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.id = UUID.randomUUID();
        setUsername(username);
        setPassword(password);
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

    void setUsername(String username) {
        UserValidator.validateUsername(username);
        this.username = username;
    }

    void setPassword(String password) {
        UserValidator.validatePassword(password);
        this.password = password;
    }
}
