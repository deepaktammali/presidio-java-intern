package core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


public class PDFInvoiceGenerator{
	public static void generatePDF() throws FileNotFoundException, IOException, DocumentException {

	    	try(
	    			FileInputStream htmlFile = new FileInputStream("invoice.html");
	    			FileInputStream cssFile = new FileInputStream("invoice.css");
	    			){

	        	ByteArrayInputStream html = new ByteArrayInputStream(htmlFile.readAllBytes());
	            ByteArrayInputStream css = new ByteArrayInputStream(cssFile.readAllBytes());
	            Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
	            document.open();
	            XMLWorkerHelper.getInstance().parseXHtml(writer, document, html, css);
	            document.close();
	    	}
	        System.out.println( "PDF Created!" );
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {
		generatePDF();
	}
}