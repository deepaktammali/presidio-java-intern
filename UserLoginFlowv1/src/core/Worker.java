package core;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import actions.*;

public class Worker {
	public static void process(HttpServletRequest req,HttpServletResponse res) {
		String urlPath = (String) req.getAttribute("urlPath");
		
		switch (urlPath) {
		case "/login": {
			(new LoginAction()).execute(req, res);		
			break;
		}
		case "/register": {
			(new RegisterAction()).execute(req, res);
			break;
		}
		case "/logout": {
			(new LogoutAction()).execute(req, res);
			break;
		}
		}
	}
}
