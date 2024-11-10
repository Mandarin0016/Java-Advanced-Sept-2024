package repositories;

import java.util.List;

// TODO:
// 1. Implement all methods into the relevant Repository
// 2. T generic stands for the entity type that a repository will store
// 3. ID generic stands for the unique identifier of the entity the repository will store
public interface Repository<T, ID> {

    void save(ID id, T entity);

    T getById(ID id);

    List<T> getAll();
}
