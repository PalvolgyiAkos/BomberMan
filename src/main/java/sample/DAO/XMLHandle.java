package sample.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the class which reads and creates the xml file.
 */
public class XMLHandle
{
    /**
     * This is a list which will contain the database's rows.
     */
    private ArrayList<ScoreData> scoreDataList = new ArrayList<>();

    /**
     * This is a method which reads the xml and fills up the scoreDataList.
     *
     * @throws ParserConfigurationException could be thrown.
     * @throws SAXException could be thrown.
     * @throws IOException could be thrown.
     */
    public void read() throws ParserConfigurationException, SAXException, IOException
    {
        File input = new File("src\\main\\resources\\sample\\DB\\Scores.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(input);
        ObservableList<ScoreData> scores = FXCollections.observableArrayList();
        NodeList nodeList = document.getElementsByTagName("score");

        for (int i = 0; i < nodeList.getLength(); i++)
        {
            ScoreData score = new ScoreData();
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                score.setPlayer1(element
                        .getElementsByTagName("player1")
                        .item(0)
                        .getTextContent());
                score.setPlayer1_score(Integer.valueOf(element
                        .getElementsByTagName("player1_score")
                        .item(0)
                        .getTextContent()));
                score.setPlayer2(element
                        .getElementsByTagName("player2")
                        .item(0)
                        .getTextContent());
                score.setPlayer2_score(Integer.valueOf(element
                        .getElementsByTagName("player2_score")
                        .item(0)
                        .getTextContent()));
                score.setTime(element
                        .getElementsByTagName("time")
                        .item(0)
                        .getTextContent());
                score.setResult(element
                        .getElementsByTagName("result")
                        .item(0)
                        .getTextContent());
            }
            scores.add(score);
            scoreDataList.add(score);
        }
    }

    /**
     * This is a method which creates or opens to append the xml.
     *
     * @param player1 is Player1's name ({@code String}).
     * @param player1_score is Player1's score ({@code int}).
     * @param player2 is Player2's name ({@code String}).
     * @param player2_score is Player2's score ({@code int}).
     * @param time is the game's played time.
     * @param result1 is the game's result.
     */
    public void create(String player1, int player1_score, String player2, int player2_score, String time, String result1)
    {
        File input = new File("src\\main\\resources\\sample\\DB\\Scores.xml");
        if (input.exists() && !input.isDirectory())
        {
            try
            {
                Appender appender = new Appender();
                appender.appender(player1, player1_score, player2, player2_score, time, result1);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } else
        {
            try
            {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.newDocument();

                Element root = document.createElement("scores");
                document.appendChild(root);

                Element score = document.createElement("score");
                root.appendChild(score);

                Element nameIn = document.createElement("player1");
                nameIn.appendChild(document.createTextNode(player1));
                score.appendChild(nameIn);

                Element player1_scoreIn = document.createElement("player1_score");
                player1_scoreIn.appendChild(document.createTextNode(String.valueOf(player1_score)));
                score.appendChild(player1_scoreIn);

                Element nameIn2 = document.createElement("player2");
                nameIn2.appendChild(document.createTextNode(player2));
                score.appendChild(nameIn2);

                Element player2_scoreIn = document.createElement("player2_score");
                player2_scoreIn.appendChild(document.createTextNode(String.valueOf(player2_score)));
                score.appendChild(player2_scoreIn);

                Element point = document.createElement("time");
                point.appendChild(document.createTextNode(time));
                score.appendChild(point);

                Element resultIn = document.createElement("result");
                resultIn.appendChild(document.createTextNode(result1));
                score.appendChild(resultIn);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("src\\main\\resources\\sample\\DB\\Scores.xml"));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                transformer.transform(source, result);

            } catch (ParserConfigurationException | TransformerException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * This is a getter function.
     *
     * @return the xml's rows in a list.
     */
    public ArrayList<ScoreData> getScoreDataList() {
        return scoreDataList;
    }
}

