package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchedUser = request.getParameter("search");
        List<User> users = new ArrayList<>();
        UserService userService = new UserService();
        for(User usr : userService.getUsers()){
            if(usr.getName().equals(searchedUser))
                users.add(usr);
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp")
                .forward(request, response);
    }

}
