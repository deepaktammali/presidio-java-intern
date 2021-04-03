package datamodel.baseclass;

public abstract class ItemDataModel {
	protected Integer id;
	protected String name;
	protected double price;
	protected String description;
	
	public ItemDataModel(String name, double price, String description) {
		this.id=null;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public ItemDataModel(Integer id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
