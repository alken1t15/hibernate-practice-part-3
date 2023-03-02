

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Log4j2
public class Main {

    public static void main(String[] args) {

        log.info("Hibernate tutorial started");

        // сразу получаем готовый SessionFactory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        // получение запросы - получение всех пользователей
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root);
//        criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("id"),10000));
//        Predicate p1 = criteriaBuilder.gt(root.get("id"),10000);
//        Predicate p2 = criteriaBuilder.lt(root.get("id"),20000);
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1,p2));
        // выполнение запроса с получением результата
//        Query q = session.createQuery(criteriaQuery);
//        List<User> users = q.getResultList();

//        session.getTransaction().begin();
//
//        log.info("transaction start");
//
//        User user = new User();
//        user.setEmail("newfromapp3@email.com");
//        user.setUsername("newfromapp3");
//        user.setUserpassword("2asdfsdsdf");
//
//        session.save(user);
//
//        session.getTransaction().commit();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete =cb.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.where(cb.equal(root.get("id"),10514));

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();

        session.close();
        HibernateUtil.close();
    }

}
