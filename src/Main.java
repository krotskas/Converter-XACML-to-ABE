import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String logicalExp;
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();

        Document document= builder.parse(new File("policy.xml"));
        document.getDocumentElement().normalize();
        Element root=document.getDocumentElement();
        NodeList rule= document.getElementsByTagName("Rule");
        NodeList rulechilds=rule.item(0).getChildNodes();
        NodeList targetchilds=rulechilds.item(3).getChildNodes();

        NodeList AnyOfChild=targetchilds.item(1).getChildNodes();

        if ((AnyOfChild.getLength()-1)/2 == 1)
        {
            List<String> Attributes=new ArrayList<>();
            NodeList AllOfChild=AnyOfChild.item(1).getChildNodes();
            for (int item=1; item < AllOfChild.getLength(); item=item+2)
            {
                Node node = AllOfChild.item(item);

                if (node.getNodeName()!="AnyOf")
                {
                    if (node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element=(Element) node;

                        String firstname = element.getElementsByTagName("AttributeValue").item(0).getTextContent();
                        Attributes.add(firstname);

                    }
                }
                else
                {
                    System.out.println("Emfolevmeni AnyOF");
                }
            }
            logicalExp=String.join(" and ", Attributes);
            System.out.println(logicalExp);
        }
        else
        {
            System.out.println("Exoume Mesa OR epomenws h FAME den mporei na thn diaxeiristei");
        }



    }


}