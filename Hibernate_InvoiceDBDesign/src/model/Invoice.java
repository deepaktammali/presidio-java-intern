package model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	@OneToOne
	Invoice invoice;
	@OneToOne
	Customer customer;
	@Column
	LocalDateTime invoiceDate;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(Integer id, Invoice invoice, Customer customer, LocalDateTime invoiceDate) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.customer = customer;
		this.invoiceDate = invoiceDate;
	}
	public Invoice(Invoice invoice, Customer customer, LocalDateTime invoiceDate) {
		super();
		this.invoice = invoice;
		this.customer = customer;
		this.invoiceDate = invoiceDate;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}
