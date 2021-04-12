package utils.beans;

import java.util.ArrayList;

import utils.database.Fruit;
import utils.database.Item;

public class Shop2ItemsBean {
	public String generateHTML() {
		String shop2ItemsHTML = "";
		ArrayList<Fruit> shop2Items = Fruit.findAll();
		
		for(Fruit fruit:shop2Items){
			shop2ItemsHTML += ("<tr>");
			shop2ItemsHTML += String.format("\"<td><img style='width:5rem;' src=\"%s\"></td>\"",fruit.getImageURL());
			shop2ItemsHTML += ("<td>"+fruit.getName()+"</td>");
			shop2ItemsHTML += ("<td>"+fruit.getPrice()+"</td>");
			shop2ItemsHTML += ("<td>"+"<input type='checkbox' name='"+fruit.getId()+"'/>"+"</td>");
			shop2ItemsHTML += ("</tr>");
		}
		return shop2ItemsHTML;
	}
}
