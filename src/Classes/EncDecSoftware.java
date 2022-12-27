package Classes;

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
import java.util.ArrayList;
import java.util.List;

public class EncDecSoftware {


    public EncDecSoftware() {
    }

    public String AbacToAbe(String pathfile) throws ParserConfigurationException, IOException, SAXException {
        String logicalExp;
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document= builder.parse(new File(pathfile));
        document.getDocumentElement().normalize();
        NodeList rule= document.getElementsByTagName("Rule");
        NodeList rulechilds=rule.item(0).getChildNodes();
        NodeList targetchilds=rulechilds.item(3).getChildNodes();
        NodeList AnyOfChild=targetchilds.item(1).getChildNodes();
        logicalExp=AnyOfHandler(AnyOfChild);
        return logicalExp;
    }

    public String AnyOfHandler(NodeList AnyOfChild) {
        String logicalExp;

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
                    NodeList insAnyOfChild=node.getChildNodes();
                    return logicalExp=AnyOfHandler(insAnyOfChild);
                }
            }
            logicalExp=String.join(" and ", Attributes);
            return logicalExp;
        }
        else
        {
            return  "Exoume mesa OR opote h fame den mporei na to diaxeiristei!!!";
        }
    }

}
