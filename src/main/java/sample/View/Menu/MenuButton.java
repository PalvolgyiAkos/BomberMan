package sample.View.Menu;

import javafx.scene.layout.Pane;
import sample.Model.MenuButtonModel;

public class MenuButton
{
    private MenuButtonModel menuButtonModel =new MenuButtonModel();
    private Pane button=new Pane();

    public MenuButton(String id, int position)
    {
        this.button.getStyleClass().add("menuButton");
        this.button.setId(id);
        this.menuButtonModel.setPositionY(position);
        this.button.setPrefSize(menuButtonModel.getWidth(), menuButtonModel.getHeight());
        this.button.setLayoutX(menuButtonModel.getPositionX());
        this.button.setLayoutY(menuButtonModel.getPositionY());
    }

    public Pane getButton()
    {
        return button;
    }
}
