package actions.get;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import utils.AuthHelper;
import utils.database.Item;
import utils.database.baseclass.ItemDataModel;
import utils.invoice.pdf.html.*;

import com.itextpdf.html2pdf.HtmlConverter;


// css path : /ShoppingCartInvoice/WebContent/WEB-INF/static/css/invoice.css

public class InvoiceAction implements Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(!AuthHelper.isUserAuthenticated(req)) {
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			return;
		}
		

		Properties serverProperties = (Properties) req.getServletContext().getAttribute("serverConfig");
		String cssFilePath = req.getServletContext().getRealPath(serverProperties.getProperty("cssPath"));
		
		System.out.println(cssFilePath);
		
		ServletContext servletContext = req.getServletContext();
		
		
		Vector<ItemDataModel> cartItems = (Vector<ItemDataModel>)req.getSession().getAttribute("cart");
		
		if(cartItems==null) {
			res.sendRedirect(req.getContextPath()+"/shop1.jsp");
			return;
		}
		
		String invoiceHTML = InvoiceHTMLHelper.generateInvoiceHTML(cartItems,cssFilePath);
		String invoicePDFPath = "/WEB-INF/static/invoice_output/invoice.pdf";
		
		System.out.println(invoicePDFPath);
		invoicePDFPath = servletContext.getRealPath(invoicePDFPath);
		System.out.println(invoicePDFPath);
		
		HtmlConverter.convertToPdf(invoiceHTML, new FileOutputStream(invoicePDFPath));
		
		try
    	(FileInputStream invoicePDFFile = new FileInputStream(invoicePDFPath);){
		res.setContentType("application/pdf");
    	res.getOutputStream().write(invoicePDFFile.readAllBytes());
    	}
	}

}
