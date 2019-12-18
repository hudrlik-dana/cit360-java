package com.dana.controller;

import com.dana.model.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StockServlet")

// servlet inherits HttpServlet
public class StockServlet extends HttpServlet {

    // declare a constant STOCK_ITEM_ADDED to print later in getPOST
    public static final String STOCK_ITEM_ADDED = "Item added";

    // in-memory list the servlet uses to store the items sent by the client
    // later will write to a file using IO writer and reader
    private List<Stock> stockItems = new ArrayList<Stock>();

    // this method processes all the HTTP GET requests routed to the servlet by the web container
    // loops through the lists of items that have been sent to it and generates a plain/text
    // list of items that is sent back to the user
    // handler methods doGet and doPost

// doGet part - receives commands being sent across the http network

    // overriding a subset of the function to implement business functions
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // set content type to plain text
        response.setContentType("text/plain");

        // loop through all the sorted videos and print them out for user to see
        PrintWriter sendToUser = response.getWriter();
        // iterate through the list using for each : loop
        for (Stock eachItem : this.stockItems) {
            // write out a string to the client, next line for clean list
            sendToUser.write((eachItem.getStockId() + " : " + eachItem.getStockName() +
                    " : " + eachItem.getType() + " : " + eachItem.getQuantity() + "\n"));
        }
    }

    // this method handles all HTTP POST requests routed to the servlet by the web container
    // sending a post to the servlet with 'id', 'name', 'type', 'quantity' parameters causes a
    // new item to be created and added to the list of items in stock
    // if the user fails to send one of these parameters, the servlet generates an
    // http error 400 (bad request) response indicating that a required request parameter was missing

    // do post part - http to java to correct values to datatype conversion to doing logic

    // user to send an item to save
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // extract data from user input
        String stockId = request.getParameter( "id");
        String stockName = request.getParameter("name");
        String type = request.getParameter("type");
        String quantity1 = request.getParameter("quantity");

        // ensure quantity parameter from the user is a number
        int quantity = -1;
        try {
            quantity = Integer.parseInt(quantity1);

            // user sent a quantity value that is not a number
        } catch (NumberFormatException exceptionNotANumber) {

        }
        // set content type as text
        response.setContentType("text/plain");

        // the servlet looks at each request parameter the user was expected to provide
        // is not null, empty, etc

        // if value is not what expected - null, error checking, the data in an http request may not
        // be valid
        if (stockId == null || stockName == null || type == null || quantity1 == null
                // stockName is more than 1 character, type is at least 5 characters long
                || stockName.trim().length() < 1 || type.trim().length() < 5
                // quantity is greater than 0
                || quantity1.trim().length() < 1 || quantity <= 0) {

            // error code and message sent to user if they made a mistake
            response.sendError(400);
            response.getWriter().write("Missing ['stockItemName'.'stockItemType'.'quantity']");

            // if data provided is correct
        } else {
            // create a new stockItemName object and add it to list
            // convert to correct type and parse to an integer datatype
            quantity = Integer.parseInt(quantity1);

            // construct the item to store in the list
            Stock eachItem = new Stock();

            // logic to add item to the list
            stockItems.add(eachItem);

            // confirm to user item was added, using the defined constant STOCK_ITEM_ADDED
            response.getWriter().write(STOCK_ITEM_ADDED);
        }
    }
}