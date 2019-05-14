package sample.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLHandleTest {

    XMLHandle xmlHandle;

    @Test
    void create() {
        xmlHandle=new XMLHandle();
        xmlHandle.create("Jani", 20,"Sanyi", 25, "01:20", "draw");

        try {
            xmlHandle.read();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        ScoreData test=xmlHandle.getScoreDataList().get(xmlHandle.getScoreDataList().size()-1);
        assertEquals("Jani", test.getPlayer1());
        assertEquals(20, test.getPlayer1_score());
        assertEquals("Sanyi", test.getPlayer2());
        assertEquals(25, test.getPlayer2_score());
        assertEquals("01:20", test.getTime());
        assertEquals("draw", test.getResult());
        //String player1, int player1_score, String player2, int player2_score, String time, String result1
    }
}