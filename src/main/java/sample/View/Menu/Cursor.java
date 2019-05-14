package sample.View.Menu;

import javafx.scene.layout.Pane;
import sample.Model.CursorModel;
import java.util.ArrayList;

public class Cursor
{
    private Pane cursorLeft=new Pane();
    private Pane cursorRight=new Pane();
    private CursorModel cursorModel=new CursorModel();
    private int index;

    public Cursor()
    {
        this.index=1;
        this.cursorLeft.getStyleClass().add("cursor");
        this.cursorRight.getStyleClass().add("cursor");
        this.cursorLeft.setId("left");
        this.cursorRight.setId("right");
        refresh();
    }

    public CursorModel getCursorModel()
    {
        return cursorModel;
    }

    public ArrayList<Pane> getCursor()
    {
        ArrayList<Pane> cursors= new ArrayList<>();
        cursors.add(cursorRight);
        cursors.add(cursorLeft);
        return cursors;
    }

    public void refresh()
    {
        this.cursorLeft.setPrefSize(cursorModel.getWidth(), cursorModel.getHeight());
        this.cursorLeft.setLayoutX(cursorModel.getPositionX());
        this.cursorLeft.setLayoutY(cursorModel.getPositionY());
        this.cursorRight.setPrefSize(cursorModel.getWidth(), cursorModel.getHeight());
        this.cursorRight.setLayoutY(cursorModel.getPositionY());
        this.cursorRight.setLayoutX(cursorModel.getPositionX()+cursorModel.getDistance()+cursorModel.getWidth());
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
