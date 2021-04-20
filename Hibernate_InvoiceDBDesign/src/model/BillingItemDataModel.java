package model;

public abstract class BillingItemDataModel {
	protected Integer id;
	protected Integer invoiceId;
	protected Integer itemId;
	protected Integer quantity;

	public BillingItemDataModel(Integer invoiceId, Integer itemId, Integer quantity) {
		super();
		this.id = null;
		this.invoiceId = invoiceId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public BillingItemDataModel(Integer id, Integer invoiceId, Integer itemId, Integer quantity) {
		super();
		this.id = id;
		this.invoiceId = invoiceId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
