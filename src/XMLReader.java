import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class XMLReader {
    public static void main(String[] args){
        try {
            String line;

            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10&lon=9.58").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            StringBuilder xmlStringBuilder = new StringBuilder();
            xmlStringBuilder.append("<?xml version=1.0?> <class> </class>");
            ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));

            //Create document from input stream:
            Document doc = builder.parse(connection.getInputStream());

            Element root = doc.getDocumentElement();

            NodeList nList = doc.getElementsByTagName("time");

        }catch(ParserConfigurationException e){

        }catch (UnsupportedEncodingException e){

        }catch(IOException e){

        }catch(SAXException e){

        }

    }

}