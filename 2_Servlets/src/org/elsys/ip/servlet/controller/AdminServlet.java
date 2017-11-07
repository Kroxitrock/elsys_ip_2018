package org.elsys.ip.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elsys.ip.servlet.service.UserService;

import static java.lang.System.out;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(!UserService.getLoggedIn().equals(null)) {
			request.setAttribute("users", userService.getUsers());
			getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp")
					.forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.print("You are not logged in. I cannot show you my content.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Cookie ip_username = new Cookie("username", UserService.getLoggedIn().getName());
		Cookie ip_password = new Cookie("password", UserService.getLoggedIn().getPassword());
		ip_username.setMaxAge(60*60*72);
		ip_password.setMaxAge(60*60*72);
		response.addCookie(ip_username);
		response.addCookie(ip_password);
		request.setAttribute("users", userService.getUsers());
		getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp")
			.forward(request, response);
	}


}
