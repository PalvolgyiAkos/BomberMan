package sample.View.Menu;

import javafx.scene.layout.Pane;
import sample.Model.TextModel;

public class GameName
{
    private Pane gamePane=new Pane();
    private TextModel gameNameModel=new TextModel();

    public GameName()
    {
        this.gamePane.setId("gameName");
        this.gamePane.setPrefSize(gameNameModel.getWidth(), gameNameModel.getHeight());
        this.gamePane.setLayoutX(gameNameModel.getPositionX());
        this.gamePane.setLayoutY(gameNameModel.getPositionY());
    }

    public Pane getGamePane()
    {
        return gamePane;
    }
}
