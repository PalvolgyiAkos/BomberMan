package sample.View.Naming;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NameReader
{
    private Text text = new Text();
    private TextField textField = new TextField();

    public NameReader(String name)
    {
        this.text.setLayoutX(200);
        this.text.setLayoutY(300);
        this.text.setText(name);
        this.text.setId("text");
        this.textField.setId("text");
        this.textField.setLayoutX(200);
        this.textField.setLayoutY(330);
        this.textField.setText(name);
    }

    public Text getText()
    {
        return text;
    }

    public TextField getTextField()
    {
        return textField;
    }
}
