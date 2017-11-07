package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService.setLoggedIn(null);
        Cookie [] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("username")){
                cookie.setValue(null);
                response.addCookie(cookie);
            }
            if(cookie.getName().equals("password")){
                cookie.setValue(null);
                response.addCookie(cookie);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
