package com.tms.web.servlet;

import com.tms.entity.Operation;
import com.tms.entity.User;
import com.tms.service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {

	private final CalcService calcService = new CalcService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		String operation = req.getParameter("operation");
		User user = (User) req.getSession().getAttribute("user");
		Operation calc = calcService.calc(num1, num2, operation, user);
		resp.getWriter().print(calc);
	}

}
