package sample.DAO;

public class ScoreData
{
    private String player1;
    private int player1_score;
    private String player2;
    private int player2_score;
    private String time;
    private String result;

    public ScoreData()
    {
    }

    public String getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(String player1)
    {
        this.player1 = player1;
    }

    public int getPlayer1_score()
    {
        return player1_score;
    }

    public void setPlayer1_score(int player1_score)
    {
        this.player1_score = player1_score;
    }

    public String getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(String player2)
    {
        this.player2 = player2;
    }

    public int getPlayer2_score()
    {
        return player2_score;
    }

    public void setPlayer2_score(int player2_score)
    {
        this.player2_score = player2_score;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }
}
