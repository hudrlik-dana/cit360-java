package com.dana.controller;

import com.dana.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// servlet for login
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

// retrieve the data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

// create the login object
        Login login = new Login();

// verify user name and password
        boolean result = login.verifyUser(username, password);
        User user = login.getUserByUsername(username);

// if user login successful
        if(result){
            request.getSession().setAttribute("user", user);

// redirect display to home page
            response.sendRedirect("home.jsp");
        }

// if user login fails display error page
        else {
            response.sendRedirect("error.jsp");
        }
    }
}