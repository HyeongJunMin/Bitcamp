package std190718_jQueryUI_JSON_XML.main;

import java.io.File;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JSONMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document xml = null;
		File file = new File("D:\\test\\datas.xml");
		InputSource is = new InputSource(new FileReader(file));
		
		xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
		
		//Root Element 취득 방법
		Element element = xml.getDocumentElement();
		
		System.out.println("test: " + element.getTagName());
		
		//child nodes 취득
		NodeList lst = element.getChildNodes();
		//child node 취득
		if( lst.getLength() > 0 ) {
			for (int i = 0; i < lst.getLength(); i++) {
				NodeList childList = lst.item(i).getChildNodes();
				if(childList.getLength() > 0) {
					for(int j = 0 ; j < childList.getLength() ; j++) {
						if( childList.item(j).getNodeName().equals("#text") == false )
						System.out.println("xml tag name : " + childList.item(j).getNodeName() 
								+", xml value : " + childList.item(j).getTextContent()
								);
					}
				}
			}
		}
			
	}

}
