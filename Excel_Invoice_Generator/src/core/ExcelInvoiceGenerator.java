package core;

import core.InvoiceOrder;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map.*;
import javax.swing.text.DateFormatter;
import java.util.*;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInvoiceGenerator {

	public static void setCellValue(XSSFSheet sheet, int currRowIndex, int currColumnIndex, Object cellValue,
			int columnWidth) {
		Row currRow;
		Cell currCell;

		if ((currRow = sheet.getRow(currRowIndex)) == null) {
			currRow = sheet.createRow(currRowIndex);
		}

		sheet.addMergedRegion(
				new CellRangeAddress(currRowIndex, currRowIndex, currColumnIndex, currColumnIndex + columnWidth - 1));
		currCell = currRow.createCell(currColumnIndex);

		if (cellValue instanceof Integer) {
			currCell.setCellValue((Integer) cellValue);
		}

		if (cellValue instanceof Double) {
			currCell.setCellValue((Double) cellValue);
		}

		if (cellValue instanceof Float) {
			currCell.setCellValue((Float) cellValue);
		}

		if (cellValue instanceof String) {
			currCell.setCellValue((String) cellValue);
		}
	}

//	TODO replace the code in generateInvoice with function call
	public static Integer writeInvoiceItemToSheet(XSSFSheet sheet, int currRowIndex, int currColumnIndex,
			InvoiceItem currInvoiceItem, int invoiceDescriptionWidth, int invoiceQuantityWidth,
			int invoiceUnitPriceWidth, int invoiceTotalPriceWidth) {

		currRowIndex += 1;
		currColumnIndex = 0;
		double totalPrice = currInvoiceItem.getQuantity() * currInvoiceItem.getUnitCost();
		setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getDescription(), invoiceDescriptionWidth);
		currColumnIndex += invoiceDescriptionWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getQuantity(), invoiceQuantityWidth);
		currColumnIndex += invoiceQuantityWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getUnitCost(), invoiceUnitPriceWidth);
		currColumnIndex += invoiceUnitPriceWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, totalPrice, invoiceTotalPriceWidth);

		return currRowIndex;
	}

	public static Integer writeAddressToSheet(XSSFSheet sheet, int currRowIndex, int currColumnIndex, Address address,
			String addressType, int columnWidth) {

		Row currRow;
		Cell currCell;
		Map<String, Object> addressMap;

		addressMap = address.toMap();

		if (addressType.equals("billing")) {
			setCellValue(sheet, currRowIndex, currColumnIndex, "Bill To", columnWidth);
			currRowIndex += 1;
		}

		if (addressType.equals("shipping")) {
			setCellValue(sheet, currRowIndex, currColumnIndex, "Ship To", columnWidth);
			currRowIndex += 1;
		}

		// company name
		String companyName = (String) addressMap.getOrDefault("companyName", "");
		setCellValue(sheet, currRowIndex, currColumnIndex, companyName, columnWidth);

		// street address
		currRowIndex += 1;
		String streetAddress = (String) addressMap.getOrDefault("streetAddress", "");
		if (streetAddress == "") {
			currRowIndex -= 1;
		} else {
			setCellValue(sheet, currRowIndex, currColumnIndex, streetAddress, columnWidth);
		}

		// City,State, Country
		currRowIndex += 1;
		String addressString = (String) addressMap.getOrDefault("city", "")
				+ (String) addressMap.getOrDefault("state", "") + (String) addressMap.getOrDefault("country", "");
		setCellValue(sheet, currRowIndex, currColumnIndex, addressString, columnWidth);

		// Zipcode
		currRowIndex += 1;
		Integer zipCode = (Integer) addressMap.getOrDefault("zipCode", "");
		setCellValue(sheet, currRowIndex, currColumnIndex, zipCode, columnWidth);

		// Phone Number
		currRowIndex += 1;
		String phoneNumber = (String) addressMap.getOrDefault("phoneNumber", "");
		setCellValue(sheet, currRowIndex, currColumnIndex, phoneNumber, columnWidth);

		// Email Address
		currRowIndex += 1;
		String emailAddress = (String) addressMap.getOrDefault("emailAddress", "");
		setCellValue(sheet, currRowIndex, currColumnIndex, emailAddress, columnWidth);

		return currRowIndex;

	}

	/**
	 * 
	 * @param title Title of the invoice being generated
	 * @throws IOException
	 * 
	 */

	public static void generateInvoice(String title, LocalDate invoiceDate, String invoiceNumber, Address clientAddress,
			Address billingAddress, Address shippingAddress, InvoiceOrder invoiceOrder, double discount, double taxRate,
			double shippingAndHandlingCosts) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Invoice");

		int currRowIndex = 0;
		int currColumnIndex = 0;
		Row currRow;
		Cell currCell;

//		title
		currRow = sheet.createRow(currRowIndex);

		// merge fist four cell for the title
		sheet.addMergedRegion(new CellRangeAddress(currRowIndex, currRowIndex, currColumnIndex, currColumnIndex + 5));

		currCell = currRow.createCell(currColumnIndex);
		currCell.setCellValue(title);

//		client address
		currRowIndex += 3;
		currColumnIndex = 0;
		int clientAddressWidth = 6;
		int clientAddressRowIndexEnd = writeAddressToSheet(sheet, currRowIndex, currColumnIndex, clientAddress,
				"client", clientAddressWidth);

