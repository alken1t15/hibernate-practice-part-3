package ru.javabegin.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

// спец. Java класс для инициализации Hibernate
public class HibernateUtil {

    // Фабрика для создания сессий
    private static final SessionFactory sessionFactory = initSessionFactory();

    // Этот метод вызывается автоматически, т.к. он вызывается из статичной переменной
    private static SessionFactory initSessionFactory() {
        try {
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Этот метод будем вызывать, когда потрбуется SessionFactory
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            initSessionFactory();
        }

        return sessionFactory;
    }

    // Закрыть все соединения с помощью SessionFactory
    public static void close() {
        getSessionFactory().close();
    }
}