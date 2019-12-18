package com.dana.controller;

import com.dana.hibernate.util.HibernateUtil;
import com.dana.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

// registration class interacts with registration servlet and view layer
public class Registration {

    public boolean register(User user) {

// open the session
        Session session = HibernateUtil.openSession();

// do not register a new user if user already exists in the database
        if(user.doesUserExist()) return false;
        Transaction transaction = null;

// wrap in try-catch block
        try {
// start the transaction with the database
            transaction = session.getTransaction();
            transaction.begin();

// save new data or update existing data
            session.saveOrUpdate(user);

// commit transaction to database
            transaction.commit();

        } catch (Exception exception) {

// rollback transaction if not complete
            if (transaction != null) {
                transaction.rollback();
            }
// print the stacktrace
            exception.printStackTrace();

// close the session
        } finally {
            session.close();
        }
        return true;
    }

}