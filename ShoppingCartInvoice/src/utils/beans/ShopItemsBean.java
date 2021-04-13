package utils.beans;

import java.util.ArrayList;
import utils.database.Item;
import utils.database.baseclass.ItemDataModel;

public class ShopItemsBean {
	
	private String generateAddToCartHTML(Integer itemId,String shopPath) {
		String elementHTML = String.format("<form action=\"shop/%s\" method=\"POST\">\r\n"
				+ "		<input type=\"hidden\" name=\"id\" value='%d' />\r\n"
				+ "		<input type=\"hidden\" name=\"action\" value=\"postShop\" />\r\n"
				+ "		<button type='submit' class=\"big ui primary button\">Add To Cart</button>\r\n"
				+ "	</form> ",shopPath,itemId);
		return elementHTML;
	}
	
	private String generateShopItemHTML(ItemDataModel item,String shopPath) {
		String shopItemHTMLString = String.format("<div class=\"ui card\">\r\n"
				+ "			<div class=\"ui image\">\r\n"
				+ "				<img\r\n"
				+ "			class='ui image centered' style='height:15rem;width:auto' src=\"%s\">\r\n"
				+ "			</div>\r\n"
				+ "			<div style='display:flex;flex-direction:column;justify-content:space-between;' class=\"content\">\r\n"
				+ "				<a class=\"header\">%s</a>\r\n"
				+ "				<div class=\"description\">%s</div>\r\n"
				+ "			<a style='padding-top:1rem' class=\"header bottom\">Price : %.2f</a>\r\n"
				+ "			</div>\r\n"
				+ "			<div class=\"ui bottom attached button\">\r\n"
				+ 	generateAddToCartHTML(item.getId(),shopPath)
				+ "			</div>\r\n"
				+ "		</div>", item.getImageURL(),item.getName(),item.getDescription(),item.getPrice());
		
		return shopItemHTMLString;
	}
	

	
	public String generateShopHTML(String category,String shopPath) {
		String shopItemsHTML = "";
		ArrayList<Item> shopItems = Item.findByCategory(category);
		for(Item item:shopItems) {
			shopItemsHTML += generateShopItemHTML(item,shopPath);
		}
		return shopItemsHTML;
	}
	
	public String generateShopHTML(String shopPath) {
		String shopItemsHTML = "";
		ArrayList<Item> shopItems = Item.findAll();
		for(Item item:shopItems) {
			shopItemsHTML += generateShopItemHTML(item,shopPath);
		}
		return shopItemsHTML;
	}
}
