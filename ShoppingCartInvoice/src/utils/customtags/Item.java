package utils.customtags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import utils.database.baseclass.ItemDataModel;

public class Item extends SimpleTagSupport {
	String name;
	double price;
	String description;
	
	public Item() {
		
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("<tr>"
				+ "<td>"+getName()+"</td>"
				+ "<td>"+getPrice()+"</td>"
				+ "<td>"+getDescription()+"</td>"
				+ "</tr>");
		getJspContext().getOut().print("<tr>"
				+ "<td>"+getName()+"</td>"
				+ "<td>"+getPrice()+"</td>"
				+ "<td>"+getDescription()+"</td>"
				+ "</tr>");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
