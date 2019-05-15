package sample.DAO;

/**
 * This is the class which contains data for the DB.
 */
public class ScoreData
{
    /**
     * This is the Player1's name ({@code String}).
     */
    private String player1;
    /**
     * This is the Player1's score ({@code int}).
     */
    private int player1_score;
    /**
     * This is the Player2's name ({@code String}).
     */
    private String player2;
    /**
     * This is the Player2's score ({@code int}).
     */
    private int player2_score;
    /**
     * This is the played time ({@code String}).
     */
    private String time;
    /**
     * This is the game result ({@code String}).
     */
    private String result;

    /**
     * This is the constructor of the {@code ScoreData} class.
     */
    public ScoreData()
    {
    }

    /**
     * This is a getter function.
     *
     * @return the Player1's name.
     */
    public String getPlayer1()
    {
        return player1;
    }

    /**
     * This is a setter method for Player1's name.
     *
     * @param player1 is the chosen {@code String}.
     */
    public void setPlayer1(String player1)
    {
        this.player1 = player1;
    }

    /**
     * This is a getter function.
     *
     * @return the Player1's score.
     */
    public int getPlayer1_score()
    {
        return player1_score;
    }

    /**
     * This is a setter method for Player1's score.
     *
     * @param player1_score is the chosen {@code int}.
     */
    public void setPlayer1_score(int player1_score)
    {
        this.player1_score = player1_score;
    }

    /**
     * This is a getter function.
     *
     * @return the Player2's name.
     */
    public String getPlayer2()
    {
        return player2;
    }

    /**
     * This is a setter method for Player2's name.
     *
     * @param player2 is the chosen {@code String}
     */
    public void setPlayer2(String player2)
    {
        this.player2 = player2;
    }

    /**
     * This is a getter function.
     *
     * @return the Player2's score.
     */
    public int getPlayer2_score()
    {
        return player2_score;
    }

    /**
     * This is a setter method for Player2's score.
     *
     * @param player2_score is the chosen {@code int}.
     */
    public void setPlayer2_score(int player2_score)
    {
        this.player2_score = player2_score;
    }

    /**
     * This is a getter function.
     *
     * @return the played time.
     */
    public String getTime()
    {
        return time;
    }

    /**
     * This is a setter method for the played time.
     *
     * @param time is the chosen {@code String}.
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * This is a getter function.
     *
     * @return the game result.
     */
    public String getResult()
    {
        return result;
    }

    /**
     * This is a setter method for the game result.
     *
     * @param result is the chosen {@code String}
     */
    public void setResult(String result)
    {
        this.result = result;
    }
}
