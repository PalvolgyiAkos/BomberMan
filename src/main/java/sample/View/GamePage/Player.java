package sample.View.GamePage;

import javafx.scene.layout.Pane;
import sample.Model.PlayerModel;

public class Player
{
    private Pane pane=new Pane();
    private PlayerModel playerModel;

    public Player(double positionX, double positionY, String id)
    {
        this.playerModel = new PlayerModel(positionX, positionY);
        this.pane.setId(id);
        refresh();
    }

    public void refresh()
    {
        this.pane.setPrefSize(playerModel.getWidth(), playerModel.getHeight());
        this.pane.setLayoutX(playerModel.getPositionX());
        this.pane.setLayoutY(playerModel.getPositionY());
    }

    public Pane getPane()
    {
        return pane;
    }

    public PlayerModel getPlayerModel()
    {
        return playerModel;
    }
}
