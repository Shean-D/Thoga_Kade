package repository;

import java.util.List;

public interface CrudDao <T , ID> extends SuperDao{

    boolean save(T entity);

    boolean update(T entity, ID id);

    T search(ID id);

    boolean delete(ID id);

    List<T> getAll();
}
