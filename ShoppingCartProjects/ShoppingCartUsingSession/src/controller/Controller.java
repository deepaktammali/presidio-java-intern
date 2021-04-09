package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import actions.AddToCartAction;
import dispatcher.Dispatcher;
import utils.AuthHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/shop","/shop/*","/login","/register","/home","/logout"})
public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String reqPath = req.getServletPath();
		if(req.getPathInfo()!=(null)) {
			reqPath = req.getServletPath() + req.getPathInfo();
		}
		System.out.println(reqPath);
		
		switch(reqPath) {
		
		case "/login": {
			res.sendRedirect("login.html");
			break;
		}
		case "/register": {
			res.sendRedirect("register.html");
			break;
		}
		case "/shop":{
			System.out.println("In Shop");
			res.sendRedirect(req.getContextPath()+"");
			break;
		}
		case "/shop/shop1":{
			System.out.println("Shop1");
			res.sendRedirect(req.getContextPath()+"/shop1.jsp");
			break;
		}
		case "/shop/shop2":{
			res.sendRedirect(req.getContextPath()+"/shop2.html");
			break;
		}
		case "/shop/shop3":{
			res.sendRedirect(req.getContextPath()+"/shop3.html");
			break;
		}
		case "/shop/cart":{
			if(AuthHelper.isUserAuthenticated(req)) {
				res.sendRedirect(req.getContextPath()+"/cart.jsp");
			}
			else {
				res.sendRedirect(req.getContextPath()+"/login");
			}
			break;
		}
		default:{
			res.sendRedirect("shop");
		}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		Dispatcher.dispatch(req, res);
	}
	
}
