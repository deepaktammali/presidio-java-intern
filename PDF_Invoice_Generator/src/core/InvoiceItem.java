package core;

public class InvoiceItem {
	private String description;
	private double unitCost;
	private int quantity;
	
	public InvoiceItem(String description, double unitCost, int quantity) {
		super();
		this.description = description;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
