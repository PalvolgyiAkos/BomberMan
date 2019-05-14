package sample.View.GamePage.Pause;

import javafx.scene.layout.Pane;

public class Pause {
    private Pane pane;

    public Pause(int width, int height) {
        this.pane=new Pane();
        this.pane.setId("pause");
        this.pane.setPrefSize(width, height);
    }

    public Pane getPane()
    {
        return pane;
    }

    public void setPane(Pane pane)
    {
        this.pane = pane;
    }

}
