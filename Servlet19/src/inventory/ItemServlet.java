package inventory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ItemServlet")

// servlet inherits HttpServlet
public class ItemServlet extends HttpServlet {

    // declare a constant ITEM_ADDED to print later in getPOST
    public static final String ITEM_ADDED = "Item added";

    // in-memory list the servlet uses to store the items sent by the client
    // later will write to a file using IO writer and reader
    private List<Item> items = new ArrayList<Item>();

    // this method processes all the HTTP GET requests routed to the servlet by the web container
    // loops through the lists of items that have been sent to it and generates a plain/text
    // list of items that is sent back to the client
    // handler methods doGet and doPost

// doGet part - receives commands being sent across the http network

    // overriding a subset of the function to implement business functions
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // set content type to plain text
        response.setContentType("text/plain");

        // loop through all the sorted videos and print them out for client to see
        PrintWriter sendToClient = response.getWriter();
        // iterate through the list using for each : loop
        for (Item eachItem : this.items) {
            // write out a string to the client, next line for clean list
            sendToClient.write((eachItem.getItemName() + " : " + eachItem.getUrl() + "\n"));
        }
    }

    // this method handles all HTTP POST requests routed to the servlet by the web container
    // sending a post to the servlet with 'name', 'quantity', and 'url' parameters causes a
    // new item to be created and added to the list of items in stock
    // if the client fails to send one of these parameters, the servlet generates an
    // http error 400 (bad request) response indicating that a required request parameter was missing

    // do post part - http to java to correct values to datatype conversion to doing logic

    // client to send an item to save
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // extract data from client
        String itemName = request.getParameter("Name");
        String url = request.getParameter("url");
        String quantity1 = request.getParameter("Quantity");

        // ensure quantity parameter from the client is a number
        int quantity = -1;
        try {
            quantity = Integer.parseInt(quantity1);

            // client sent a quantity value that is not a number
        } catch (NumberFormatException exceptionNotANumber) {

        }
        // set content type as text
        response.setContentType("text/plain");

        // the servlet looks at each request parameter the client was expected to provide
        // is not null, empty, etc

        // if value is not what expected - null, error checking, the data in an http request may not
        // be valid
        if (itemName == null || url == null || quantity1 == null
                // itemName is more than 1 character, url is at least 10 characters long
                || itemName.trim().length() < 1 || url.trim().length() < 10
                // quantity is greater than 0
                || quantity1.trim().length() < 1 || quantity <= 0) {

            // error code and message sent to client if they made a mistake
            response.sendError(400);
            response.getWriter().write("Missing ['itemName'.'quantity'.'url']");

            // if data provided is correct
        } else {
            // create a new itemName object and add it to list
            // convert to correct type and parse to an integer datatype
            quantity = Integer.parseInt(quantity1);

            // construct the item to store in the list
            Item eachItem = new Item(itemName, url, quantity);

            // logic to add item to the list
            items.add(eachItem);

            // confirm to client item was added, using the defined constant ITEM_ADDED
            response.getWriter().write(ITEM_ADDED);
        }
    }
}

