package dispatcher;

import java.io.IOException;

import actions.AddToCartAction;
import actions.LoginAction;
import actions.LogoutAction;
import actions.RegisterAction;
import utils.AuthHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dispatcher {
	
	public static void dispatch(HttpServletRequest req,HttpServletResponse res){
		String reqPath = req.getServletPath();
		if(req.getPathInfo()!=(null)) {
			reqPath = req.getServletPath() + req.getPathInfo();
		}

		try {
			
			switch(reqPath) {
			case "/shop/shop1":{
				(new AddToCartAction()).execute(req, res);
				break;
			}
			case "/shop/shop2":{
				(new AddToCartAction()).execute(req, res);
				break;
			}
			case "/shop/shop3":{
				(new AddToCartAction()).execute(req, res);
				break;
			}
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
			default:{
				res.sendRedirect("shop.html");
			}
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
