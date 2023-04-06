package ru.javabegin.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.HibernateUtil;
import ru.javabegin.hibernate.dao.interfaces.objects.TaskDAO;
import ru.javabegin.hibernate.entity.Task;

import java.util.List;

// реализация всех методов DAO
public class TaskDAOImpl implements TaskDAO {

    @Override
    public List<Task> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task");
        List<Task> list = query.getResultList(); // получение коллекции должно быть до закрытия сессии
        session.close();
        return list;
    }

    @Override
    public List<Task> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task t where t.user.email like :email");
        query.setParameter("email", "%"+email+"%");
        List<Task> list = query.getResultList(); // получение коллекции должно быть до закрытия сессии
        session.close();
        return list;
    }

    @Override
    public Task get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task user = session.get(Task.class, id); // получаем единичный объект
        session.close();
        return user;
    }

    @Override
    public void update(Task obj) {
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
        Task u = new Task();// создаем временный объект и заполняем его id
        u.setId(id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Task obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.save(obj); // если id объекта будет заполнено - БД перезапишет это поле
        session.getTransaction().commit();
        session.close();
    }

    // найти все завершенные или незавершенные задачи по конкретному пользователю
    @Override
    public List<Task> find(boolean completed, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task t where t.user.email like :email and t.completed = :completed");
        query.setParameter("email", "%"+email+"%");
        query.setParameter("completed", completed);
        List<Task> list = query.getResultList(); // получение коллекции должно быть до закрытия сессии
        session.close();
        return list;
    }
}
