package ru.javabegin.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.HibernateUtil;
import ru.javabegin.hibernate.dao.interfaces.objects.StatDAO;
import ru.javabegin.hibernate.entity.Stat;
import ru.javabegin.hibernate.entity.Task;
import ru.javabegin.hibernate.entity.User;

import java.util.List;


// реализация всех методов DAO
public class StatDAOImpl implements StatDAO {

    // получение статистики конкретного пользователя (по email)
    @Override
    public Stat getByUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Stat> query = session.createQuery("FROM Stat where user.email like :email");
        query.setParameter("email", "%"+email+"%");
        Stat stat = query.uniqueResult();
        session.close();
        return stat;
    }

    @Override
    public Stat getByUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Stat> query = session.createQuery("FROM Stat where user.email like :email");
        query.setParameter("email", "%"+user.getEmail()+"%");
        Stat stat = query.uniqueResult();
        session.close();
        return stat;
    }



}
