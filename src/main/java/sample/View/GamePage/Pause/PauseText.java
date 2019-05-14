package sample.View.GamePage.Pause;

import javafx.scene.layout.Pane;
import sample.Model.TextModel;

public class PauseText
{
    private Pane pauseTextPane =new Pane();
    private TextModel textModel =new TextModel();

    public PauseText()
    {
        this.pauseTextPane.setId("pausetext");
        this.textModel.setWidth(300);
        this.textModel.setHeight(100);
        this.pauseTextPane.setPrefSize(textModel.getWidth(), textModel.getHeight());
        this.textModel.setPositionX(200);
        this.textModel.setPositionY(158);
        this.pauseTextPane.setLayoutX(textModel.getPositionX());
        this.pauseTextPane.setLayoutY(textModel.getPositionY());
    }

    public Pane getPauseTextPane()
    {
        return pauseTextPane;
    }
}
