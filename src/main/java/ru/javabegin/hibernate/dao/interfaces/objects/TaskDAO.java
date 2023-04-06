package ru.javabegin.hibernate.dao.interfaces.objects;

import ru.javabegin.hibernate.dao.interfaces.CommonDAO;
import ru.javabegin.hibernate.dao.interfaces.FindDAO;
import ru.javabegin.hibernate.entity.Task;

import java.util.List;

/*

Указываем какие интерфейсы будем использовать - это означает, какие возможности будут у объекта
Также можно добавлять любые другие специфичные метода объекта

*/

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {

    // найти все завершенные или незавершенные задачи по любому пользователю
    List<Task> find(boolean completed, String email);

}
