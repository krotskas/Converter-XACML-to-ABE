package Items;
import fame.FAME;
import fame.FAMECipherText;
import fame.FAMESecretKey;
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


    private FAME cpabe;

    public EncDecSoftware(FAME cpabe) {
        this.cpabe=cpabe;
    }

    public String AbacToAbe(String pathfile) throws ParserConfigurationException, IOException, SAXException {
        String logicalExp;
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document= builder.parse(new File(pathfile));
        document.getDocumentElement().normalize();
        NodeList rule= document.getElementsByTagName("Rule");
        Node nNode=rule.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE)
        {
            Element eElement = (Element) nNode;
            String effect= eElement.getAttribute("Effect");
            NodeList rulechilds=rule.item(0).getChildNodes();
            NodeList targetchilds=rulechilds.item(3).getChildNodes();
            NodeList AnyOfChild=targetchilds.item(1).getChildNodes();
            if (effect.equals("Permit"))
            {
                logicalExp=AnyOfHandler(AnyOfChild);
                return logicalExp;
            }
            else
            {
                logicalExp=AnyOfHandler(AnyOfChild);
                return "!"+logicalExp;
            }
        }
        else {
            return "Something was Wrong!!!!!";
        }



    }

    public String AnyOfHandler(NodeList AnyOfChild) {
        String logicalExp="";

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
                        String attrs = element.getElementsByTagName("AttributeValue").item(0).getTextContent();
                        Attributes.add(attrs);
                    }
                }
                else
                {
                    NodeList insAnyOfChild=node.getChildNodes();
                    return logicalExp=logicalExp+AnyOfHandler(insAnyOfChild);
                }
            }
            logicalExp=logicalExp+String.join(" and ", Attributes);
            return logicalExp;
        }
        else
        {
            return  "Exoume mesa OR opote h fame den mporei na to diaxeiristei!!!";
        }
    }

    public FAMECipherText Encrypt(String logExp, String message) throws Exception {
        FAMECipherText cpt = cpabe.encrypt(logExp, message.getBytes());
        System.out.println("~~~~ Encryption Complete ~~~~");
        return cpt;

    }

    public String Decrypt(FAMESecretKey sk, FAMECipherText cpt) throws Exception {
        byte[] decrypted = cpabe.decrypt(sk, cpt);
        String dec_message = new String(decrypted);
        return dec_message;
    }

}
