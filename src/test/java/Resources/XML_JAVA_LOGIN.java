package Resources;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
public class XML_JAVA_LOGIN {
    private static String Login_Usr;
    private static String Login_Pwd;
    private static String Status;
    public static String[][] XML_JAVA_LOGIN() throws IOException, SAXException, ParserConfigurationException {
        File xmlFile = new File("/home/tal-meow/IdeaProjects/campusProject/src/test/java/Resources/LogIn_Data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        NodeList LoginCasesNodes = doc.getElementsByTagName("login");
        String[][] data = new String[LoginCasesNodes.getLength()][3];
        for (int i = 0; i < LoginCasesNodes.getLength(); i++) {
            Element LoginElement = (Element) LoginCasesNodes.item(i);
            String username = LoginElement.getElementsByTagName("usr").item(0).getTextContent();
            String password = LoginElement.getElementsByTagName("pwd").item(0).getTextContent();
            String status = LoginElement.getElementsByTagName("status").item(0).getTextContent();
            data[i] = new String[]{username, password ,status};
        }
        return data;
    }
}
