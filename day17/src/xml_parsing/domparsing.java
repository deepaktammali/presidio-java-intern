package xml_parsing;

import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domparsing {
	public static void main(String[] args) {
		try(
				FileInputStream fileInputStream = new FileInputStream("class.txt");
				){
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document xmlDocument =  documentBuilder.parse(fileInputStream);
			
			xmlDocument.getDocumentElement().normalize();
			
			NodeList students = xmlDocument.getElementsByTagName("student");
			
			for(int index=0;index<students.getLength();index++) {
				Node student = students.item(index);
				
				if(student.getNodeType()==Node.ELEMENT_NODE) {
					Element studentElement = (Element)student; 
					System.out.println("Roll Number : "+ studentElement.getAttribute("rollno"));
					System.out.println("First Name : "+ studentElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : "+ studentElement.getElementsByTagName("lastname").item(0).getTextContent());
				}
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
