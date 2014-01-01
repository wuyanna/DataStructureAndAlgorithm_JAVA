/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.10
 * Since XML is very verbose, you are given a way of encoding it where each
 * tag gets mapped to a pre-defined integer value. The language/grammar is as
 * follows:
 * 		Element		--> Tag Attributes END Children END
 * 		Attribute 	--> Tag Value
 * 		END			--> 0
 * 		Tag			--> some predefined mapping to int
 * 		Value		--> string value END
 * For example, the following XML might be converted into the compressed string
 * below (assuming a mapping of family -> 1, person -> 2, firstName -> 3,
 * lastName -> 4, state -> 5).
 * 		<family lastName="McDowell" state="CA">
 * 			<person firstName="Gayle">Some Message</person>
 * 		</family>
 * Becomes:
 * 		1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0.
 * Write code to print the encoded version of an XML element (passed in Element
 * and Attribute objects).
 * 
 * Solution - pg 445
 * 
 */
package com.question.moderate;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLEncoder {

	private static final String FAMILY_TAG = "family";
	private static final String PERSON_TAG = "person";
	private static final String FIRSTNAME_TAG = "firstName";
	private static final String LASTNAME_TAG = "lastName";
	private static final String STATE_TAG = "state";

	private static final Integer FAMILY_CODE = 1;
	private static final Integer PERSON_CODE = 2;
	private static final Integer FIRSTNAME_CODE = 3;
	private static final Integer LASTNAME_CODE = 4;
	private static final Integer STATE_CODE = 5;
	private static final Integer UNKNOWN_CODE = -1;

	public static Integer map(String name) {
		if (name.equals(FAMILY_TAG))
			return FAMILY_CODE;
		else if (name.equals(PERSON_TAG))
			return PERSON_CODE;
		else if (name.equals(FIRSTNAME_TAG))
			return FIRSTNAME_CODE;
		else if (name.equals(LASTNAME_TAG))
			return LASTNAME_CODE;
		else if (name.equals(STATE_TAG))
			return STATE_CODE;
		return UNKNOWN_CODE;
	}

	public static void encode(Element root) {
		print(map(root.getTagName()));
		NamedNodeMap attrs = root.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			print(map(attrs.item(i).getNodeName()));
			print(attrs.item(i).getNodeValue());
		}
		print("0");

		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getNodeValue() != null) {
				print(children.item(i).getNodeValue());
			} else {
				encode((Element) children.item(i));
			}
		}

		print("0");
	}

	public static void print(Object s) {
		System.out.print(s);
		System.out.print(" ");
	}

	public static void main(String[] args) {
		String xmlStr = "<family lastName=\"McDowell\" state=\"CA\">"
				+ "<person firstName=\"Gayle\">Some Message</person></family>";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(
					xmlStr)));
			encode(document.getDocumentElement());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
