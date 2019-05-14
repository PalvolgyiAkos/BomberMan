package sample.Model;

import sample.View.GamePage.GamePage;
import sample.View.GamePage.Tile;

public class PlayerModel
{
    private String name;
    private double width=50;
    private double height=50;
    private double positionX;
    private double positionY;
    private double movementSpeed=2;
    private int availableBombs = 1;
    private int bombPower = 2;
    private int[] moveDirection = new int[5];
    private int[] placedBomb = new int[2];
    private int score = 0;

    public PlayerModel(double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.moveDirection[0] = 0;
        this.placedBomb[0] = -1;
        this.placedBomb[1] = -1;
    }

    public void move(GamePage gamePage)
    {
        int first = 0;
        for (int i = 1; i < 5; i ++)
        {
            if (moveDirection[i] == moveDirection[0] && moveDirection[0] > 0)
            {
                first = i;
                break;
            }
        }
        int playerPosX_left = (int) Math.ceil((positionX-30) / 50);
        int playerPosY_up = (int) Math.ceil((positionY-40) / 50);
        int playerPosX_right = (int) Math.floor((positionX-30) / 50);
        int playerPosY_down = (int) Math.floor((positionY-40) / 50);
        int playerPosX = (int) Math.round((positionX-30) / 50);
        int playerPosY = (int) Math.round((positionY-40) / 50);
        for (int i = 0; i < movementSpeed; i++)
        {
            double helperX;
            if ((positionX-30) % 50 == 0)
            {
                helperX = 0;
            } else if ((positionX-30) % 50 > 25)
            {
                helperX = 0.5;
            } else
            {
                helperX = -0.5;
            }
            double helperY;
            if ((positionY-40) % 50 == 0)
            {
                helperY = 0;
            } else if ((positionY-40) % 50 > 25)
            {
                helperY = 0.5;
            } else
            {
                helperY = -0.5;
            }
            if (first == 4 && !gamePage.getTiles()[playerPosY_down+1][playerPosX].getPane().getId().equals("wall")
                    && !gamePage.getTiles()[playerPosY_down+1][playerPosX].getPane().getId().equals("dwall")
                    && (gamePage.getPalya()[playerPosY_down+1][playerPosX] != 6 || onPlacedBomb()))
            { // DOWN
                if (placedBomb[0] != -1)
                {
                    refreshPlacedBomb(playerPosY, playerPosX);
                }
                positionY += 0.5;
                positionX += helperX;
            }
            if (first == 3 && !gamePage.getTiles()[playerPosY_up-1][playerPosX].getPane().getId().equals("wall")
                    && !gamePage.getTiles()[playerPosY_up-1][playerPosX].getPane().getId().equals("dwall")
                    && (gamePage.getPalya()[playerPosY_up-1][playerPosX] != 6 || onPlacedBomb()))
            { // UP
                if (placedBomb[0] != -1)
                {
                    refreshPlacedBomb(playerPosY, playerPosX);
                }
                positionY -= 0.5;
                positionX += helperX;
            }
            if (first == 2 && !gamePage.getTiles()[playerPosY][playerPosX_right+1].getPane().getId().equals("wall")
                    && !gamePage.getTiles()[playerPosY][playerPosX_right+1].getPane().getId().equals("dwall")
                    && (gamePage.getPalya()[playerPosY][playerPosX_right+1] != 6 || onPlacedBomb()))
            { // RIGHT
                if (placedBomb[0] != -1)
                {
                    refreshPlacedBomb(playerPosY, playerPosX);
                }
                positionX += 0.5;
                positionY += helperY;
            }
            if (first == 1 && !gamePage.getTiles()[playerPosY][playerPosX_left-1].getPane().getId().equals("wall")
                    && !gamePage.getTiles()[playerPosY][playerPosX_left-1].getPane().getId().equals("dwall")
                    && (gamePage.getPalya()[playerPosY][playerPosX_left-1] != 6 || onPlacedBomb()))
            { // LEFT
                if (placedBomb[0] != -1)
                {
                    refreshPlacedBomb(playerPosY, playerPosX);
                }
                positionX -= 0.5;
                positionY += helperY;
            }
            checkPowerUp(gamePage.getTiles(), playerPosX, playerPosY);
        }
    }

    private void refreshPlacedBomb(int posY, int posX)
    {
        if ((posY != placedBomb[0]) || (posX != placedBomb[1]))
        {
            placedBomb[0] = -1;
            placedBomb[1] = -1;
        }
    }

    private boolean onPlacedBomb()
    {
        return (positionX - (placedBomb[1] * 50 + 30) < 40) && (positionY - (placedBomb[0] * 50 + 40) < 40);
    }

    private void checkPowerUp(Tile[][] tiles, int posX, int posY)
    {
        switch (tiles[posY][posX].getPane().getId())
        {
            case "powerUp_Speed":
                speedUp();
                incScore(10);
                tiles[posY][posX].getPane().setId("field");
                break;
            case "powerUp_Bomb":
                addBomb();
                incScore(10);
                tiles[posY][posX].getPane().setId("field");
                break;
            case "powerUp_FirePower":
                powerUp();
                incScore(10);
                tiles[posY][posX].getPane().setId("field");
                break;
        }
    }

    private void speedUp()
    {
        this.movementSpeed+=0.5;
    }

    private void powerUp()
    {
        this.bombPower++;
    }

    private void addBomb()
    {
        this.availableBombs++;
    }

    public void incScore(int score)
    {
        this.score += score;
    }

    public int getScore()
    {
        return score;
    }

    public int getAvailableBombs()
    {
        return availableBombs;
    }

    public void setAvailableBombs(int availableBombs)
    {
        this.availableBombs = availableBombs;
    }

    public int getBombPower()
    {
        return bombPower;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getPositionX()
    {
        return positionX;
    }

    public double getPositionY()
    {
        return positionY;
    }

    public int[] getMoveDirection()
    {
        return moveDirection;
    }

    public void setPlacedBomb(int positionY, int positionX)
    {
        this.placedBomb[0] = positionY;
        this.placedBomb[1] = positionX;
    }
}