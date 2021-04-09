package dispatcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;
import java.util.Properties;

import utils.AuthHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.Action;
import actions.post.AddToCartAction;
import actions.post.LoginAction;
import actions.post.LogoutAction;
import actions.post.RegisterAction;

public class Dispatcher {
	
	public static void dispatch(HttpServletRequest req,HttpServletResponse res,String action){
		
		Properties serverProperties = (Properties) req.getServletContext().getAttribute("serverConfig");
		String actionClass = serverProperties.getProperty(action);
		Action requestedAction;
		try {
			requestedAction = (Action)Class.forName(actionClass).getConstructor().newInstance();
			requestedAction.execute(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
//	public static void dispatch(HttpServletRequest req,HttpServletResponse res){
//		
//		String reqPath = req.getServletPath();
//		
//		Properties serverConfig = (Properties) req.getServletContext().getAttribute("serverConfig");
//		
//		for(Entry<Object, Object> prop:serverConfig.entrySet()) {
//			System.out.println((String)prop.getKey());
//			System.out.println((String)prop.getValue());
//		}
//		
//		System.out.println(req.getParameter("action"));
//		
//		if(req.getPathInfo()!=(null)) {
//			reqPath = req.getServletPath() + req.getPathInfo();
//		}
//
//		try {
//			
//			switch(reqPath) {
//			case "/shop/shop1":{
//				(new AddToCartAction()).execute(req, res);
//				break;
//			}
//			case "/shop/shop2":{
//				(new AddToCartAction()).execute(req, res);
//				break;
//			}
//			case "/shop/shop3":{
//				(new AddToCartAction()).execute(req, res);
//				break;
//			}
//			case "/login": {
//				(new LoginAction()).execute(req, res);		
//				break;
//			}
//			case "/register": {
//				(new RegisterAction()).execute(req, res);
//				break;
//			}
//			case "/logout": {
//				(new LogoutAction()).execute(req, res);
//				break;
//			}
//			default:{
//				res.sendRedirect("shop.html");
//			}
//			}
//		}
//		catch(IOException e) {
//			System.out.println(e);
//		}
//	}
}
