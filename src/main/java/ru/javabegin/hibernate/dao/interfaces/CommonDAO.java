package ru.javabegin.hibernate.dao.interfaces;

import java.util.List;

/*

реализация основных операций
CRUD (Create, Read, Update, Delete)

 */

public interface CommonDAO<T> {

    // получить одно значение по id
    // слово get - чаще всего означает, что вернется один объект
    T get(long id);

    // обновить значение
    void update(T obj);

    // удалить значение по id
    void delete(long id);

    // добавить значение
    void add(T obj);

}
