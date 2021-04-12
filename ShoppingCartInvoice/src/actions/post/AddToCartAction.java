package actions.post;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.Action;
import utils.AuthHelper;

public class AddToCartAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
			if(!AuthHelper.isUserAuthenticated(req)) {
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		
			HttpSession userSession = req.getSession();
			Vector<String> cartItems = (Vector<String>) userSession.getAttribute("cart");
			
			if(cartItems==null) {
				cartItems = new Vector<String>();
			}
			Enumeration<String> itemsToAddToCart =req.getParameterNames();
			while(itemsToAddToCart.hasMoreElements()) {
				cartItems.add(itemsToAddToCart.nextElement());
			}
			userSession.setAttribute("cart", cartItems);
			res.sendRedirect(req.getContextPath()+"/index.jsp");
	}
	
}
