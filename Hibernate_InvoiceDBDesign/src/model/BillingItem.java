package model;

import javax.persistence.*;

@Entity
@Table(name = "BillingItem")
public class BillingItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToOne
	Invoice invoice;
	@OneToOne
	Item item;
	@Column
	Integer quantity;

	public BillingItem() {

	}

	public BillingItem(Invoice invoice, Item item, Integer quantity) {
		super();
		this.invoice = invoice;
		this.item = item;
		this.quantity = quantity;
	}

	public BillingItem(Integer id, Invoice invoice, Item item, Integer quantity) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.item = item;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
