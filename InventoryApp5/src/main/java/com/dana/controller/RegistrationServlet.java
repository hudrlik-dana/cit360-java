package com.dana.controller;

import com.dana.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// servlet for registration
public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

// retrieve user data
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String middleInitial = request.getParameter("middleInitial");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

// create the new user object with name, email, username, and password
        User user = new User(firstName, middleInitial, lastName, email, username, password);

// wrap in try-catch block
        try {

// register using web form
            Registration registration = new Registration();
            boolean result = registration.register(user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");

// if registration succeeds provide option to login
            if(result) {
                out.println("<h1>Congratulations you are now registered</h1>");
                out.println("Login with your Username and Password<a href=login.jsp>click here</a>");

// if registration failed provide option to try again
            } else {
                out.println("<h1>Registration Failed</h1>");
                out.println("To try again<a href=register.jsp>click here</a>");
            }

// display the form
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");

// close the window
        } finally {
            out.close();
        }
    }

}