package ru.javabegin.hibernate.dao.interfaces.objects;

import ru.javabegin.hibernate.dao.interfaces.CommonDAO;
import ru.javabegin.hibernate.dao.interfaces.FindDAO;
import ru.javabegin.hibernate.entity.User;

/*

Указываем какие интерфейсы будем использовать - это означает, какие возможности будут у объекта
Также можно добавлять любые другие специфичные метода объекта

*/

public interface UserDAO extends CommonDAO<User>, FindDAO<User> {

    // получение только одного пользователя по email
    User getByEmail(String email);
}
