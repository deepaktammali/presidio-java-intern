package utils.invoice.pdf.html;

import java.util.Vector;
import utils.database.baseclass.ItemDataModel;
import utils.invoice.pdf.models.Address;

public class InvoiceHTMLHelper {
	
	private static String generateInvoiceHeading(String heading) {
		String invoiceHeadingTable = String.format("<table class=\"invoice_heading\">\r\n"
				+ "      <tr>\r\n"
				+ "        <td class=\"invoice_heading___title\">%s</td>\r\n"
				+ "      </tr>\r\n"
				+ "    </table>", heading);
		return invoiceHeadingTable;
	}
	
	private static String generateInvoiceDateAndIdHTML(String invoiceDate,String invoiceID) {
		String invoiceDateIdHTML = "<td width=\"50%\">\r\n";
				
		invoiceDateIdHTML += String.format("<section class=\"invoice_date_id\">\r\n"
				+ "            <p class=\"invoice_date\" >%s</p>\r\n"
				+ "            <p class=\"invoice_id\">%s</p>\r\n"
				+ "          </section>\r\n"
				+ "        </td>",invoiceDate,invoiceID);
		return invoiceDateIdHTML;
	}
	
	private static String generateClientAddressHTML(Address clientAddress) {
		return generateAddressHTML(clientAddress, "CLIENT", "client_address");
	}
	
	private static String generateClientAddressAndInvoiceDateIDHTML(Address clientAddress,String invoiceDate,String invoiceID) {
		String addressInvoiceMetadataHTML = "<table class=\"client_address_invoice_metadata_table\">\r\n"
				+ "      <tr>";
		addressInvoiceMetadataHTML += generateClientAddressHTML(clientAddress);
		addressInvoiceMetadataHTML += generateInvoiceDateAndIdHTML(invoiceDate, invoiceID);
		addressInvoiceMetadataHTML += "</tr>\r\n"
				+ "    </table>";
		
		return addressInvoiceMetadataHTML;
	}
	
	private static String generateAddressHTML(Address address,String heading,String htmlClass) {

		System.out.println(heading+htmlClass);
		String addressHTMLString = "<td width=\"50%\">\r\n"
				+ String.format("<section class=\"%s\">\r\n"
				+ "            <p class=\"address_title\">%s</p>\r\n"
				+ "            <p>%s</p>\r\n"
				+ "            <p>%s</p>\r\n"
				+ "            <p>%s</p>\r\n"
				+ "            <p>%s</p>\r\n"
				+ "            <p>%s</p>\r\n"
				+ "          </section>\r\n"
				+ "        </td>", htmlClass,heading,address.getContactName(),address.getCompanyName(),address.getCompanyAddress(),address.getPhoneNumber(),address.getEmailAddress());
		return addressHTMLString;
	}
	
