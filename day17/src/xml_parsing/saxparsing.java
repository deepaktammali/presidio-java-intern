package xml_parsing;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;


public class saxparsing {
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser xmlParser = saxParserFactory.newSAXParser();
			
			
			
			
			xmlParser.parse("class.txt", new XMLHandler());
			
			
			
			
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class XMLHandler extends DefaultHandler{
	
	private boolean fname;
	private boolean lname;
	private boolean nickname;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Started parsing xml");
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName) {
			
		case "firstname":{
			fname=true;
			break;
		}
		
		case "lastname":{
			lname=true;
			break;
		}
		
		case "nickname":{
			nickname=true;
			break;
		}
		
		}
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(fname) {
			System.out.println("FirstName : "+new String(ch,start,length));
			fname=false;
		}
		
		if(lname) {
			System.out.println("LastName : "+new String(ch,start,length));
			lname=false;
		}
		
		if(nickname) {
			System.out.println("NickName : "+new String(ch,start,length));
			nickname=false;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Ended Parsing");
	}
}


