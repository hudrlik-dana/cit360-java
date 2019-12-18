package com.dana.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class StockList {
    private static int idValue = 1;

    private final List<Stock> stockInventoryList = new ArrayList<>();

    public List<Stock> getStockInventoryList() {
        return Collections.unmodifiableList(stockInventoryList);
    }

    public void addItem(@NonNull Stock toAdd) {

        toAdd.setStockId(idValue);
        stockInventoryList.add(toAdd);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<Stock> itemIterator = stockInventoryList.listIterator();

        while (itemIterator.hasNext()) {
            Stock item = itemIterator.next();

            if (item.getStockId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public Stock getItem(int id) {
        for (Stock item : stockInventoryList) {
            if (item.getStockId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull Stock toUpdate) {
        ListIterator<Stock> itemIterator = stockInventoryList.listIterator();

        while (itemIterator.hasNext()) {
            Stock item = itemIterator.next();

            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
                break;
            }
        }
    }

}
