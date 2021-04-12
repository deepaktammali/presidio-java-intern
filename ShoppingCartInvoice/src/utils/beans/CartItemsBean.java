package utils.beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Vector;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.jsp.JspWriter;
import utils.database.Item;
import utils.database.baseclass.*;

public class CartItemsBean {
	Vector<String> cartItems;

	public CartItemsBean() {
	}

	public String generateHTML() {
		String cartItemsHTML = "";
		if (cartItems == null) {
			cartItemsHTML += "<h2>Cart Is Empty</h2>";
		} else {
			double totalCartPrice = 0.0;
			cartItemsHTML += ("<table>" + "<tr>" + "<th>Product Name</th>" + "<th>Product Price</th>"
					+ "<th>Product Description</th>" + "</tr>");
			for (String item : cartItems) {
				ItemDataModel cartItem = Item.findByName(item);
				
				if(cartItem==null) {
					continue;
				}
				
				totalCartPrice += cartItem.getPrice();
				cartItemsHTML += ("<tr>");
				cartItemsHTML += ("<td>" + cartItem.getName() + "</td>");
				cartItemsHTML += ("<td>" + cartItem.getPrice() + "</td>");
				cartItemsHTML += ("<td>" + cartItem.getDescription() + "</td>");
				cartItemsHTML += ("</tr>");
			}
			cartItemsHTML += ("</table>");
			cartItemsHTML += ("Total Cart Price is : " + totalCartPrice);
		}
		return cartItemsHTML;
	}

	public Vector<String> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Vector<String> cartItems) {
		this.cartItems = cartItems;
	}

}