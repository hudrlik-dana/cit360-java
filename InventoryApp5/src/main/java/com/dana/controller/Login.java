package com.dana.controller;

import com.dana.hibernate.util.HibernateUtil;
import com.dana.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

// login class interacts with login servlet and view layer
public class Login {

// verify username and password
    public boolean verifyUser(String username, String password) {
        User user = getUserByUsername(username);

// test for valid username and password
        if(user != null && user.getUsername().equals(username) && user.getPassword().equals(password))  {
            return true;
        } else {
            return false;
        }
    }
// get username of user and open a session singleton of hibernate util
    public User getUserByUsername(String username) {
        Session session = HibernateUtil.openSession();

// initialize transaction and user to null
        Transaction transaction = null;
        User user = null;

// wrap in try-catch block
        try {
            transaction = session.getTransaction();
            transaction.begin();

// query database for a specific name and username
            Query query = session.createQuery("from User where username = '" + username + "'");
            user = (User)query.uniqueResult();

// when found commit the transaction
            transaction.commit();

// catch the exception and roll back the transaction
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
// print the stacktrace
            exception.printStackTrace();

// close the session
        } finally {
            session.close();
        }
        return user;
    }
// create a collections of users in an array list
    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();

// open the sesson
        Session session = HibernateUtil.openSession();

// initialize the transaction to null
        Transaction transaction = null;

// wrap in try-catch block
        try {
            transaction = session.getTransaction();
            transaction.begin();

// create the query and store in list variable
            list = session.createQuery("from User").list();

// commit the transaction
            transaction.commit();

// catch the exception
        } catch (Exception exception) {
            if (transaction != null) {

// rollback the transaction if not correct
                transaction.rollback();
            }
// print the stacktrace
            exception.printStackTrace();

// close the database
        } finally {
            session.close();
        }

// if successful return the list
        return list;
    }
}