	private static String generateShippingBillingAddressHTML(Address shippingAddress,Address billingAddress) {
		String billingShippingAddressString = "<table class=\"bill_ship_address_table\">\r\n"
				+ "      <tr>";
		
		billingShippingAddressString += generateAddressHTML(billingAddress,"BILL TO","bill_to_address");
		billingShippingAddressString += generateAddressHTML(billingAddress,"SHIP TO","ship_to_address");
		billingShippingAddressString += "</tr>\r\n"
				+ "    </table>";
		return billingShippingAddressString;
	}
	
	
	private static String generateInvoiceGoodsTableHTML(Vector<ItemDataModel> cartItems) {

		String goodsHTMLString = "<table class=\"invoice_goods_table\">\r\n" + "      <!-- invoice items header -->\r\n"
				+ "      <tr>\r\n" + "        <th width=\"50%\" class=\"invoiceitems_header\">Description</th>\r\n"
				+ "        <th width=\"10%\" class=\"invoiceitems_header\">Quantity</th>\r\n"
				+ "        <th width=\"20%\" class=\"invoiceitems_header\">Unit Price</th>\r\n"
				+ "        <th width=\"20%\" class=\"invoiceitems_header\">Total</th>\r\n" + "</tr>";

		for (ItemDataModel cartItem : cartItems) {
			int quantity = 1;
			goodsHTMLString +=
					"<tr>\r\n" + "     <td width=\"50%\" class=\"invoiceitems_value\">"+cartItem.getName() + " " + cartItem.getDescription()+"</td>\r\n"
							+ "        <td width=\"10%\" class=\"invoiceitems_value\">"+quantity+"</td>\r\n"
							+ "        <td width=\"20%\" class=\"invoiceitems_value\">"+cartItem.getPrice()+"</td>\r\n"
							+ "        <td width=\"20%\" class=\"invoiceitems_value\">"+cartItem.getPrice() * quantity+"</td>\r\n" + "</tr>";
		}
		
		goodsHTMLString += "</table>";

		return goodsHTMLString;
	}
	
	
//	table row : tax rate,discount
	private static String generateAddlInvoiceDataRow(String heading,double value) {
		
		String addlDataRow = ("<tr>\r\n"
				+ "        <td width=\"80%\" class=\"invoiceitems_addl_header\">"+heading+"</td>\r\n"
				+ "        <td width=\"20%\" class=\"invoiceitems_value\">"+value+"</td>\r\n"
				+ "      </tr>");
		
		return addlDataRow;

	}
	
	
	private static String generateAddlInvoiceDataTableHTML(double subTotal,double discountPercent,double taxPercent,double shippingAndHandling) {
		
		double subTotalLessDiscount = subTotal - (discountPercent*subTotal)/100;
		double totalTax = subTotalLessDiscount*taxPercent/100;
		
		double balanceDue = subTotalLessDiscount + totalTax + shippingAndHandling;
		
		String addlInvoiceDataString = "<table class=\"invoice_addl_table\">";
		addlInvoiceDataString += generateAddlInvoiceDataRow("SUB TOTAL",subTotal);
		addlInvoiceDataString += generateAddlInvoiceDataRow("DISCOUNT",discountPercent);
		addlInvoiceDataString += generateAddlInvoiceDataRow("SUB TOTAL LESS DISCOUNT",subTotalLessDiscount);
		addlInvoiceDataString += generateAddlInvoiceDataRow("TAX RATE",taxPercent);
		addlInvoiceDataString += generateAddlInvoiceDataRow("TOTAL TAX",totalTax);
		addlInvoiceDataString += generateAddlInvoiceDataRow("SHIPPING/HANDLING",shippingAndHandling );
		addlInvoiceDataString += generateAddlInvoiceDataRow("BALANCE DUE", balanceDue);
		addlInvoiceDataString += "</table>";

		return addlInvoiceDataString;
	}
	
	
//	TODO:need to change later
	public static String generateInvoiceHTML(Vector<ItemDataModel> cartItems,String cssPath) {
		;
		String invoiceHeadingHTML = String.format("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"%s\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "  </head>\r\n"
				+ "  <body>", cssPath);
		
		
		Address addressPlaceholder = new Address("DEKU","MY ACADEMIA","U.A High school","1203120512","deku@myacademia.school");
		
		String invoiceHeading = generateInvoiceHeading("INVOICE");
		String clientAddressInvoiceMetadata = generateClientAddressAndInvoiceDateIDHTML(addressPlaceholder, "20 May 2011", "14135325213");
		String shippingAndBillingAddress = generateShippingBillingAddressHTML(addressPlaceholder, addressPlaceholder);
		;String invoiceGoods = generateInvoiceGoodsTableHTML(cartItems);
		String invoiceAddlData = generateAddlInvoiceDataTableHTML(123,10, 5, 50);
		
		String invoiceBodyHTML = invoiceHeading
										+ clientAddressInvoiceMetadata
										+ shippingAndBillingAddress
										+ invoiceGoods
										+ invoiceAddlData;
		
		String invoiceFooterHTML = "</body>\r\n"
				+ "</html>";
		
		return (invoiceHeadingHTML + invoiceBodyHTML + invoiceFooterHTML);
	}
	
}