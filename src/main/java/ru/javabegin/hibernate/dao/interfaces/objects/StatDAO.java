package ru.javabegin.hibernate.dao.interfaces.objects;

import ru.javabegin.hibernate.dao.interfaces.CommonDAO;
import ru.javabegin.hibernate.entity.Stat;
import ru.javabegin.hibernate.entity.User;

/*

Указываем какие интерфейсы будем использовать (если необходимо) - это означает, какие возможности будут у объекта
Также можно добавлять любые другие специфичные метода объекта

В данном интерфейсе - мы ничего не неследуем, т.к. общая статистика только получает одно значение по email (остальные методы ему не нужны)

*/

public interface StatDAO {

    // получение статистики конкретного пользователя (несколькими способами)
    Stat getByUser(String email);
    Stat getByUser(User user);
}
