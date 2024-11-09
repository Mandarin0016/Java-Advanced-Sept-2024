package repositories;

import java.util.List;

public interface Repository<T, ID> {

    void save(ID id, T entity);

    T getById(ID id);

    List<T> getAll();
}
