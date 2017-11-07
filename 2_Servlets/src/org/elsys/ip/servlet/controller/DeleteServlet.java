package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }
    protected void doDelete(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException,
            java.io.IOException{
        System.out.println("Here");
        String name = request.getParameter("username");
        System.out.println("Username is " + name);
        User usr = userService.getByName(name);
        System.out.println("User is " + usr);
        userService.removeUser(usr);
        System.out.println("We are done");
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
        dispatcher.forward(request, response);
    }
}
