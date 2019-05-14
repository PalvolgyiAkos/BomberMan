package sample.View.GamePage;

import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class Explosion
{
    private ArrayList<Pane> draw= new ArrayList<>();
    private int lifeTime=60;
    private int counter;

    public Explosion(GamePage gamePage, int index)
    {
        Bomb bomb = gamePage.getBombs().get(index);
        int bombX = (int)(bomb.getBombModel().getPositionX()-30)/50;
        int bombY = (int)(bomb.getBombModel().getPositionY()-40)/50;
        gamePage.getPalya()[bombY][bombX] = 9;
        draw.add(new Pane());
        draw.get(0).setId("explMid");
        draw.get(0).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
        draw.get(0).setLayoutX(bomb.getPane().getLayoutX());
        draw.get(0).setLayoutY(bomb.getPane().getLayoutY());
        counter=1;
        for (int i=0; i< bomb.getBombModel().getPower(); i++)//right
        {
            if (gamePage.getPalya()[bombY][bombX+i+1] == 0)
            {
                break;
            } else if (gamePage.getTiles()[bombY][bombX + i + 1].getPane().getId().equals("dwall"))
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX() + 50 * (i + 1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                if (gamePage.getPalya()[bombY][bombX+i+1] == 1)
                {
                    gamePage.getTiles()[bombY][bombX+i+1].getPane().setId("powerUp_Speed");
                    gamePage.getPalya()[bombY][bombX+i+1] = 7;
                } else if (gamePage.getPalya()[bombY][bombX+i+1] == 2)
                {
                    gamePage.getTiles()[bombY][bombX+i+1].getPane().setId("powerUp_FirePower");
                    gamePage.getPalya()[bombY][bombX+i+1] = 7;
                } else if (gamePage.getPalya()[bombY][bombX+i+1] == 3)
                {
                    gamePage.getTiles()[bombY][bombX+i+1].getPane().setId("powerUp_Bomb");
                    gamePage.getPalya()[bombY][bombX+i+1] = 7;
                } else
                {
                    gamePage.getTiles()[bombY][bombX + i + 1].getPane().setId("field");
                    gamePage.getPalya()[bombY][bombX + i + 1] = 7;
                    draw.get(counter).setId("destroyedWall");
                }
                counter++;
                break;
            } else if ((gamePage.getTiles()[bombY][bombX + i + 1].getPane().getId().equals("powerUp_Speed")
                    || gamePage.getTiles()[bombY][bombX + i + 1].getPane().getId().equals("powerUp_FirePower")
                    || gamePage.getTiles()[bombY][bombX + i + 1].getPane().getId().equals("powerUp_Bomb"))
                    && gamePage.getPalya()[bombY][bombX+i+1] != 7)
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setId(gamePage.getTiles()[bombY][bombX+i+1].getPane().getId() + "_Destroyed");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX() + 50 * (i + 1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                counter++;
                gamePage.getTiles()[bombY][bombX + i + 1].getPane().setId("field");
                gamePage.getPalya()[bombY][bombX + i + 1] = 7;
                break;
            } else if (gamePage.getPalya()[bombY][bombX+i+1] == 9)
            {
                break;
            } else if (gamePage.getPalya()[bombY][bombX+i+1] == 6)
            {
                for (int k = 0; k < gamePage.getBombs().size(); k++)
                {
                    if ((gamePage.getBombs().get(k).getBombModel().getPositionX()-30)/50 == bombX+i+1
                            && (gamePage.getBombs().get(k).getBombModel().getPositionY()-40)/50 == bombY)
                    {
                        gamePage.getBombs().get(k).getBombModel().setLifeTime(0);
                        break;
                    }
                }
                break;
            }
            if(i==bomb.getBombModel().getPower()-1)
            {
                draw.add(new Pane());
                draw.get(counter).setId("explEnd");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX()+50*(i+1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                gamePage.getPalya()[bombY][bombX+i+1] = 7;
                counter++;
            }
            else
            {
                draw.add(new Pane());
                draw.get(counter).setId("explLine");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX()+50*(i+1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                gamePage.getPalya()[bombY][bombX+i+1] = 7;
                counter++;
            }
        }
        for (int i=0; i< bomb.getBombModel().getPower(); i++)//left
        {
            if (gamePage.getPalya()[bombY][bombX-i-1] == 0
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("destroyedWall")
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_Speed_Destroyed")
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_FirePower_Destroyed")
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_Bomb_Destroyed"))
            {
                break;
            } else if (gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("dwall"))
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX() - 50 * (i + 1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                if (gamePage.getPalya()[bombY][bombX-i-1] == 1)
                {
                    gamePage.getTiles()[bombY][bombX-i-1].getPane().setId("powerUp_Speed");
                    gamePage.getPalya()[bombY][bombX-i-1] = 7;
                } else if (gamePage.getPalya()[bombY][bombX-i-1] == 2)
                {
                    gamePage.getTiles()[bombY][bombX-i-1].getPane().setId("powerUp_FirePower");
                    gamePage.getPalya()[bombY][bombX-i-1] = 7;
                } else if (gamePage.getPalya()[bombY][bombX-i-1] == 3)
                {
                    gamePage.getTiles()[bombY][bombX-i-1].getPane().setId("powerUp_Bomb");
                    gamePage.getPalya()[bombY][bombX-i-1] = 7;
                } else
                {
                    gamePage.getTiles()[bombY][bombX - i - 1].getPane().setId("field");
                    gamePage.getPalya()[bombY][bombX - i - 1] = 7;
                    draw.get(counter).setId("destroyedWall");
                }
                counter++;
                break;
            } else if ((gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_Speed")
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_FirePower")
                    || gamePage.getTiles()[bombY][bombX - i - 1].getPane().getId().equals("powerUp_Bomb"))
                    && gamePage.getPalya()[bombY][bombX-i-1] != 7)
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                gamePage.getTiles()[bombY][bombX-i-1].getPane().setId(
                        gamePage.getTiles()[bombY][bombX-i-1].getPane().getId() + "_Destroyed");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX() - 50 * (i + 1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                counter++;
                gamePage.getTiles()[bombY][bombX - i - 1].getPane().setId("field");
                gamePage.getPalya()[bombY][bombX - i - 1] = 7;
                break;
            } else if (gamePage.getPalya()[bombY][bombX-i-1] == 9)
            {
                break;
            } else if (gamePage.getPalya()[bombY][bombX-i-1] == 6)
            {
                for (int k = 0; k < gamePage.getBombs().size(); k++)
                {
                    if ((gamePage.getBombs().get(k).getBombModel().getPositionX()-30)/50 == bombX-i-1
                            && (gamePage.getBombs().get(k).getBombModel().getPositionY()-40)/50 == bombY)
                    {
                        gamePage.getBombs().get(k).getBombModel().setLifeTime(0);
                        break;
                    }
                }
                break;
            }
            if(i==bomb.getBombModel().getPower()-1)
            {
                draw.add(new Pane());
                draw.get(counter).setId("explEnd2");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX()-50*(i+1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                gamePage.getPalya()[bombY][bombX-i-1] = 7;
                counter++;
            } else
            {
                draw.add(new Pane());
                draw.get(counter).setId("explLine2");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX()-50*(i+1));
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY());
                gamePage.getPalya()[bombY][bombX-i-1] = 7;
                counter++;
            }
        }
        for (int i=0; i< bomb.getBombModel().getPower(); i++) //down
        {
            if (gamePage.getPalya()[bombY+i+1][bombX] == 0)
            {
                break;
            } else if (gamePage.getTiles()[bombY + i + 1][bombX].getPane().getId().equals("dwall"))
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY() + 50 * (i + 1));
                if (gamePage.getPalya()[bombY+i+1][bombX] == 1) {
                    gamePage.getTiles()[bombY+i+1][bombX].getPane().setId("powerUp_Speed");
                    gamePage.getPalya()[bombY+i+1][bombX] = 7;
                } else if (gamePage.getPalya()[bombY+i+1][bombX] == 2)
                {
                    gamePage.getTiles()[bombY+i+1][bombX].getPane().setId("powerUp_FirePower");
                    gamePage.getPalya()[bombY+i+1][bombX] = 7;
                } else if (gamePage.getPalya()[bombY+i+1][bombX] == 3)
                {
                    gamePage.getTiles()[bombY+i+1][bombX].getPane().setId("powerUp_Bomb");
                    gamePage.getPalya()[bombY+i+1][bombX] = 7;
                } else
                {
                    gamePage.getTiles()[bombY+i+1][bombX].getPane().setId("field");
                    gamePage.getPalya()[bombY+i+1][bombX] = 7;
                    draw.get(counter).setId("destroyedWall");
                }
                counter++;
                break;
            } else if ((gamePage.getTiles()[bombY + i + 1][bombX].getPane().getId().equals("powerUp_Speed")
                    || gamePage.getTiles()[bombY + i + 1][bombX].getPane().getId().equals("powerUp_FirePower")
                    || gamePage.getTiles()[bombY + i + 1][bombX].getPane().getId().equals("powerUp_Bomb"))
                    && gamePage.getPalya()[bombY+i+1][bombX] != 7) {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setId(gamePage.getTiles()[bombY+i+1][bombX].getPane().getId() + "_Destroyed");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY() + 50 * (i + 1));
                counter++;
                gamePage.getTiles()[bombY+i+1][bombX].getPane().setId("field");
                gamePage.getPalya()[bombY+i+1][bombX] = 7;
                break;
            } else if (gamePage.getPalya()[bombY+i+1][bombX] == 9)
            {
                break;
            } else if (gamePage.getPalya()[bombY+i+1][bombX] == 6)
            {
                for (int k = 0; k < gamePage.getBombs().size(); k++)
                {
                    if ((gamePage.getBombs().get(k).getBombModel().getPositionX()-30)/50 == bombX
                            && (gamePage.getBombs().get(k).getBombModel().getPositionY()-40)/50 == bombY+i+1)
                    {
                        gamePage.getBombs().get(k).getBombModel().setLifeTime(0);
                        break;
                    }
                }
                break;
            }
            if(i==bomb.getBombModel().getPower()-1)
            {
                draw.add(new Pane());
                draw.get(counter).setId("explEnd3");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY()+50*(i+1));
                gamePage.getPalya()[bombY+i+1][bombX] = 7;
                counter++;
            }
            else
            {
                draw.add(new Pane());
                draw.get(counter).setId("explLine3");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY()+50*(i+1));
                gamePage.getPalya()[bombY+i+1][bombX] = 7;
                counter++;
            }
        }
        for (int i=0; i< bomb.getBombModel().getPower(); i++) //up
        {
            if (gamePage.getPalya()[bombY-i-1][bombX] == 0)
            {
                break;
            } else if (gamePage.getTiles()[bombY - i - 1][bombX].getPane().getId().equals("dwall"))
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY() - 50 * (i + 1));
                if (gamePage.getPalya()[bombY-i-1][bombX] == 1)
                {
                    gamePage.getTiles()[bombY-i-1][bombX].getPane().setId("powerUp_Speed");
                    gamePage.getPalya()[bombY-i-1][bombX] = 7;
                } else if (gamePage.getPalya()[bombY-i-1][bombX] == 2)
                {
                    gamePage.getTiles()[bombY-i-1][bombX].getPane().setId("powerUp_FirePower");
                    gamePage.getPalya()[bombY-i-1][bombX] = 7;
                } else if (gamePage.getPalya()[bombY-i-1][bombX] == 3)
                {
                    gamePage.getTiles()[bombY-i-1][bombX].getPane().setId("powerUp_Bomb");
                    gamePage.getPalya()[bombY-i-1][bombX] = 7;
                } else
                {
                    gamePage.getTiles()[bombY-i-1][bombX].getPane().setId("field");
                    gamePage.getPalya()[bombY-i-1][bombX] = 7;
                    draw.get(counter).setId("destroyedWall");
                }
                counter++;
                break;
            } else if ((gamePage.getTiles()[bombY - i - 1][bombX].getPane().getId().equals("powerUp_Speed")
                    || gamePage.getTiles()[bombY - i - 1][bombX].getPane().getId().equals("powerUp_FirePower")
                    || gamePage.getTiles()[bombY - i - 1][bombX].getPane().getId().equals("powerUp_Bomb"))
                    && gamePage.getPalya()[bombY-i-1][bombX] != 7)
            {
                bomb.getPlayer().getPlayerModel().incScore(1);
                draw.add(new Pane());
                draw.get(counter).setId(gamePage.getTiles()[bombY-i-1][bombX].getPane().getId() + "_Destroyed");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY() - 50 * (i + 1));
                counter++;
                gamePage.getTiles()[bombY-i-1][bombX].getPane().setId("field");
                gamePage.getPalya()[bombY-i-1][bombX] = 7;
                break;
            } else if (gamePage.getPalya()[bombY-i-1][bombX] == 9)
            {
                break;
            } else if (gamePage.getPalya()[bombY-i-1][bombX] == 6)
            {
                for (int k = 0; k < gamePage.getBombs().size(); k++)
                {
                    if ((gamePage.getBombs().get(k).getBombModel().getPositionX()-30)/50 == bombX
                            && (gamePage.getBombs().get(k).getBombModel().getPositionY()-40)/50 == bombY-i-1)
                    {
                        gamePage.getBombs().get(k).getBombModel().setLifeTime(0);
                        break;
                    }
                }
                break;
            }
            if(i==bomb.getBombModel().getPower()-1)
            {
                draw.add(new Pane());
                draw.get(counter).setId("explEnd4");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY()-50*(i+1));
                gamePage.getPalya()[bombY-i-1][bombX] = 7;
                counter++;
            }
            else
            {
                draw.add(new Pane());
                draw.get(counter).setId("explLine4");
                draw.get(counter).setPrefSize(bomb.getPane().getWidth(), bomb.getPane().getHeight());
                draw.get(counter).setLayoutX(bomb.getPane().getLayoutX());
                draw.get(counter).setLayoutY(bomb.getPane().getLayoutY()-50*(i+1));
                gamePage.getPalya()[bombY-i-1][bombX] = 7;
                counter++;
            }
        }
    }

    public ArrayList<Pane> getDraw()
    {
        return draw;
    }

    public int getLifeTime()
    {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime)
    {
        this.lifeTime = lifeTime;
    }
}
