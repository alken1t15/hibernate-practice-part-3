

import entity.User;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        // сразу получаем готовый SessionFactory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        User user = new User();
        user.setEmail("newfromapp3@email.com");
        user.setUsername("newfromapp3");
        user.setUserpassword("2asdfsdsdf");

        session.save(user);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.close();
    }

}
