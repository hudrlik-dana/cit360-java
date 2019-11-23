package com.dana;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


// in hibernate database operations are performed via a Session
// which is obtained from a SessionFactory

public class BookManager {

    // the SessionFactory loads hibernate config file
    // analyzes the mapping and creates a connection to
    // the mysql database
    protected SessionFactory sessionFactory;

    // load Hibernate Session factory
    protected void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                // configures settings from hibernate.cfg.xml
                .configure()
                .build();
        try {
            // once sessionFactory built it can open a Session and
            // start a transaction and call methods to do database
            // operations save(), get(), update(), delete()
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            // to commit the transaction and close the session:
            // session.getTransaction().commit();
            // session.close()

        } catch (Exception sessionFactoryError) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    // to close the SessionFactory in exit method:
    // sessionFactory.close();
    protected void exit() {
        // code to close Hibernate Session factory
    }

    // add a book to the database
    protected void create() {

        Book book = new Book();
        book.setTitle("Dana works on Hibernate");
        book.setAuthor("Dana Hudrlik");
        book.setPrice(10.25f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // call to session.save(object) method to put a
        // mapped object into the database
        session.save(book);

        session.getTransaction().commit();
        session.close();

    }

    // returns the object of a specific class that
    // maps a row in the database table
    // get a book
    protected void read() {
        Session session = sessionFactory.openSession();

        long bookId = 20;
        Book book = session.get(Book.class, bookId);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());

        session.close();
    }

    // update a mapped object to the database
    // modify a book
    protected void update() {
        Book book = new Book();
        book.setId(20);
        book.setTitle("Java Programming Guru");
        book.setAuthor("Troy Tuckett");
        book.setPrice(99.99f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(book);

        session.getTransaction().commit();
        session.close();
    }
    // remove a mapped object from the database
    // remove a book
    protected void delete() {
        Book book = new Book();
        book.setId(20);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(book);

        session.getTransaction().commit();
        session.close();
    }

    // run the application
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.setup();

        manager.create();

        manager.exit();
    }
}
