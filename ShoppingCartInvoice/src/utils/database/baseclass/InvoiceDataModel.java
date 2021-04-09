package utils.database.baseclass;

public class InvoiceDataModel {
	private Integer invoiceId;
	private Integer customerId;
	private String invoiceDate;

	public InvoiceDataModel(Integer invoiceId, Integer customerId, String invoiceDate) {
		super();
		this.invoiceId = invoiceId;
		this.customerId = customerId;
		this.invoiceDate = invoiceDate;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
