package testCase1Page;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlHandler {

    private final static String fileName = "ConfigData.xml";

    public String getValueFromXml(String tagName) {
        File file = new File(fileName);
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            return doc.getElementsByTagName(tagName).item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Элемент не найден";
    }
}
