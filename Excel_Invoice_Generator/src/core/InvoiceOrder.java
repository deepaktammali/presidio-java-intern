package core;

import core.InvoiceItem;
import java.util.*;

public class InvoiceOrder {
	private Vector<InvoiceItem> invoiceItems;

	public InvoiceOrder() {
		invoiceItems = new Vector<>();
	}

	public void addItem(InvoiceItem item) {
		invoiceItems.add(item);
	}

	public void removeItem(InvoiceItem item) {
		if (invoiceItems.contains(item)) {
			invoiceItems.remove(item);
		}
	}

	public void removeItemByName(String itemDescription) {
		for (InvoiceItem item : invoiceItems) {
			if (item.getDescription() == itemDescription) {
				invoiceItems.remove(item);
			}
		}
	}

	public void clearInvoiceItems() {
		if (invoiceItems.size() > 0) {
			invoiceItems.clear();
		}
	}

	public Vector<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
}
