package com.dana.controller;

import com.dana.model.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


// hibernate database operations are performed via a Session obtained from a SessionFactory

    public class StockController {

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
                // troubleshooting a null pointer exception
                sessionFactoryError.printStackTrace();
            }
        }

        // close the SessionFactory
        protected void exit() {
            // code to close Hibernate Session factory
        }

        // add an item to the database
        protected void create() {
            Stock item = new Stock();
            item.setStockId(2);
            item.setStockName("Snow Shovels");
            item.setType("personal equipment");
            item.setQuantity(4);

            // open the session and start a transaction
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // call to session.save(object) method to put a
            // mapped object into the database
            session.save(item);

            // commit and close the transaction
            session.getTransaction().commit();
            session.close();

        }

        // returns the object of a specific class that
        // maps a row in the database table
        // get an item
        protected void read() {
            Session session = sessionFactory.openSession();

            int stockId = 10;
            Stock stock = session.get(Stock.class, stockId);

            System.out.println("Stock item ID: " + stock.getStockId());
            System.out.println("Name: " + stock.getStockName());
            System.out.println("Type: " + stock.getType());
            System.out.println("Quantity: " + stock.getQuantity());

            session.close();
        }

        // update a mapped object to the database
        // modify an item
        protected void update() {
            Stock item = new Stock();
            item.setStockId(1);
            item.setStockName("Snow Blower");
            item.setType("winter equipment");
            item.setQuantity(2);

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(item);

            session.getTransaction().commit();
            session.close();
        }

        // remove a mapped object from the database
        // remove an item
        protected void delete() {
            Stock item = new Stock();
            item.setStockId(0);

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(item);

            session.getTransaction().commit();
            session.close();
        }

        // run the application
        public static void main(String[] args) {
            StockController stockController = new StockController();
            stockController.setup();
            stockController.create();
            stockController.exit();
        }
    }