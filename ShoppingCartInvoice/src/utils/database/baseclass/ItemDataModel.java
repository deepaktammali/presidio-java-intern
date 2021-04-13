package utils.database.baseclass;

public abstract class ItemDataModel {
	protected Integer id;
	protected String name;
	protected double price;
	protected String description;
	protected String imageURL;
	protected String category;
	
	public ItemDataModel(String name, double price, String description,String imageURL,String category) {
		this.id=null;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageURL = imageURL;
		this.category = category;
	}
	
	public ItemDataModel(Integer id, String name, double price, String description,String imageURL,String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageURL = imageURL;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
