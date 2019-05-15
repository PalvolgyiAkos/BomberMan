package sample.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerModelTest {

    PlayerModel playerModel;

    @BeforeEach
    void setUp() {
        playerModel=new PlayerModel(50,50);
    }

    @AfterEach
    void tearDown() {
        playerModel=null;
    }

    @Test
    void refreshPlacedBomb() {
        playerModel.setPlacedBomb(1,1);
        playerModel.refreshPlacedBomb(2,2);
        int x= playerModel.getPlacedBomb()[1];
        int y= playerModel.getPlacedBomb()[0];
        assertEquals(-1, x);
        assertEquals(-1, y);
    }

    @Test
    void onPlacedBomb() {
        playerModel=new PlayerModel(100, 100);
        playerModel.setPlacedBomb(1 ,1);
        assertEquals(true, playerModel.onPlacedBomb());
    }

    @Test
    void speedUp() {
        assertEquals(2, playerModel.getMovementSpeed());
        playerModel.speedUp();
        assertEquals(2.5 , playerModel.getMovementSpeed());
    }

    @Test
    void powerUp() {
        assertEquals(2, playerModel.getBombPower());
        playerModel.powerUp();
        assertEquals(3, playerModel.getBombPower());
    }

    @Test
    void addBomb() {
        assertEquals(1, playerModel.getAvailableBombs());
        playerModel.addBomb();
        assertEquals(2,playerModel.getAvailableBombs());
    }

    @Test
    void incScore() {
        assertEquals(0, playerModel.getScore());
        playerModel.incScore(5);
        assertEquals(5, playerModel.getScore());
    }
}