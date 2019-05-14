package sample.View.Menu;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class MainPage
{
    private AnchorPane page=new AnchorPane();
    private ArrayList<MenuButton> buttons=new ArrayList<MenuButton>();
    private Cursor cursor=new Cursor();
    private GameName gameName=new GameName();

    public MainPage(final int width, final int height)
    {
        this.page.setId("mainPage");
        this.page.setPrefSize(width, height);

        this.page.getChildren().addAll(this.gameName.getGamePane());
        this.buttons.add(new MenuButton("exit", height / 16 * 13));
        this.buttons.add(new MenuButton("credits", height / 16 * 12));
        this.buttons.add(new MenuButton("settings", height / 16 * 11));
        this.buttons.add(new MenuButton("scoreboard", height / 16 * 10));
        this.buttons.add(new MenuButton("start", height / 16 * 9));
        this.buttons.forEach(item -> this.page.getChildren().add(item.getButton()));
        this.cursor.getCursor().forEach(item -> this.page.getChildren().add(item));
    }

    public AnchorPane getPage()
    {
        return page;
    }

    public Cursor getCursor()
    {
        return cursor;
    }
}
