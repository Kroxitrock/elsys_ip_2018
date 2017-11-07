package org.elsys.ip.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	String name;
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}
	public void doPut(HttpServletRequest request,
					  HttpServletResponse response)
			throws IOException, ServletException
	{


		System.out.println("Name " + name);
		User usr;
		if((usr = userService.getByName(name)) != null) {
			if (!request.getParameter("name").equals("")) {
				usr.setName(request.getParameter("name"));
			}
			if (!request.getParameter("id").equals("")) {
				usr.setID(Integer.valueOf(request.getParameter("id")));
			}
			if (request.getParameter("email").equals("")) {
				usr.setEmail( request.getParameter("email"));
			}
			if (request.getParameter("password").equals("")) {
				usr.setPassword( request.getParameter("password"));
			}

		}


		getServletContext().getRequestDispatcher("/admin")
				.forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stubs
		PrintWriter out = response.getWriter();
		User user = userService.getByName(request.getParameter("name"));

		name = user.getName();

		if (user != null) {

			out.print("<!DOCTYPE html>\n" +
					"<html>\n" +
					"<body>\n"+
					"<form action = \"user\" method = \"POST\">\n"+
					"<table>\n"+
						"<tr>\n"+
							"<th> ID </th>\n"+
							"<th> Email </th>\n"+
							"<th> Name </th>\n"+
							"<th> Password </th>\n"+
						"</tr>\n"+
						"<tr>\n"+
							"<td>" + user.getID() + " </td>\n"+
							"<td>"+ user.getEmail() + "</td>\n"+
							"<td>"+ user.getName() + "</td>\n"+
							"<td>"+ user.getPassword() + "</td>\n"+
						"</tr>\n"+
							"<tr>\n"+
							"<td> <input type=\"text\" name=\"id\" value = \""+ user.getID() + "\"/> </td>\n"+
							"<td> <input type=\"text\" name=\"email\" value =\""+ user.getEmail() + "\"/> </td>\n"+
							"<td> <input type=\"text\" name=\"name\" value = \""+ user.getName() + "\"/> </td>\n"+
							"<td> <input type=\"text\" name=\"password\"value = \"" + user.getPassword() +  "\"/> </td>\n"+
							"</tr>\n"+
					"</table>\n"+
					"<input type=\"submit\" value=\"Submit\"/>"+
					"</form>\n"+
					"</body>\n"+
					"</html>\n"
					);
		} else {
			out.println("Welcome, anonymous.");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPut(request, response);
		doGet(request, response);
	}

}
