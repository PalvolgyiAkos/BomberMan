package sample.View.GamePage.Pause;

import javafx.scene.layout.Pane;
import sample.Model.TextModel;

public class PressPText
{
    private Pane pauseTextPane =new Pane();
    private TextModel textModel =new TextModel();

    public PressPText()
    {
        this.pauseTextPane.setId("pressPText");
        this.textModel.setWidth(490);
        this.textModel.setHeight(95);
        this.pauseTextPane.setPrefSize(textModel.getWidth(), textModel.getHeight());
        this.textModel.setPositionX(110);
        this.textModel.setPositionY(390);
        this.pauseTextPane.setLayoutX(textModel.getPositionX());
        this.pauseTextPane.setLayoutY(textModel.getPositionY());
    }

    public Pane getPauseTextPane()
    {
        return pauseTextPane;
    }
}
