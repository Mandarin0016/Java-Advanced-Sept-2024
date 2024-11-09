package services.imp;

import core.SessionManager;
import entities.user.User;
import repositories.UserRepository;
import services.UserService;

import java.util.List;

import static common.LogMessages.*;
import static common.SystemErrors.*;

public class UserServiceImp implements UserService {

    private SessionManager sessionManager;
    private UserRepository userRepository;

    public UserServiceImp(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.userRepository = new UserRepository();
    }

    @Override
    public String login(String username, String password) {

        validateActiveUserSession();

        // 2. Fetch user from the Database
        User user = userRepository.getAll().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INCORRECT_LOGIN_CREDENTIALS));

        // 3. Check if the given password is the one for that user
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException(INCORRECT_LOGIN_CREDENTIALS);
        }

        // 4. Set the current active user is the one that just logged in
        sessionManager.setActiveUser(user);

        // 5. Print Info log for successful login
        return SUCCESSFULLY_LOGGED_IN.formatted(username);
    }

    private void validateActiveUserSession() {

        // 1. Check if a user is already logged in and reject another log in attempt.
        if (sessionManager.hasActiveSession()) {
            throw new IllegalStateException(USER_ALREADY_LOGGED_IN.formatted(sessionManager.getActiveUser().getUsername()));
        }
    }

    @Override
    public String register(String username, String password) {

        // 1. Check if a user is already logged in and reject another log in attempt.
        validateActiveUserSession();

        // 2. Validate such username does not exist and register new user
        boolean usernameAlreadyExist = getAllUsers().stream().anyMatch(user -> user.getUsername().equals(username));
        if (usernameAlreadyExist) {
            throw new IllegalArgumentException(SUCH_USERNAME_ALREADY_EXIST.formatted(username));
        }

        User user = new User(username, password);

        // 3. Persist the newly created user
        userRepository.save(user.getId(), user);
        login(user.getUsername(), user.getPassword());

        // 4. Print info log for successful registration
        return SUCCESSFULLY_REGISTERED.formatted(user.getUsername());
    }

    @Override
    public String logout() {

        // 1. Check if there is an active session
        if (!sessionManager.hasActiveSession()) {
            throw new IllegalStateException(NO_ACTIVE_USER_SESSION_FOUND);
        }

        // 2. Get the active user + terminate the user session
        User activeUser = sessionManager.getActiveUser();
        sessionManager.terminateActiveSession();

        // 3. Print info log for successful log out
        return SUCCESSFULLY_LOGGED_OUT.formatted(activeUser.getUsername());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
