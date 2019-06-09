package sample.Controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Status;
import sample.View.GamePage.Player;
import sample.View.GameScene;
import sample.View.Menu.MainPage;

import java.util.logging.Logger;

/**
 * This is the class which manages the whole GameScene.
 */
public class GameSceneController
{
    /**
     * This is a {@code boolean} which decide to pause the game.
     */
    private boolean ifPaused;
    /**
     * This is an object ({@code Player}) for player1.
     */
    private Player player1;
    /**
     * This is an object ({@code Player}) for player2.
     */
    private Player player2;
    /**
     * This is the logger of the GameSceneController.
     */
    Logger logger=Logger.getLogger("GameSceneController");

    /**
     * This is the constructor which managing the key actions.
     *
     * @param gameScene is the chosen {@code GameScene}
     */
    public GameSceneController(GameScene gameScene)
    {
        MainPage mainPage = gameScene.getMainPage();

        new PlayerController(gameScene);
        new BombController(gameScene);

        gameScene.getScene().setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            /**
             * This is the method which manages the keypress actions.
             *
             * @param event is the chosen {@code KeyEvent}.
             */
            @Override
            public void handle(KeyEvent event)
            {
                if(event.getCode()== KeyCode.ESCAPE)
                {
                    System.exit(0);
                }
                if (gameScene.getStatus() == Status.MAINPAGE)
                {
                    if(event.getCode()== KeyCode.DOWN && mainPage.getCursor().getIndex() < 5)
                    {
                        double tmp = mainPage.getCursor().getCursorModel().getPositionY() + mainPage.getPage().getHeight()/16;
                        mainPage.getCursor().getCursorModel().setPositionY(tmp);
                        mainPage.getCursor().setIndex(mainPage.getCursor().getIndex()+1);
                    }
                    if(event.getCode()== KeyCode.UP && mainPage.getCursor().getIndex() > 1 )
                    {
                        double tmp = mainPage.getCursor().getCursorModel().getPositionY() - mainPage.getPage().getHeight()/16;
                        mainPage.getCursor().getCursorModel().setPositionY(tmp);
                        mainPage.getCursor().setIndex(mainPage.getCursor().getIndex()-1);
                    }
                    mainPage.getCursor().refresh();

                    if(event.getCode()== KeyCode.ENTER)
                    {
                        gameScene.setEntered(true);
                        switch (mainPage.getCursor().getIndex())
                        {
                            case 1:
                                logger.info("Start");
                                gameScene.getGamePage().generateField();
                                player1 = gameScene.getGamePage().getPlayer();
                                player2 = gameScene.getGamePage().getPlayer_2();
                                gameScene.setStatus(Status.NAMING);
                                gameScene.setVisible();
                                ifPaused=false;
                                break;
                            case 2:
                                logger.info("ScoreBoard");
                                gameScene.getScoreBoard().resetData();
                                gameScene.setStatus(Status.SCOREBOARD);
                                gameScene.setVisible();
                                break;
                            case 3:
                                logger.info("Settings");
                                break;
                            case 4:
                                logger.info("Credits");
                                break;
                            case 5:
                                logger.info("Exit");
                                System.exit(0);
                                break;
                        }
                    }
                }
                if(gameScene.getStatus() == Status.SCOREBOARD)
                {
                    if (event.getCode() == KeyCode.BACK_SPACE)
                    {
                        gameScene.setStatus(Status.MAINPAGE);
                        gameScene.setVisible();
                    }
                }
                if(gameScene.getStatus() == Status.NAMING)
                {
                    if (event.getCode() == KeyCode.ENTER && !gameScene.isEntered() && !gameScene.getNaming().isDone())
                    {
                        gameScene.setEntered(true);
                        gameScene.getGamePage().getPlayer().getPlayerModel().setName(gameScene.getNaming().getName());
                        gameScene.getNaming().setDone(true);
                        gameScene.getNaming().setNameReader("Player2");
                    } else if (event.getCode() == KeyCode.ENTER && !gameScene.isEntered() && gameScene.getNaming().isDone())
                    {
                        gameScene.setEntered(true);
                        gameScene.getGamePage().getPlayer_2().getPlayerModel().setName(gameScene.getNaming().getName());
                        gameScene.getNaming().setDone(false);
                        gameScene.getNaming().setNameReader("Player1");
                        gameScene.setStatus(Status.GAMEPAGE);
                        gameScene.setVisible();
                    }
                }
                if(gameScene.getStatus() == Status.GAMEPAGE)
                {
                    if(event.getCode()== KeyCode.LEFT && player1.getPlayerModel().getMoveDirection()[1] == 0)
                    {
                        player1.getPlayerModel().getMoveDirection()[1] =
                                player1.getPlayerModel().getMoveDirection()[0] + 1;
                        player1.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.RIGHT && player1.getPlayerModel().getMoveDirection()[2] == 0)
                    {
                        player1.getPlayerModel().getMoveDirection()[2] =
                                player1.getPlayerModel().getMoveDirection()[0] + 1;
                        player1.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.UP && player1.getPlayerModel().getMoveDirection()[3] == 0)
                    {
                        player1.getPlayerModel().getMoveDirection()[3] =
                                player1.getPlayerModel().getMoveDirection()[0] + 1;
                        player1.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.DOWN && player1.getPlayerModel().getMoveDirection()[4] == 0)
                    {
                        player1.getPlayerModel().getMoveDirection()[4] =
                                player1.getPlayerModel().getMoveDirection()[0] + 1;
                        player1.getPlayerModel().getMoveDirection()[0]++;
                    } else if (event.getCode() == KeyCode.L && player1.getPlayerModel().getAvailableBombs() > 0)
                    {
                        int posX = (int)(player1.getPlayerModel().getPositionX() - 30 + 25) / 50;
                        int posY = (int)(player1.getPlayerModel().getPositionY() - 40 + 25) / 50;
                        gameScene.getGamePage().getPlayer().getPlayerModel().setPlacedBomb(posY,posX);
                        gameScene.getGamePage().newBomb(posX*50+30,posY*50+40, player1);
                        player1.getPlayerModel().setAvailableBombs(player1.getPlayerModel().getAvailableBombs()-1);
                        gameScene.getGamePage().getPalya()[posY][posX] = 6;
                    }
                    else if(event.getCode()== KeyCode.A && player2.getPlayerModel().getMoveDirection()[1] == 0)
                    {
                        player2.getPlayerModel().getMoveDirection()[1] =
                                player2.getPlayerModel().getMoveDirection()[0] + 1;
                        player2.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.D && player2.getPlayerModel().getMoveDirection()[2] == 0)
                    {
                        player2.getPlayerModel().getMoveDirection()[2] =
                                player2.getPlayerModel().getMoveDirection()[0] + 1;
                        player2.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.W && player2.getPlayerModel().getMoveDirection()[3] == 0)
                    {
                        player2.getPlayerModel().getMoveDirection()[3] =
                                player2.getPlayerModel().getMoveDirection()[0] + 1;
                        player2.getPlayerModel().getMoveDirection()[0]++;
                    } else if(event.getCode()== KeyCode.S && player2.getPlayerModel().getMoveDirection()[4] == 0)
                    {
                        player2.getPlayerModel().getMoveDirection()[4] =
                                player2.getPlayerModel().getMoveDirection()[0] + 1;
                        player2.getPlayerModel().getMoveDirection()[0]++;
                    } else if (event.getCode() == KeyCode.DIGIT0 && player2.getPlayerModel().getAvailableBombs() > 0)
                    {
                        int posX = (int)(player2.getPlayerModel().getPositionX() - 30 + 25) / 50;
                        int posY = (int)(player2.getPlayerModel().getPositionY() - 40 + 25) / 50;
                        gameScene.getGamePage().getPlayer_2().getPlayerModel().setPlacedBomb(posY,posX);
                        gameScene.getGamePage().newBomb(posX*50+30,posY*50+40, player2);
                        player2.getPlayerModel().setAvailableBombs(player2.getPlayerModel().getAvailableBombs()-1);
                        gameScene.getGamePage().getPalya()[posY][posX] = 6;
                    } else if (event.getCode()==KeyCode.P && !ifPaused)
                    {
                        gameScene.setStatus(Status.PAUSE);
                        ifPaused=true;
                        gameScene.getGamePage().ManagePause(true);
                    }
                }
                if(gameScene.getStatus()==Status.PAUSE)
                {
                    if(event.getCode()==KeyCode.P && !ifPaused)
                    {
                        gameScene.getGamePage().ManagePause(false);
                        gameScene.setStatus(Status.GAMEPAGE);
                        ifPaused=true;
                    }
                }
                if (gameScene.getStatus()==Status.END)
                {
                    if(event.getCode()==KeyCode.DOWN && gameScene.getEndPage().getCursor().getIndex() == 1)
                    {
                        double tmp = gameScene.getEndPage().getCursor().getCursorModel().getPositionY()
                                + gameScene.getEndPage().getPane().getHeight()/16;
                        gameScene.getEndPage().getCursor().getCursorModel().setPositionY(tmp);
                        gameScene.getEndPage().getCursor().setIndex(gameScene.getEndPage().getCursor().getIndex()+1);
                        gameScene.getEndPage().getCursor().refresh();
                    } else if(event.getCode()==KeyCode.UP && gameScene.getEndPage().getCursor().getIndex() == 2)
                    {
                        double tmp = gameScene.getEndPage().getCursor().getCursorModel().getPositionY()
                                - gameScene.getEndPage().getPane().getHeight()/16;
                        gameScene.getEndPage().getCursor().getCursorModel().setPositionY(tmp);
                        gameScene.getEndPage().getCursor().setIndex(gameScene.getEndPage().getCursor().getIndex()-1);
                        gameScene.getEndPage().getCursor().refresh();
                    } else if (event.getCode() == KeyCode.ENTER)
                    {
                        gameScene.setEntered(true);
                        if (gameScene.getEndPage().getCursor().getIndex() == 1)
                        {
                            logger.info("Back to main Menu");
                            gameScene.getGamePage().getTimer().setTime(0);
                            gameScene.getGamePage().reset();
                            gameScene.setStatus(Status.MAINPAGE);
                            gameScene.setVisible();
                        } else if (gameScene.getEndPage().getCursor().getIndex() == 2)
                        {
                            logger.info("Exit");
                            System.exit(0);
                        }
                    }
                }
            }
        });

        gameScene.getScene().setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            /**
             * This is the method which manages the key release actions.
             *
             * @param event is the chosen {@code KeyEvent}.
             */
            @Override
            public void handle(KeyEvent event)
            {
                if(event.getCode()==KeyCode.P)
                {
                    ifPaused=false;
                }
                if (gameScene.getStatus() == Status.GAMEPAGE)
                {
                    if (event.getCode()== KeyCode.LEFT)
                    {
                        int tmp = player1.getPlayerModel().getMoveDirection()[1];
                        player1.getPlayerModel().getMoveDirection()[1] = 0;
                        player1.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++)
                        {
                            if (player1.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player1.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if (event.getCode()== KeyCode.RIGHT)
                    {
                        int tmp = player1.getPlayerModel().getMoveDirection()[2];
                        player1.getPlayerModel().getMoveDirection()[2] = 0;
                        player1.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++) {
                            if (player1.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player1.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if (event.getCode()== KeyCode.UP)
                    {
                        int tmp = player1.getPlayerModel().getMoveDirection()[3];
                        player1.getPlayerModel().getMoveDirection()[3] = 0;
                        player1.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++)
                        {
                            if (player1.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player1.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if (event.getCode()== KeyCode.DOWN)
                    {
                        int tmp = player1.getPlayerModel().getMoveDirection()[4];
                        player1.getPlayerModel().getMoveDirection()[4] = 0;
                        player1.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++)
                        {
                            if (player1.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player1.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if (event.getCode()== KeyCode.D)
                    {
                        int tmp = player2.getPlayerModel().getMoveDirection()[2];
                        player2.getPlayerModel().getMoveDirection()[2] = 0;
                        player2.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++) {
                            if (player2.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player2.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    }
                    else if(event.getCode()== KeyCode.A)
                    {
                        int tmp = player2.getPlayerModel().getMoveDirection()[1];
                        player2.getPlayerModel().getMoveDirection()[1] = 0;
                        player2.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++)
                        {
                            if (player2.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player2.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if(event.getCode()== KeyCode.W)
                    {
                        int tmp = player2.getPlayerModel().getMoveDirection()[3];
                        player2.getPlayerModel().getMoveDirection()[3] = 0;
                        player2.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++) {
                            if (player2.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player2.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    } else if(event.getCode()== KeyCode.S)
                    {
                        int tmp = player2.getPlayerModel().getMoveDirection()[4];
                        player2.getPlayerModel().getMoveDirection()[4] = 0;
                        player2.getPlayerModel().getMoveDirection()[0]--;
                        for (int i = 1; i < 5; i++)
                        {
                            if (player2.getPlayerModel().getMoveDirection()[i] > tmp)
                            {
                                player2.getPlayerModel().getMoveDirection()[i]--;
                            }
                        }
                    }
                }
            }
        });
    }
}
