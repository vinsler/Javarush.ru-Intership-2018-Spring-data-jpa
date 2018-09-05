package parts.dao;

import java.util.List;

public interface DaoInterfaceDetail<T, ID> {
    T find(ID i);
    boolean add(T t);               // добавлять
    boolean update(T t);            // редактировать
    boolean delete(ID i);           // удалять
    List <T> findByName(ID i);      // поиск по имени
    List <T> findAll();             // все детали
}
