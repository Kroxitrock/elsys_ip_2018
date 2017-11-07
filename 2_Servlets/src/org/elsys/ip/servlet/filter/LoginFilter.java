package org.elsys.ip.servlet.filter;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	UserService users = new UserService();

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("name");
		String password = request.getParameter("password");

		User user;
		boolean authorized;

		if(UserService.getLoggedIn() != null)
			authorized = true;
		else if((user = users.getByName(username)) != null && password != null) {
			if (password.equals(user.getPassword())) {
				authorized = true;
				UserService.setLoggedIn(user);
			} else authorized = false;
		}else authorized = false;
		HttpServletResponse resp = (HttpServletResponse)response;
		if (authorized) {
			chain.doFilter(request, response);
		} else {
			if(username != null)
			request.setAttribute("error", "Wrong username or password!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		UserService.addUser(1, "Solaire", "solaire@sun", "123456");
		UserService.addUser(2, "Lucatiel", "lucatiel@mirrah", "123456");
		UserService.addUser(3, "Anri", "anri@astora", "123456");
	}

}
