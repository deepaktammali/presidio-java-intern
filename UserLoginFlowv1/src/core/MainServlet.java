package core;

import java.io.IOException;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/login","/register","/home"})

public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
	
		switch (urlPath) {
		case "/login": {
			resp.sendRedirect("");
			break;
		}
		case "/register": {
			resp.sendRedirect("register.html");
			break;
		}
		default: {
			resp.sendRedirect("");
			break;
		}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		req.setAttribute("urlPath", urlPath);
		Worker.process(req, resp);
	}

}
