package sample.Controller;

import javafx.animation.AnimationTimer;
import sample.DAO.XMLHandle;
import sample.Status;
import sample.View.GameScene;
import sample.View.GamePage.Player;

public class PlayerController
{
    private XMLHandle xmlHandle=new XMLHandle();
    private int afterDeathTime = 90;
    private int someoneIsDead = 0;
    private int entered = 60;
    public PlayerController(GameScene gameScene)
    {
        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if (entered == 0)
                {
                    entered = 60;
                    gameScene.setEntered(false);
                }
                if (gameScene.isEntered())
                {
                    entered--;
                }
                if (gameScene.getStatus() == Status.MAINPAGE)
                {
                    someoneIsDead = 0;
                    afterDeathTime = 90;
                }
                else if (gameScene.getStatus() == Status.GAMEPAGE)
                {
                    gameScene.getGamePage().getTimer().setTime(gameScene.getGamePage().getTimer().getTime()-1);
                    gameScene.getGamePage().getPause().getPane().setVisible(false);
                    gameScene.getGamePage().getPauseText().getPauseTextPane().setVisible(false);
                    gameScene.getGamePage().getPressPText().getPauseTextPane().setVisible(false);
                    Player player = gameScene.getGamePage().getPlayer();
                    Player player_2 = gameScene.getGamePage().getPlayer_2();
                    if (someoneIsDead % 2 == 0)
                    {
                        player.getPlayerModel().move(gameScene.getGamePage());
                        player.refresh();
                    }
                    if (someoneIsDead < 2)
                    {
                        player_2.getPlayerModel().move(gameScene.getGamePage());
                        player_2.refresh();
                    }

                    if (gameScene.getGamePage().getTimer().getTime() == 0)
                    {
                        someoneIsDead = 3;
                        afterDeathTime = 0;
                    }

                    if (afterDeathTime == 0)
                    {
                        gameScene.getEndPage().setResult(someoneIsDead);
                        gameScene.setStatus(Status.END);
                        gameScene.setVisible();
                        String result = someoneIsDead == 3 ? "Draw" : someoneIsDead == 1 ? "Player2 Won" : "Player1 Won";
                        xmlHandle.create(player.getPlayerModel().getName(), player.getPlayerModel().getScore(),
                                player_2.getPlayerModel().getName(), player_2.getPlayerModel().getScore(),
                                gameScene.getGamePage().getTimer().getPlayedTime(), result);
                        try
                        {
                            xmlHandle.read();
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }

                    if (someoneIsDead != 0)
                    {
                        afterDeathTime--;
                    }

                    int p1_posX = (int) (player.getPlayerModel().getPositionX() - 5) / 50;
                    int p1_posY = (int) (player.getPlayerModel().getPositionY() - 15) / 50;
                    if (gameScene.getGamePage().getPalya()[p1_posY][p1_posX] == 9
                            || gameScene.getGamePage().getPalya()[p1_posY][p1_posX] == 7)
                    {
                        if (someoneIsDead == 0)
                        {
                            someoneIsDead = 1;
                        } else if (someoneIsDead == 2)
                        {
                            someoneIsDead = 3;
                        }
                    }
                    int p2_posX = (int) (player_2.getPlayerModel().getPositionX() - 5) / 50;
                    int p2_posY = (int) (player_2.getPlayerModel().getPositionY() - 15) / 50;
                    if (gameScene.getGamePage().getPalya()[p2_posY][p2_posX] == 9
                            || gameScene.getGamePage().getPalya()[p2_posY][p2_posX] == 7)
                    {
                        if (someoneIsDead == 0)
                        {
                            someoneIsDead = 2;
                        } else if (someoneIsDead == 1)
                        {
                            someoneIsDead = 3;
                        }
                    }
                }
                else if (gameScene.getStatus()==Status.PAUSE)
                {
                    gameScene.getGamePage().getPause().getPane().setVisible(true);
                    gameScene.getGamePage().getPauseText().getPauseTextPane().setVisible(true);
                    gameScene.getGamePage().getPressPText().getPauseTextPane().setVisible(true);
                }
            }
        }.start();
    }
}
