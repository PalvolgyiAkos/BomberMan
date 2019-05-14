package sample.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {

    BombModel bombModel;
    CursorModel cursorModel;
    GameSceneModel gameSceneModel;
    MenuButtonModel menuButtonModel;
    PlayerModel playerModel;
    TextModel textModel;
    TileModel tileModel;

    @BeforeEach
    void setUp() {
        bombModel = new BombModel(50,50,5);
        cursorModel=new CursorModel();
        gameSceneModel=new GameSceneModel();
        menuButtonModel=new MenuButtonModel();
        playerModel=new PlayerModel(50,50);
        textModel=new TextModel();
        tileModel=new TileModel(50,50);
    }

    @AfterEach
    void tearDown() {
        bombModel=null;
        cursorModel=null;
        gameSceneModel=null;
        menuButtonModel=null;
        playerModel=null;
        textModel=null;
        tileModel=null;
    }

    @Test
    void bombModelTest()
    {
        assertEquals(50, bombModel.getHeight());
        assertEquals(50, bombModel.getWidth());
        assertEquals(50, bombModel.getPositionX());
        assertEquals(50, bombModel.getPositionY());
        assertEquals(240, bombModel.getLifeTime());
        assertEquals(5,bombModel.getPower());
        bombModel.setHeight(50);
        assertEquals(50, bombModel.getHeight());
        bombModel.setWidth(120);
        assertEquals(120, bombModel.getWidth());
        bombModel.setLifeTime(200);
        assertEquals(200, bombModel.getLifeTime());
    }

    @Test
    void cursorModelTest()
    {
        assertEquals(50, cursorModel.getWidth());
        assertEquals(50, cursorModel.getHeight());
        assertEquals(200, cursorModel.getPositionX());
        assertEquals(385, cursorModel.getPositionY());
        assertEquals(200, cursorModel.getDistance());
        cursorModel.setWidth(20);
        assertEquals(20, cursorModel.getWidth());
        cursorModel.setHeight(25);
        assertEquals(25, cursorModel.getHeight());
        cursorModel.setPositionY(40);
        assertEquals(40, cursorModel.getPositionY());
    }

    @Test
    void gameSceneModelTest()
    {
        assertEquals(700, gameSceneModel.getWidth());
        assertEquals(700, gameSceneModel.getHeight());
        gameSceneModel.setHeight(500);
        assertEquals(500, gameSceneModel.getHeight());
        gameSceneModel.setWidth(400);
        assertEquals(400, gameSceneModel.getWidth());
    }

    @Test
    void menuButtonModelTest()
    {
        assertEquals(150, menuButtonModel.getWidth());
        assertEquals(50, menuButtonModel.getHeight());
        assertEquals(275,menuButtonModel.getPositionX());
        assertEquals(600,menuButtonModel.getPositionY());
        menuButtonModel.setWidth(200);
        assertEquals(200,menuButtonModel.getWidth());
        menuButtonModel.setHeight(300);
        assertEquals(300,menuButtonModel.getHeight());
        menuButtonModel.setPositionY(350);
        assertEquals(350,menuButtonModel.getPositionY());
    }

    @Test
    void playerModelTest()
    {
        assertEquals(50,playerModel.getWidth());
        assertEquals(50,playerModel.getHeight());
        assertEquals(1,playerModel.getAvailableBombs());
        assertEquals(2,playerModel.getBombPower());
        assertEquals(0,playerModel.getScore());
        assertEquals(50, playerModel.getPositionX());
        assertEquals(50, playerModel.getPositionY());
        playerModel.setAvailableBombs(5);
        assertEquals(5,playerModel.getAvailableBombs());
        playerModel.setName("Jani");
        assertEquals("Jani", playerModel.getName());
        playerModel.setHeight(200);
        assertEquals(200, playerModel.getHeight());
        playerModel.setWidth(250);
        assertEquals(250, playerModel.getWidth());
    }

    @Test
    void textModelTest()
    {
     assertEquals(600, textModel.getWidth());
     assertEquals(150, textModel.getHeight());
     assertEquals(50, textModel.getPositionX());
     assertEquals(100, textModel.getPositionY());
     textModel.setWidth(200);
     assertEquals(200,textModel.getWidth());
     textModel.setHeight(300);
     assertEquals(300, textModel.getHeight());
     textModel.setPositionX(0);
     assertEquals(0, textModel.getPositionX());
     textModel.setPositionY(1000);
     assertEquals(1000, textModel.getPositionY());
    }

    @Test
    void tileModelTest()
    {
        assertEquals(50, tileModel.getWidth());
        assertEquals(50, tileModel.getHeight());
        assertEquals(50, tileModel.getPositionX());
        assertEquals(50, tileModel.getPositionY());
    }
}