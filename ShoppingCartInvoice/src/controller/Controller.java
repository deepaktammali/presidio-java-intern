package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import dispatcher.Dispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import utils.AuthHelper;
import utils.QueryStringParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.post.AddToCartAction;

@WebServlet(urlPatterns = { "/shop","/shop/*","/login","/register","/home","/logout" }, initParams = {
		@WebInitParam(name = "server_config", value = "/WEB-INF/config.properties") })

public class Controller extends HttpServlet {
	@Override
	public void init() throws ServletException {
		String serverConfigFilePath = getServletConfig().getInitParameter("server_config");
		System.out.println(serverConfigFilePath);
		serverConfigFilePath = getServletContext().getRealPath(serverConfigFilePath);
		System.out.println(serverConfigFilePath);
		Properties serverProperties = new Properties();
		try {
			serverProperties.load(new FileInputStream(serverConfigFilePath));
			getServletContext().setAttribute("serverConfig", serverProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = "";
		switch (req.getMethod()) {
		case "GET": {

			if (req.getQueryString()!=null && req.getQueryString().length() > 0) {
				try {
					HashMap<String, String> queryMapping = QueryStringParser.parse(req.getQueryString());
					action = queryMapping.get("action");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				action="getHomePage";
			}

			break;
		}
		case "POST": {
			action = req.getParameter("action");
			break;
		}
		default: {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		}
		System.out.println(action);
		Dispatcher.dispatch(req, res, action);

	}
}