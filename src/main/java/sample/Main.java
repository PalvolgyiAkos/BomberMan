package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.View.GameScene;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("BomberMan");
        GameScene gameScene=new GameScene();
        primaryStage.setScene(gameScene.getScene());
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
