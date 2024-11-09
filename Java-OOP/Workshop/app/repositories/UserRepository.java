package repositories;

import entities.user.User;

import java.util.*;

public class UserRepository implements Repository<User, UUID> {

    private final Map<UUID, User> userStorage = new HashMap<>();

    @Override
    public void save(UUID uuid, User entity) {
        this.userStorage.put(uuid, entity);
    }

    @Override
    public User getById(UUID uuid) {
        return this.userStorage.get(uuid);
    }

    @Override
    public List<User> getAll() {
        return userStorage.values().stream().toList();
    }
}
