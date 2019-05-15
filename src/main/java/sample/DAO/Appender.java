package sample.DAO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * This is a class which generates a new {@code ScoreData} and push it to the XML DB.
 */
public class Appender
{
    /**
     * This is the constructor of the {@code Appender} class.
     *
     * @param player1 is Player1's name ({@code String}).
     * @param player1_score is Player1's score ({@code int}).
     * @param player2 is Player2's name ({@code String}).
     * @param player2_score is Player2's score ({@code int}).
     * @param time is the game's played time ({@code String}).
     * @param result1 is the game's result ({@code String}).
     * @throws Exception that could be thrown bz the xml open.
     */
    public void appender(String player1, int player1_score, String player2, int player2_score, String time, String result1) throws Exception
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("src\\main\\resources\\sample\\DB\\Scores.xml");

        Element root = document.getDocumentElement();

        Element ujEredmeny = document.createElement("score");
        root.appendChild(ujEredmeny);

        Element ujNev = document.createElement("player1");
        ujNev.appendChild(document.createTextNode(player1));
        ujEredmeny.appendChild(ujNev);

        Element newPlayer1_Score = document.createElement("player1_score");
        newPlayer1_Score.appendChild(document.createTextNode(String.valueOf(player1_score)));
        ujEredmeny.appendChild(newPlayer1_Score);

        Element ujNev2 = document.createElement("player2");
        ujNev2.appendChild(document.createTextNode(player2));
        ujEredmeny.appendChild(ujNev2);

        Element newPlayer2_Score = document.createElement("player2_score");
        newPlayer2_Score.appendChild(document.createTextNode(String.valueOf(player2_score)));
        ujEredmeny.appendChild(newPlayer2_Score);

        Element ujPont = document.createElement("time");
        ujPont.appendChild(document.createTextNode(time));
        ujEredmeny.appendChild(ujPont);

        Element newResult = document.createElement("result");
        newResult.appendChild(document.createTextNode(result1));
        ujEredmeny.appendChild(newResult);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult("src\\main\\resources\\sample\\DB\\Scores.xml");

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }
}
