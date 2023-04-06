package ru.javabegin.hibernate.dao.interfaces.objects;

import ru.javabegin.hibernate.dao.interfaces.CommonDAO;
import ru.javabegin.hibernate.dao.interfaces.FindDAO;
import ru.javabegin.hibernate.entity.Category;
import ru.javabegin.hibernate.entity.Priority;

/*

Указываем какие интерфейсы будем использовать - это означает, какие возможности будут у объекта
Также можно добавлять любые другие специфичные метода объекта

*/

public interface PriorityDAO extends CommonDAO<Priority>, FindDAO<Priority> {
}
