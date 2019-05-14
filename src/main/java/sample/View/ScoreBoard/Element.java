package sample.View.ScoreBoard;

import javafx.scene.text.Text;

public class Element
{
    private Text text = new Text();

    public Element(String str, int row, int col)
    {
        this.text.setId("scoreText");
        if (col > 0)
        {
            str = "| " + str;
        }
        this.text.setText(str);
        this.text.setLayoutY(150 + (row * 50));
        this.text.setLayoutX(20 + (col * 110));
    }

    public Text getText()
    {
        return this.text;
    }
}
