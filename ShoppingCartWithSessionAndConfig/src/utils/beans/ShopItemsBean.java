package utils.beans;

import java.util.ArrayList;

import utils.database.Item;

public class ShopItemsBean {
	public String generateHTML() {
		String shopItemsHTML = "";
		ArrayList<Item> shopItems = Item.findAll();
		
		for(Item item:shopItems){
			shopItemsHTML += ("<tr>");
			shopItemsHTML += ("<td>"+item.getName()+"</td>");
			shopItemsHTML += ("<td>"+item.getPrice()+"</td>");
			shopItemsHTML += ("<td>"+"<input type='checkbox' name='"+item.getName()+"'/>"+"</td>");
			shopItemsHTML += ("</tr>");
		}
		return shopItemsHTML;
	}
}
