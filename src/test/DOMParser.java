package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

	// Load and parse XML file into DOM
	public Document parse(String filePath) {
		Document document = null;
		try {
			// DOM parser instance
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			// parse an XML file into a DOM tree
			document = builder.parse(new File(filePath));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public List<String> getChild(NodeList list){
		return getChild(list, null);
	}
	private List<String> getChild(NodeList list, List<String> names){
		if(names == null){
			names = new ArrayList<String>();
		}
		if (list != null) {
			for (int i = 0; i < list.getLength(); i++) {
				Node element = (Node) list.item(i);
				if("3".equals(element.getNodeType()+"")){
					continue;
				}
				names.add(element.getNodeName());
				getChild(element.getChildNodes(), names);
			}
		}
		return names;
	}
	
	public static void main(String[] args) {
		DOMParser parser = new DOMParser();
		Document d1 = parser.parse("C:/upload/_费用单.xml");
		Document d2 = parser.parse("C:/upload/费用.xml");
		Element root1 = d1.getDocumentElement();
		Element root2 = d2.getDocumentElement();

		// traverse child elements
/*		NodeList nodes = root1.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) node;
				// process child element
			}
		}*/

		List<String> n1 = parser.getChild(root1.getChildNodes());
		List<String> n2 = parser.getChild(root2.getChildNodes());
		
		int i=0;
		for(String n : n1){
			if(n2.contains(n)){
				i++;
//				System.out.println(n);
			}else{
				System.out.println(n);
			}
		}
		System.out.println("success:" + i);
	}
}
