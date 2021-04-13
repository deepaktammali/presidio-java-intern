package utils.beans;

import java.util.ArrayList;
import java.util.Vector;

import utils.database.Item;
import utils.database.baseclass.ItemDataModel;

public class CartItemsBean {
	
	Vector<ItemDataModel> cartItems;
	
	public CartItemsBean() {
	}
	
//	<div class="ui celled list">
//	  <div class="item">
//	    <img class="ui avatar image" src="/images/avatar/small/helen.jpg">
//	    <div class="content">
//	      <div class="header">Snickerdoodle</div>
//	      An excellent companion
//	    </div>
//	  </div>
//	  <div class="item">
//	    <img class="ui avatar image" src="/images/avatar/small/daniel.jpg">
//	    <div class="content">
//	      <div class="header">Poodle</div>
//	      A poodle, its pretty basic
//	    </div>
//	  </div>
//	  <div class="item">
//	    <img class="ui avatar image" src="/images/avatar/small/daniel.jpg">
//	    <div class="content">
//	      <div class="header">Paulo</div>
//	      He's also a dog
//	    </div>
//	  </div>
//	</div>
	
	private String generateCartItemHTML(ItemDataModel item) {
		String cartItemHTML = "<div style='width:100%;display:flex;' class=\"item\">\r\n" + String.format("<div class=\"image\">\r\n"
				+ "      <img style='height:10rem;width:10rem;' src=%s>\r\n"
				+ "    </div>\r\n"
				+ "    <div style='display:flex;flex-direction: column;align-items: stretch;justify-content:space-around' class=\"content\">\r\n"
				+ "      <a class=\"header\">%s</a>\r\n"
				+ "      <div class=\"description\">\r\n"
				+ "        <p>%s</p>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "<h2 class=\"ui sub header\">\r\n"
				+ "  Price \r\n"
				+ "</h2>\r\n"
				+ "<span> %.2f</span>"
				+ "  </div>", item.getImageURL(),item.getName(),item.getDescription(),item.getPrice());
		
		return cartItemHTML;
	}
	
	private String generateShopItemHTML(ItemDataModel item) {
		
		String shopItemHTMLString = String.format("<div class=\"ui card\">\r\n"
				+ "			<div class=\"ui image\">\r\n"
				+ "				<img\r\n"
				+ "			class='ui image centered' style='height:15rem;width:auto' src=\"%s\">\r\n"
				+ "			</div>\r\n"
				+ "			<div style='display:flex;flex-direction:column;justify-content:flex-start;' class=\"content\">\r\n"
				+ "				<a class=\"header\">%s</a>\r\n"
				+ "				<div class=\"description\">%s</div>\r\n"
				+ "			<a style='padding-top:1rem' class=\"header bottom\">Price : %.2f</a>\r\n"
				+ "<h2 class=\"ui sub header\">\r\n"
				+ "  Price\r\n"
				+ "</h2>\r\n"
				+ "<span>%.2f</span>"
				+ "			</div>\r\n"
				+ "		</div>", item.getImageURL(),item.getName(),item.getDescription(),item.getPrice());
		return shopItemHTMLString;
	}
	
	
	public String generateCartHTML() {
		String cartItemsHTML = "";
		
		if(cartItems==null) {
			return "<h1 class=\"ui center aligned header\">Your Cart is Empty</h1>";
		}
		
		for(ItemDataModel cartItem:cartItems) {
			cartItemsHTML += generateCartItemHTML(cartItem);
		}
		return cartItemsHTML;
	}

	public Vector<ItemDataModel> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Vector<ItemDataModel> cartItems) {
		this.cartItems = cartItems;
	}
	
}
