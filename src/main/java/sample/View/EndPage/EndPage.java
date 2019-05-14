package sample.View.EndPage;

import javafx.scene.layout.Pane;
import sample.View.Menu.Cursor;
import sample.View.Menu.MenuButton;
import java.util.ArrayList;

public class EndPage
{
    private Pane pane;
    private ArrayList<MenuButton> buttons = new ArrayList<MenuButton>();
    private Cursor cursor=new Cursor();
    private Pane result = new Pane();

    public EndPage(final double width, final double height)
    {
        this.pane = new Pane();
        this.pane.setId("endPage");
        this.pane.setPrefSize(width,height);
        this.buttons.add(new MenuButton("exit", (int) height / 16 * 12));
        this.buttons.add(new MenuButton("mainMenu", (int) height / 16 * 11));

        double tmp = this.cursor.getCursorModel().getPositionY() + height / 16 * 2;
        this.cursor.getCursorModel().setPositionY(tmp);
        this.cursor.refresh();

        this.result.getStyleClass().add("result");
        this.result.setPrefSize(500, 500);
        this.result.setLayoutX(100);
        this.result.setLayoutY(30);

        this.buttons.forEach(item -> this.pane.getChildren().add(item.getButton()));
        this.cursor.getCursor().forEach(item -> this.pane.getChildren().add(item));
        this.pane.getChildren().add(this.result);
    }

    public void setResult(int result)
    {
        switch (result)
        {
            case 1:
                this.result.setId("one");
                break;
            case 2:
                this.result.setId("two");
                break;
            case 3:
                this.result.setId("draw");
                break;
        }
    }

    public Pane getPane()
    {
        return pane;
    }

    public Cursor getCursor()
    {
        return cursor;
    }
}
