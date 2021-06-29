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
import java.util.List;

@WebServlet(name = "HistoryServlet",urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

	private CalcService calcService = new CalcService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<Operation> all = calcService.findAllByUser(user);
		for (Operation operation : all) {
			resp.getWriter().println(operation);
		}
	}
}
