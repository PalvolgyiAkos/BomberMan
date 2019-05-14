package sample.View.Naming;

import javafx.scene.layout.Pane;

public class Naming
{
    private Pane pane = new Pane();
    private boolean isDone = false;
    private NameReader nameReader = new NameReader("Player1");

    public Naming(int width, int height)
    {
        this.pane.setPrefSize(width, height);
        this.pane.setId("mainPage");
        this.nameReader.getText().setLayoutX(200);
        this.nameReader.getText().setLayoutY(300);
        this.nameReader.getTextField().setLayoutX(200);
        this.nameReader.getTextField().setLayoutY(330);
        this.pane.getChildren().addAll(nameReader.getText(), nameReader.getTextField());
    }

    public String getName()
    {
        return nameReader.getTextField().getText();
    }

    public Pane getPane()
    {
        return pane;
    }

    public void setNameReader(String text)
    {
        this.nameReader.getText().setText(text);
        this.nameReader.getTextField().setText(text);
        this.nameReader.getTextField().selectAll();
    }

    public boolean isDone()
    {
        return isDone;
    }

    public void setDone(boolean done)
    {
        isDone = done;
    }
}
