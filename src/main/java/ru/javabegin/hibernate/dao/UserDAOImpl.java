package ru.javabegin.hibernate.dao;

import ru.javabegin.hibernate.HibernateUtil;
import ru.javabegin.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements CommonDao<User>{

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(  "FROM User");
        List<User> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<User> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery( "FROM User where email=:email");
        query.setParameter( "email", email);
        List<User> list = query.getResultList();
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
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User u = new User();// создаем временный объект и заполняем его id
        u.setId(id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj); // |/ если id объекта будет заполнено - выйдет о
        session.getTransaction().commit();
        session.close();
    }
}
