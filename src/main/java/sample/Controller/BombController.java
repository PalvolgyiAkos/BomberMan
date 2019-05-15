package sample.Controller;

import javafx.animation.AnimationTimer;
import sample.Status;
import sample.View.GamePage.Bomb;
import sample.View.GamePage.Explosion;
import sample.View.GameScene;
import java.util.ArrayList;

/**
 * This is the class which manages the bombs.
 */
public class BombController
{
    /**
     * This is an ArrayList which contains the bombs.
     */
    private ArrayList<Bomb> bomb;
    /**
     * This is an ArrayList which contains the explosions.
     */
    private ArrayList<Explosion> explosions;

    /**
     * This is the constructor which controlling the bombs.
     *
     * @param gameScene is the chosen {@code GameScene}.
     */
    public BombController(GameScene gameScene)
    {
        this.bomb = gameScene.getGamePage().getBombs();
        this.explosions= gameScene.getGamePage().getExplosions();

        new AnimationTimer()
        {
            /**
             * This is the method which controlling the bombs on the GamePage.
             *
             * @param now is the chosen {@code long}.
             */
            @Override
            public void handle(long now)
            {
                if(gameScene.getStatus().equals(Status.GAMEPAGE))
                {
                    for(int i=0; i<gameScene.getGamePage().getBombs().size(); i++)
                    {
                        if(gameScene.getGamePage().getBombs().get(i).getBombModel().getLifeTime()<=0)
                        {
                            gameScene.getGamePage().getBombs().get(i).getPlayer().getPlayerModel()
                                    .setAvailableBombs(gameScene.getGamePage().getBombs().get(i).getPlayer().getPlayerModel().getAvailableBombs()+1);
                            explosions.add(new Explosion(gameScene.getGamePage(), i));
                            bomb.get(i).getPane().setVisible(false);
                            bomb.remove(i);

                            for (int j=0; j< explosions.get(explosions.size()-1).getDraw().size() ;j++)
                            {
                                gameScene.getGamePage().getPage().getChildren().add(explosions.get(explosions.size()-1).getDraw().get(j));
                            }
                        }
                        else
                        {
                            bomb.get(i).getBombModel().setLifeTime(bomb.get(i).getBombModel().getLifeTime()-1);
                        }
                    }
                    for (int i=0; i<explosions.size(); i++)
                    {
                        if (explosions.get(i).getLifeTime()==0)
                        {
                            for (int j=0; j<explosions.get(i).getDraw().size();j++)
                            {
                                int boomX = (int)(explosions.get(i).getDraw().get(j).getLayoutX()-30)/50;
                                int boomY = (int)(explosions.get(i).getDraw().get(j).getLayoutY()-40)/50;
                                gameScene.getGamePage().getPalya()[boomY][boomX] = 8;
                                explosions.get(i).getDraw().get(j).setVisible(false);
                                gameScene.getGamePage().getPage().getChildren().remove(explosions.get(i).getDraw().get(j));
                            }
                            explosions.remove(i);
                        }
                        else
                        {
                            explosions.get(i).setLifeTime(explosions.get(i).getLifeTime()-1);
                        }
                    }
                }
            }
        }.start();
    }
}
