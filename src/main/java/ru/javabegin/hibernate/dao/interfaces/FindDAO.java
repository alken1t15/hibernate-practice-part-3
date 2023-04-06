package ru.javabegin.hibernate.dao.interfaces;

import java.util.List;

// различные поиски, которые возвращают коллекции
public interface FindDAO<T> {

    // получить абсолютно все значения
    List<T> findAll();

    // получить все значения по значению почты
    // слово find - чаще всего означает, что вернется коллекция объектов
    List<T> findAll(String email);
}
