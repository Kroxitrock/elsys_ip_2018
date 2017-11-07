package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewServlet")
public class AddNewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService.addUser(Integer.valueOf(request.getParameter("id")), request.getParameter("name"), request.getParameter("email"), request.getParameter("password") );
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
        dispatcher.forward(request, response);
    }

}
