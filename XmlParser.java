
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.Scanner ;
import javax.xml.parsers.SAXParserFactory ;


public class XmlParser {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in) ;
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance() ;

        try {
            String pathname = input.next();
            if (!pathname.endsWith(".arxml")) {
                throw new NotValidAutosarFileException("Invalid file extension.");
            }

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse( new File(pathname)) ;

            document.getDocumentElement().normalize();

            NodeList containerList = document.getElementsByTagName("container");
            ArrayList var6 = new ArrayList();
            for(int var7 = 0; var7 < var5.getLength(); ++var7) {
                var6.add((Element)containerList.item(var7));
            }
            Collections.sort(var6, new ARXMLSort$1());
            Element var17 = var4.getDocumentElement();
            Iterator var8 = var6.iterator();
            while(var8.hasNext()) {
                Element var9 = (Element)var8.next();
                var17.appendChild(var9);
            }





        } catch (ParserConfigurationException e) {
             e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (SAXException e) {
            e.printStackTrace();
        }
        catch (NotValidAutosarFileException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EmptyAutosarFileException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
