package com.dana.model;

import com.dana.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.io.Serializable;

// connect to the database 'inventory_db_2' table 'inventorylogin' with User class
@Entity
@Table(name = "inventorylogin")
public class User implements Serializable {

// @GeneratedValue tells hibernate this id column is auto incremented
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String email;
    private String username;
    private String password;

// User() method
    public User() {
    }

// constructors
    public User(String firstName, String middleInitial, String lastName, String email, String userId, String password) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.email = email;
        this.username = userId;
        this.password = password;
    }

// getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

// determine if user is already in the database
    public boolean doesUserExist() {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction transaction = null;

// wrap in try-catch block
        try {

// start the transaction with the database
            transaction = session.getTransaction();
            transaction.begin();

// query the database for username
            Query query = session.createQuery("from User where username ='" + getUsername() + "'");
            User user = (User)query.uniqueResult();

// commit transaction to database if information is correct
            transaction.commit();
            if(user != null) result = true;

        } catch(Exception exception) {

// rollback transaction if not complete
            if(transaction != null) {
                transaction.rollback();
            }
// close session
        } finally{
            session.close();
        }
// return result
        return result;
    }
}