package com.bharath.xmlparsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bharath.xmlparsers.dto.DriversLicense;

public class SaxHandler extends DefaultHandler {
	DriversLicense dl;
	String content;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		// so for only one time(for the first time) when the sax parser will trigger the
		// root element then the instance will be created.
		if (qName.equals("DriversLicense")) {
			dl = new DriversLicense();
		}
	}

	@Override
	public void endElement(String url, String localName, String qName) throws SAXException {
		switch(qName) {
			case "Number":
				dl.setNumber(Long.parseLong(content));
				break;
			case "LastName":
				dl.setLastName(content);
				break;
			case "FirstName":
				dl.setFirstName(content);
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// it will copy the content of the element and store it into content variable
		content = String.copyValueOf(ch, start, length);
	}

}
