package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.View.GameScene;

/**
 * The main part of the application.
 */
public class Main extends Application
{
    /**
     * Launch the application.
     *
     * @param primaryStage is the chosen {@code Stage}
     */
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("BomberMan");
        GameScene gameScene=new GameScene();
        primaryStage.setScene(gameScene.getScene());
        primaryStage.show();
    }

    /**
     * Main method of the BomberMan application.
     *
     * @param args is not used
     * */
    public static void main(String[] args)
    {
        launch(args);
    }
}
