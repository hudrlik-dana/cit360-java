package com.dana.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

// class to return the SessionFactory object singleton
public class HibernateUtil {

// SessionFactory loads hibernate config file
    private static final SessionFactory sessionFactory;

    static {

// wrap in try-catch block
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

// catch exception if sessionFactory creation fails
        } catch (Throwable initializationException) {
            System.err.println("SessionFactory creation failure." + initializationException);
            throw new ExceptionInInitializerError(initializationException);
        }
    }

// open session
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}