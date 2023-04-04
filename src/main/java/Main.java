

import entity.Category;
import entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

//import javax.persistence.Query;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Objects;

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

        //Delete

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<User> criteriaDelete =cb.createCriteriaDelete(User.class);
//        Root<User> root = criteriaDelete.from(User.class);
//        criteriaDelete.where(cb.equal(root.get("id"),10514));
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(criteriaDelete).executeUpdate();
//        transaction.commit();
// Update

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaUpdate<User> criteriaUpdate =cb.createCriteriaUpdate(User.class);
//        Root<User> root = criteriaUpdate.from(User.class);
//        criteriaUpdate.set("email","kramzos@gmail.com");
//        criteriaUpdate.where(cb.equal(root.get("id"),10025));
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(criteriaUpdate).executeUpdate();
//        transaction.commit();
//
//        session.close();
//        HibernateUtil.close();


        //HQL
//        Query query = session.createQuery("from User u");
//        List<User> userList = query.getResultList();

//        Query query = session.createQuery("from User u where u.email like :text");
//        query.setParameter("text","%a%");
//        List<User> userList = query.getResultList();


//        Query<User> query = session.createQuery("from User u where u.id = :id");
//        query.setParameter("id",24324234L);
//        User user = query.uniqueResult();

//        Query<Long> query = session.createQuery(" select count(u.id) from User  u where email like :text");
//        query.setParameter("text","%email%");
//       Long count = query.uniqueResult();


//        Query<User> query = session.createQuery(" select new User(u.email ,u.username) from User  u where id=:id");
//        query.setParameter("id",10037L);
//        User user =  query.uniqueResult();

//        log.info(user.getUsername());

//        String qry = "select * from todolist.user_data";
//        NativeQuery sqlQuery = session.createSQLQuery(qry);
//        sqlQuery.setMaxResults(10);
//        sqlQuery.addEntity(User.class);
//
//        List<User> list = sqlQuery.list();
//
//        log.info(list);

//        NativeQuery<Object[]> nativeQuery = session.createNativeQuery("select " +
//                "count(u.id)," +
//                "substring(u.email, position('@' in u.email)+1, length(u.email)) as domainemail " +
//                "from todolist.user_data u " +
//                "where u.email like '%@%' " +
//                "group by substring(u.email, position('@' in u.email)+1, length(u.email))");
//
//        for (Object[] obj : nativeQuery.getResultList()) {
//            log.info(obj[0]);
//            log.info(obj[1]);
//            log.info("-------");
//        }
        //        log.info(userList);

//        User user = session.get(User.class,10025L);
//
//        log.info(user);

//        Query query = session.createQuery("from User ");
//        query.setMaxResults(1);
//        List<User> users = query.getResultList();
//
//        log.info(users.get(0).getPriorities());

//        Query query = session.createQuery("from Category ");
//        query.setMaxResults(10);
//
//        List<Category> categories = query.getResultList();
//
//        for(Category c : categories){
//            log.info(c.getTitle());
//        }

//        Query query = session.createQuery("from User ");
//        query.setMaxResults(10);
//
//        List<User> users = query.getResultList();
//
//        for(User u : users){
//            log.info(u.getUsername());
//        }

//        Query query = session.createQuery("from User ");
//        query.setMaxResults(2);
//
//        List<User> users = query.getResultList();
//
//        log.info(users.get(0).getRoles());

//        User user1 = session.get(User.class,10025L);
//
//        log.info(user1);
//
//        session.close();
//
//        session = HibernateUtil.getSessionFactory().openSession();
//
//        User user2 = session.get(User.class,10025L);
//
//        log.info(user2);
//
//        session.close();
//
//        log.info ("hit " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
//        log.info ("miss " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheMissCount ());
//        log.info ("put " + HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCachePutCount());
//        for (String s : HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheRegionNames()) {
//            log.info(s);
//        }
//        HibernateUtil.close();

//        User u1 = session.get(User.class,10032L);
//
//        session.beginTransaction();
//
//        session.delete(u1);
//
//        session.getTransaction().commit();

//        session.beginTransaction();
//
//        for(int i = 0 ; i<200;i++){
//            User user =  new User();
//            user.setUsername("name " + i);
//            user.setEmail("name " + i);
//            user.setUserpassword("ffdgfdgdagfd");
//
//            session.save(user);
//
//            if(i % 100 == 0){
//                session.flush();
//            }
//        }
//
//        session.getTransaction().commit();

        User user = session.get(User.class,10068L);
        log.info(user);
        session.close();

        HibernateUtil.close();

    }

}