package com.tms.web.servlet;

import com.tms.entity.User;
import com.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
	private final UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User byUsername = userService.findByUsername(username);
		if (byUsername.getPassword().equals(password)){
			req.getSession().setAttribute("user", byUsername);
		} else {
			resp.getWriter().print("Wrong password");
		}
	}
}
