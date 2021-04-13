package actions.post;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.Action;
import utils.AuthHelper;
import utils.database.Fruit;
import utils.database.Item;
import utils.database.baseclass.FruitModel;
import utils.database.baseclass.ItemDataModel;

public class AddToCartAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//			if(!AuthHelper.isUserAuthenticated(req)) {
//				res.sendRedirect(req.getContextPath()+"/login.jsp");
//			}
		
			HttpSession userSession = req.getSession();
			
			Vector<ItemDataModel> cartItems = (Vector<ItemDataModel>) userSession.getAttribute("cart");
			if(cartItems==null) {
				cartItems = new Vector<ItemDataModel>();
			}
			
//			switch (shop) {
//			case "shop1":{
//				Enumeration<String> itemsToAddToCart =req.getParameterNames();
//				while(itemsToAddToCart.hasMoreElements()) {
//					cartItems.add(Item.findByName(itemsToAddToCart.nextElement()));
//				}
//				break;
//			}
//			case "shop2":{
//				Enumeration<String> itemsToAddToCart =req.getParameterNames();
//				while(itemsToAddToCart.hasMoreElements()) {
//					try { 
//				        int fruitId = Integer.parseInt(itemsToAddToCart.nextElement()); 
//				    	FruitModel fruit = Fruit.findByID(fruitId);
//						cartItems.add(new Item(fruit.getName(),fruit.getPrice(),fruit.getDescription()));
//				    } catch(NumberFormatException|NullPointerException e) { 
//				        continue;
//				    } 
//				}
//			}
//			}
			
			Integer itemId = Integer.parseInt(req.getParameter("id"));
			
			ItemDataModel cartItem = Item.findByID(itemId);
			cartItems.add(cartItem);
//			System.out.println(itemId);
//			System.out.println(cartItem);
			userSession.setAttribute("cart", cartItems);
			res.sendRedirect(req.getContextPath()+req.getPathInfo()+".jsp");
	}
	
}
