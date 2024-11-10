package services.imp;

import entities.user.User;
import services.UserService;

import java.util.List;

// TODO:
// 1. Implement all methods
// 2. Make sure this service implementation has dependency a SessionManager
// so you can determine which is the currently logged in user.
public class UserServiceImpl implements UserService {



    @Override
    public String login(String username, String password) {
        return "";
    }

    @Override
    public String register(String username, String password) {
        return "";
    }

    @Override
    public String logout() {
        return "";
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
