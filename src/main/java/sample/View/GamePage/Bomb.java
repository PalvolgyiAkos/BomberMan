package sample.View.GamePage;

import javafx.scene.layout.Pane;
import sample.Model.BombModel;

public class Bomb
{
    private Pane pane =new Pane();
    private BombModel bombModel;
    private Player player;

    public Bomb(double positionX, double positionY, String id, Player player)
    {
        this.bombModel=new BombModel(positionX, positionY, player.getPlayerModel().getBombPower());
        this.pane.setPrefSize(bombModel.getWidth(), bombModel.getHeight());
        this.pane.setLayoutX(bombModel.getPositionX());
        this.pane.setLayoutY(bombModel.getPositionY());
        this.pane.setId(id);
        this.player = player;
    }

    public Pane getPane()
    {
        return pane;
    }

    public BombModel getBombModel()
    {
        return bombModel;
    }

    public void setPane(Pane pane)
    {
        this.pane = pane;
    }

    public Player getPlayer() {
        return player;
    }
}
