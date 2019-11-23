package com.dana;

// hibernate can automatically map fields of a class to fields of a table
// if the fields have the same name, automatically maps Java data types
// to SQL data types - not need to map remaining fields title, author, price

// annotations to map the class to the mysql table "book" from JPA
// using @Entity and @Table(name = "book")
import javax.persistence.*;

@Entity
@Table (name = "book")
public class Book {

    private long id;
    private String title;
    private String author;
    private float price;

    // annotations to tell hibernate this is the ID column of the table
    // maps this field to a column in the database table
    // @Id tells hibernate this is the ID column of the table
    // @Column maps the field to a column in the database table
    // @GeneratedValue tells hibernate this ID column is auto-increment

    @Id
    @Column (name = "book_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
