package sample.View.GamePage;

import javafx.scene.layout.Pane;
import sample.Model.TileModel;

public class Tile
{
    private Pane pane=new Pane();
    private TileModel tileModel;

    public Tile(double positionX, double positionY, String id)
    {
        this.tileModel=new TileModel(positionX, positionY);
        this.pane.getStyleClass().add("tile");
        this.pane.setId(id);
        this.pane.setPrefSize(tileModel.getWidth(), tileModel.getHeight());
        this.pane.setLayoutX(tileModel.getPositionX()+30);
        this.pane.setLayoutY(tileModel.getPositionY()+40);
    }

    public Pane getPane()
    {
        return pane;
    }
}
