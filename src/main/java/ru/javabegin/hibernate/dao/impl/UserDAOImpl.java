package ru.javabegin.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.HibernateUtil;
import ru.javabegin.hibernate.dao.interfaces.objects.UserDAO;
import ru.javabegin.hibernate.entity.Stat;
import ru.javabegin.hibernate.entity.User;

import java.util.List;

// реализация всех методов DAO
public class UserDAOImpl implements UserDAO {


    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User");
        List<User> list = query.getResultList(); // получение коллекции должно быть до закрытия сессии
        session.close();
        return list;
    }

    // будет искать всех пользователей, у которых есть вхождение текста в значении email
    @Override
    public List<User> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User where email like :email");
        query.setParameter("email", "%" + email + "%");
        List<User> list = query.getResultList(); // получение коллекции должно быть до закрытия сессии
        session.close();
        return list;
    }

    @Override
    public User get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id); // получаем единичный объект
        session.close();
        return user;
    }

    @Override
    public void update(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.update(obj); // если id объекта НЕ будет заполнено - выйдет ошибка (Hibernate не поймет какую именно строку хотите обновить)
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        User u = new User();// создаем временный объект и заполняем его id
        u.setId(id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.save(obj); // если id объекта будет заполнено - БД перезапишет это поле
        session.getTransaction().commit();
        session.close();
    }


    // получить конкретного пользователя по его почте (а не коллекции пользователей как в методах find)
    @Override
    public User getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User where email = :email");
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.close();
        return user;
    }
}
