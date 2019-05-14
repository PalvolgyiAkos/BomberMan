package sample.View;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import sample.Controller.GameSceneController;
import sample.Model.GameSceneModel;
import sample.Status;
import sample.View.EndPage.EndPage;
import sample.View.GamePage.GamePage;
import sample.View.Menu.MainPage;
import sample.View.Naming.Naming;
import sample.View.ScoreBoard.ScoreBoard;

public class GameScene
{
    private Status status=Status.MAINPAGE;
    private Scene scene;
    private AnchorPane anchorPane=new AnchorPane();
    private GameSceneModel gameSceneModel=new GameSceneModel();
    private MainPage mainPage=new MainPage(gameSceneModel.getWidth(), gameSceneModel.getHeight());
    private ScoreBoard scoreBoard;
    private Naming naming = new Naming(gameSceneModel.getWidth(), gameSceneModel.getHeight());
    private GamePage gamePage;
    private EndPage endPage = new EndPage(gameSceneModel.getWidth(), gameSceneModel.getHeight());

    private boolean isEntered = false;

    public GameScene()
    {
        this.gamePage =new GamePage(gameSceneModel.getWidth(), gameSceneModel.getHeight());
        this.scene = new Scene(anchorPane, gameSceneModel.getWidth(), gameSceneModel.getHeight());
        this.scoreBoard = new ScoreBoard(gameSceneModel.getWidth(), gameSceneModel.getHeight());
        LoadPage();
        this.scene.getStylesheets().add(getClass().getResource("Visual.css").toExternalForm());
        new GameSceneController(this);
    }

    private void LoadPage()
    {
        this.anchorPane.getChildren().add(mainPage.getPage());
        this.anchorPane.getChildren().add(scoreBoard.getPane());
        this.anchorPane.getChildren().add(naming.getPane());
        this.anchorPane.getChildren().add(gamePage.getPage());
        this.anchorPane.getChildren().add(endPage.getPane());
        setVisible();
    }

    public void setVisible()
    {
        mainPage.getPage().setVisible(false);
        scoreBoard.getPane().setVisible(false);
        naming.getPane().setVisible(false);
        gamePage.getPage().setVisible(false);
        endPage.getPane().setVisible(false);
        switch (this.status)
        {
            case MAINPAGE:
                mainPage.getPage().setVisible(true);
                break;
            case SCOREBOARD:
                scoreBoard.getPane().setVisible(true);
                break;
            case NAMING:
                naming.getPane().setVisible(true);
                break;
            case GAMEPAGE:
                gamePage.getPage().setVisible(true);
                break;
            case END:
                endPage.getPane().setVisible(true);
                break;
        }
    }

    public boolean isEntered()
    {
        return isEntered;
    }

    public void setEntered(boolean entered)
    {
        isEntered = entered;
    }

    public Naming getNaming()
    {
        return naming;
    }

    public Scene getScene()
    {
        return scene;
    }

    public MainPage getMainPage()
    {
        return mainPage;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public GamePage getGamePage()
    {
        return gamePage;
    }

    public EndPage getEndPage()
    {
        return endPage;
    }

    public ScoreBoard getScoreBoard()
    {
        return scoreBoard;
    }
}
