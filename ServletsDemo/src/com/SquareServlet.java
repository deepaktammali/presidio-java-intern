package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = Integer.parseInt(req.getAttribute("result").toString());
		double resultSquared = Math.pow(result, 2);
		PrintWriter out = resp.getWriter();
		out.println("Result Squared is : "+resultSquared);
	}
}
