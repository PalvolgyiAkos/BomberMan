package sample.View.GamePage;

import javafx.scene.layout.AnchorPane;
import sample.View.GamePage.Pause.Pause;
import sample.View.GamePage.Pause.PauseText;
import sample.View.GamePage.Pause.PressPText;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class GamePage
{
    private AnchorPane page=new AnchorPane();
    private Tile[][] tiles=new Tile[13][13];
    private Player player;
    private Player player_2;
    private ArrayList<Bomb> bombs = new ArrayList<>();
    private ArrayList<Explosion> explosions = new ArrayList<>();
    private int[][] palya=new int[13][13];
    private Timer timer;

    private int[] player1 = new int[2];
    private int[] player2 = new int[2];

    private Pause pause;
    private PauseText pauseText=new PauseText();
    private PressPText pressPText=new PressPText();
    Logger logger=Logger.getLogger("GamePage");

    public GamePage(final int width, final int height)
    {
        this.page.setId("gamePage");
        this.page.setPrefSize(width, height);
        pause=new Pause(width, height);
    }

    public void reset()
    {
        this.page.getChildren().removeAll(player.getPane(), player_2.getPane());
        for (Tile[] tile : tiles) {
            for (Tile value : tile) {
                this.page.getChildren().remove(value.getPane());
            }
        }
        for (Bomb bomb : bombs) {
            this.page.getChildren().remove(bomb.getPane());
        }
        for (Explosion explosion : explosions) {
            for (int j = 0; j < explosion.getDraw().size(); j++) {
                this.page.getChildren().remove(explosion.getDraw().get(j));
            }
        }
        bombs.clear();
        explosions.clear();
    }

    public void generateField()
    {
        Beolvas();
        randomizeWalls();
        for (int i=0; i<13;i++)
        {
            for (int k=0; k<13;k++)
            {
                String id;
                if (palya[i][k] == 0)
                {
                    id="wall";
                }
                else if(palya[i][k] == 4)
                {
                    id="dwall";
                }
                else if(palya[i][k] == 1)
                {
                    player1[0]=i;
                    player1[1]=k;
                    palya[i][k] = 8;
                    id="field";
                }
                else if(palya[i][k] == 2)
                {
                    player2[0]=i;
                    player2[1]=k;
                    palya[i][k] = 8;
                    id="field";
                }
                else
                {
                    id="field";
                }
                tiles[i][k] = new Tile(k*50,i*50, id);
                this.page.getChildren().add(tiles[i][k].getPane());
            }
        }
        addPowerUps();
        this.player=new Player(player1[0]*50+30 , player1[1]*50+40, "player1");
        this.player_2=new Player(player2[0]*50+30 , player2[1]*50+40, "player2");
        this.timer = new Timer();
        this.page.getChildren().addAll(this.player.getPane(), this.player_2.getPane(), this.timer.getPane(), this.timer.getText());
    }

    private void randomizeWalls()
    {
        int neededWalls = 0;
        for (int[] ints : palya) {
            for (int anInt : ints) {
                if (anInt == 9) {
                    neededWalls++;
                }
            }
        }
        neededWalls = (int) Math.ceil(neededWalls * 0.9);
        int wallCounter = 0;
        while (wallCounter < neededWalls)
        {
            for (int i = 0; i < palya.length; i++)
            {
                for (int k = 0; k < palya[i].length; k++)
                {
                    if (palya[i][k] == 9 && Math.random() > 0.5)
                    {
                        palya[i][k] = 4;
                        wallCounter++;
                    }
                    if (wallCounter == neededWalls)
                    {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < palya.length; i++)
        {
            for (int k = 0; k < palya[i].length; k++)
            {
                if (palya[i][k] == 9)
                {
                    palya[i][k] = 8;
                }
            }
        }
    }

    private void addPowerUps()
    {
        Random rand = new Random();
        int speedCounter = 0;
        while (speedCounter < 10)
        {
            int i = rand.nextInt(12)+1;
            int k = rand.nextInt(12)+1;
            if (this.palya[i][k] == 4)
            {
                this.palya[i][k] = 1;
                speedCounter++;
            }
        }
        int powerUpCounter = 0;
        while (powerUpCounter < 10)
        {
            int i = rand.nextInt(12)+1;
            int k = rand.nextInt(12)+1;
            if (this.palya[i][k] == 4)
            {
                this.palya[i][k] = 2;
                powerUpCounter++;
            }
        }
        int bombCounter = 0;
        while (bombCounter < 10)
        {
            int i = rand.nextInt(12)+1;
            int k = rand.nextInt(12)+1;
            if (this.palya[i][k] == 4)
            {
                this.palya[i][k] = 3;
                bombCounter++;
            }
        }
    }

    public void ManagePause(boolean isPause)
    {
        if (isPause)
        {
            this.page.getChildren().addAll( this.pause.getPane(), this.pauseText.getPauseTextPane(),
                    this.pressPText.getPauseTextPane());
        }
        else
        {
            this.page.getChildren().removeAll( this.pause.getPane(), this.pauseText.getPauseTextPane(),
                    this.pressPText.getPauseTextPane());
        }
    }

    public void Beolvas()
    {
        try
        {
            Scanner sc = new Scanner(new File("src\\main\\resources\\sample\\View\\GamePage\\GAMEFIELD.txt"));
            for (int i = 0; i < 13; i++)
            {
                for (int j = 0; j < 13; j++)
                {
                    palya[i][j] = sc.nextInt();
                }
            }
            sc.close();
        } catch (FileNotFoundException e)
        {
            logger.info("NO FILE");
        }
    }

    public void newBomb(double positionX, double positionY, Player planter)
    {
        Bomb bomb = new Bomb(positionX, positionY, "bomb", planter);
        boolean freePlace = true;
        for (Bomb value : this.bombs) {
            if ((positionX == value.getBombModel().getPositionX()) && (positionY == value.getBombModel().getPositionY())) {
                freePlace = false;
            }
        }
        if (freePlace)
        {
            this.bombs.add(bomb);
            this.page.getChildren().add(bomb.getPane());
        }
    }

    public AnchorPane getPage()
    {
        return page;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Player getPlayer_2()
    {
        return player_2;
    }

    public int[][] getPalya()
    {
        return palya;
    }

    public Pause getPause()
    {
        return pause;
    }

    public PauseText getPauseText()
    {
        return pauseText;
    }

    public PressPText getPressPText()
    {
        return pressPText;
    }

    public ArrayList<Bomb> getBombs()
    {
        return bombs;
    }

    public ArrayList<Explosion> getExplosions()
    {
        return explosions;
    }

    public Timer getTimer()
    {
        return timer;
    }
}
