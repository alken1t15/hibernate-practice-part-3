package ru.javabegin.hibernate.dao.interfaces.objects;

import ru.javabegin.hibernate.dao.interfaces.CommonDAO;
import ru.javabegin.hibernate.dao.interfaces.FindDAO;
import ru.javabegin.hibernate.entity.Role;
import ru.javabegin.hibernate.entity.Stat;

import java.util.List;

/*

Указываем какие интерфейсы будем использовать - это означает, какие возможности будут у объекта
Также можно добавлять любые другие специфичные метода объекта

Роли у нас статичные (не изменяются) - может изменять только админ БД
Роли пользователь сразу получает при выборке User (EAGER)

*/

public interface RoleDAO {

}
