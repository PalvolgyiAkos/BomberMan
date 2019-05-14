package sample.View.ScoreBoard;

import javafx.scene.layout.Pane;
import sample.DAO.ScoreData;
import sample.DAO.XMLHandle;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ScoreBoard
{
    private Pane pane = new Pane();
    private Pane title = new Pane();
    private ArrayList<Element> player1 = new ArrayList<>();
    private ArrayList<Element> player1Score = new ArrayList<>();
    private ArrayList<Element> player2 = new ArrayList<>();
    private ArrayList<Element> player2Score = new ArrayList<>();
    private ArrayList<Element> time = new ArrayList<>();
    private ArrayList<Element> result = new ArrayList<>();

    Logger logger= Logger.getLogger("scoreboard");
    public ScoreBoard(int width, int height)
    {
        this.pane.setId("endPage");
        this.pane.setPrefSize(width, height);
        this.title.setId("scoreboardtitle");
        this.title.setPrefSize(width, 300);
        this.title.setLayoutY(-75);
        resetData();
        logger.info("ScoreBoard");
    }

    public void resetData()
    {
        this.pane.getChildren().forEach(item -> item.setVisible(false));
        this.pane.getChildren().clear();
        this.title.setVisible(true);
        this.pane.getChildren().add(this.title);
        XMLHandle xmlHandle = new XMLHandle();
        try
        {
            xmlHandle.read();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        ArrayList<ScoreData> scoreDataList = xmlHandle.getScoreDataList();
        player1.add(new Element("Player1", 0, 0));
        player1Score.add(new Element("P1 Score", 0, 1));
        player2.add(new Element("Player2", 0, 2));
        player2Score.add(new Element("P2 Score", 0, 3));
        time.add(new Element("Play Time", 0, 4));
        result.add(new Element("Result", 0, 5));

        for (int i = 0; i < scoreDataList.size(); i++)
        {
            if (i == 10)
            {
                break;
            }
            player1.add(new Element(scoreDataList.get(scoreDataList.size()-1-i).getPlayer1(), i+1, 0));
            player1Score.add(new Element(String.valueOf(scoreDataList.get(scoreDataList.size()-1-i).getPlayer1_score()), i+1, 1));
            player2.add(new Element(scoreDataList.get(scoreDataList.size()-1-i).getPlayer2(), i+1, 2));
            player2Score.add(new Element(String.valueOf(scoreDataList.get(scoreDataList.size()-1-i).getPlayer2_score()), i+1, 3));
            time.add(new Element(scoreDataList.get(scoreDataList.size()-1-i).getTime(), i+1, 4));
            result.add(new Element(scoreDataList.get(scoreDataList.size()-1-i).getResult(), i+1, 5));
        }

        player1.forEach(item -> this.pane.getChildren().add(item.getText()));
        player1Score.forEach(item -> this.pane.getChildren().add(item.getText()));
        player2.forEach(item -> this.pane.getChildren().add(item.getText()));
        player2Score.forEach(item -> this.pane.getChildren().add(item.getText()));
        time.forEach(item -> this.pane.getChildren().add(item.getText()));
        result.forEach(item -> this.pane.getChildren().add(item.getText()));
    }

    public Pane getPane()
    {
        return pane;
    }
}
