package sample.View.GamePage;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Timer
{
    private Pane pane = new Pane();
    private Text text = new Text();
    private int time = 18000;

    public Timer()
    {
        this.pane.setStyle("-fx-background-color: gray;");
        this.pane.setPrefSize(55,25);
        this.pane.setLayoutX(595);
        this.pane.setLayoutY(5);
        text.setId("text");
        text.setText(getString(time));
        text.setLayoutX(600);
        text.setLayoutY(25);
    }

    private String getString(int time)
    {
        int min = Math.floorDiv(time, 3600);
        int sec = Math.floorMod(Math.floorDiv(time, 60),60);
        String string = "0";
        string = string + min + ":";
        if (sec < 10)
        {
            string = string + "0";
        }
        string = string + sec;
        return string;
    }

    public String getPlayedTime()
    {
        int tmp=18000-time;
        return getString(tmp);
    }

    public void setTime(int time)
    {
        this.time = time;
        text.setText(getString(time));
    }

    public int getTime()
    {
        return time;
    }

    public Text getText()
    {
        return text;
    }

    public Pane getPane()
    {
        return pane;
    }
}
