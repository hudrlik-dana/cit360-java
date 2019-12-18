package com.dana.model;

import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(name = "stock")
public class Stock {

    private int stockId;
    private String stockName;
    private String type;
    private int quantity;

    // maps this field to a column in the database table
    // @Id tells hibernate this is the ID column of the table
    // @Column maps the field to a column in the database table
    // @GeneratedValue tells hibernate this ID column is auto-increment

    @Id
    @Column(name = "stock_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Column(name = "stock_item")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Column(name = "stock_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "stock_quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}