//		date and invoice number

		// date
		currColumnIndex = clientAddressWidth;
		int invoiceDateWidth = 6;
		String invoiceDateFormatted = invoiceDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setCellValue(sheet, currRowIndex, currColumnIndex, "Date", invoiceDateWidth);
		setCellValue(sheet, currRowIndex + 1, currColumnIndex, invoiceDateFormatted, invoiceDateWidth);

		// invoice number
		currColumnIndex = clientAddressWidth;
		int invoiceNumberWidth = 6;
		setCellValue(sheet, currRowIndex + 3, currColumnIndex, "Invoice Number", invoiceNumberWidth);
		setCellValue(sheet, currRowIndex + 4, currColumnIndex, invoiceNumber, invoiceNumberWidth);

//		billing address
		currRowIndex = clientAddressRowIndexEnd + 2;
		currColumnIndex = 0;
		int billingAddressWidth = 6;
		int billingAddressRowIndexEnd = writeAddressToSheet(sheet, currRowIndex, currColumnIndex, billingAddress,
				"billing", billingAddressWidth);

//		shipping address
		currColumnIndex = billingAddressWidth;
		int shippingAddressRowIndexEnd = writeAddressToSheet(sheet, currRowIndex, currColumnIndex, shippingAddress,
				"shipping", 5);

		currRowIndex = Math.max(billingAddressRowIndexEnd, shippingAddressRowIndexEnd);

//		invoice items

		double subTotal = 0;

		currRowIndex += 1;
		Iterator<InvoiceItem> invoiceOrderIterator = invoiceOrder.getInvoiceItems().iterator();
		InvoiceItem currInvoiceItem;
		int invoiceDescriptionWidth = 6;
		int invoiceQuantityWidth = 2;
		int invoiceUnitPriceWidth = 2;
		int invoiceTotalPriceWidth = 2;

		currRowIndex += 1;
		currColumnIndex = 0;
		currInvoiceItem = invoiceOrderIterator.next();
		setCellValue(sheet, currRowIndex, currColumnIndex, "Description", invoiceDescriptionWidth);
		currColumnIndex += invoiceDescriptionWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, "Quantity", invoiceQuantityWidth);
		currColumnIndex += invoiceQuantityWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, "Unit Cost", invoiceUnitPriceWidth);
		currColumnIndex += invoiceUnitPriceWidth;
		setCellValue(sheet, currRowIndex, currColumnIndex, "Total Price", invoiceTotalPriceWidth);

		while (invoiceOrderIterator.hasNext()) {

			// TODO
//			currRowIndex = writeInvoiceItemToSheet(sheet, currRowIndex, currColumnIndex, invoiceOrderIterator.next(),
//					invoiceDescriptionWidth, invoiceQuantityWidth, invoiceUnitPriceWidth, invoiceTotalPriceWidth);

			currInvoiceItem = invoiceOrderIterator.next();
			currRowIndex += 1;
			currColumnIndex = 0;

			double totalPrice = currInvoiceItem.getQuantity() * currInvoiceItem.getUnitCost();
			subTotal += totalPrice;

			setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getDescription(),
					invoiceDescriptionWidth);
			currColumnIndex += invoiceDescriptionWidth;
			setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getQuantity(), invoiceQuantityWidth);
			currColumnIndex += invoiceQuantityWidth;
			setCellValue(sheet, currRowIndex, currColumnIndex, currInvoiceItem.getUnitCost(), invoiceUnitPriceWidth);
			currColumnIndex += invoiceUnitPriceWidth;
			setCellValue(sheet, currRowIndex, currColumnIndex, totalPrice, invoiceTotalPriceWidth);

		}

//		cost breakup details

		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;
		int costBreakUpHeadingWidth = 4;
		int costBreakUpValueWidth = 2;
		double subTotalWithDiscount = subTotal - (subTotal * discount) / 100;
		double totalTax = subTotalWithDiscount * taxRate / 100;
		double balanceDue = subTotalWithDiscount + totalTax + shippingAndHandlingCosts;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Sub Total", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth, "Sub Total", costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Discount", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,discount, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Sub Total With Discount", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,subTotalWithDiscount, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Tax Rate", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,taxRate, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Total Tax", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,totalTax, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Shipping/Handling", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,shippingAndHandlingCosts, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		setCellValue(sheet, currRowIndex, currColumnIndex, "Balance Due", costBreakUpHeadingWidth);
		setCellValue(sheet, currRowIndex, currColumnIndex+costBreakUpHeadingWidth,balanceDue, costBreakUpValueWidth);
		currRowIndex += 1;
		currColumnIndex = invoiceDescriptionWidth;

		FileOutputStream fileOutputStream = new FileOutputStream("invoice.xlsx");

		workbook.write(fileOutputStream);
		fileOutputStream.close();
		System.out.println("Written");

	}

	public static void main(String[] args) {
		try {
			Address clientAddress = new Address("CompanyName", "Contact Name", "Street Address", "City", "State",
					"Country", 565125, "+919761947635", "johndoe@gmail.com");
			Address billingAddress = clientAddress;
			Address shippingAddress = clientAddress;

			InvoiceOrder invoiceOrder = new InvoiceOrder();

			invoiceOrder.addItem(new InvoiceItem("Item 1", 20.20, 2));
			invoiceOrder.addItem(new InvoiceItem("Item 2", 20.20, 2));
			invoiceOrder.addItem(new InvoiceItem("Item 3", 20.20, 2));
			invoiceOrder.addItem(new InvoiceItem("Item 4", 20.20, 2));
			invoiceOrder.addItem(new InvoiceItem("Item 5", 20.20, 2));

			double discount = 5;
			double taxRate = 30;
			double shippindAndHandlingCost = 5000;

			generateInvoice("Invoice", LocalDate.now(), "2646468989", clientAddress, billingAddress, shippingAddress,
					invoiceOrder, discount, taxRate, shippindAndHandlingCost);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
