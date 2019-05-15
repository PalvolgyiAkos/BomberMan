package sample.Model;

import sample.View.GamePage.GamePage;
import sample.View.GamePage.Tile;

/**
 * This is a class which contains the player's details.
 */
public class PlayerModel
{
    /**
     * This is the player's name.
     */
    private String name;
    /**
     * This is the player's width on the screen.
     */
    private double width=50;
    /**
     * This is the player's height on the screen.
     */
    private double height=50;
    /**
     * This is the X position of the player.
     */
    private double positionX;
    /**
     * This is the Y position of the player.
     */
    private double positionY;
    /**
     * This is the movement speed of the player.
     */
    private double movementSpeed=2;
    /**
     * This is a counter that indicates the placeable by the player.
     */
    private int availableBombs = 1;
    /**
     * This is the power of the bombs placed by the player.
     */
    private int bombPower = 2;
    /**
     * This array contains the given move directions in order.
     */
    private int[] moveDirection = new int[5];
    /**
     * This array contains the position of the recently placed bomb ((-1, -1) if no bomb placed).
     */
    private int[] placedBomb = new int[2];
    /**
     * This is the player's score.
     */
    private int score = 0;

    /**
     * This is the constructor of the {@code PlayerModel} class.
     *
     * @param positionX is the player's starter X position.
     * @param positionY is the player's starter Y position.
     */
    public PlayerModel(double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.moveDirection[0] = 0;
        this.placedBomb[0] = -1;
        this.placedBomb[1] = -1;
    }

    /**
     * This method moves the player on the scene.
     *
     * @param gamePage is the page where the player is located.
     */
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

    /**
     * This is a method is refreshes the recently {@code int[] placedBomb} values.
     *
     * @param posY is the players current position in the game field array.
     * @param posX is the players current position in the game field array.
     */
    public void refreshPlacedBomb(int posY, int posX)
    {
        if ((posY != placedBomb[0]) || (posX != placedBomb[1]))
        {
            placedBomb[0] = -1;
            placedBomb[1] = -1;
        }
    }

    /**
     * This is a function which says if the player is on a recently placed bomb or not.
     *
     * @return true if on a placed bomb, false if not.
     */
    public boolean onPlacedBomb()
    {
        return (positionX - (placedBomb[1] * 50 + 30) < 40) && (positionY - (placedBomb[0] * 50 + 40) < 40);
    }

    /**
     * This method will manages what will happen if a player is on a tile which contains a power up.
     *
     * @param tiles is an array of a current state of the game field.
     * @param posX is the players X position on the game field array.
     * @param posY is the players Y position on the game field array.
     */
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

    /**
     * This is a method which increases the player's speed.
     */
    public void speedUp()
    {
        this.movementSpeed+=0.5;
    }

    /**
     * This is a method which increases the bomb's power placed by this player.
     */
    public void powerUp()
    {
        this.bombPower++;
    }

    /**
     * This is a method which increases the placeable bombs' number for the player.
     */
    public void addBomb()
    {
        this.availableBombs++;
    }

    /**
     * This method will increase the score of the player.
     *
     * @param score is the chosen {@code int}.
     */
    public void incScore(int score)
    {
        this.score += score;
    }

    /**
     * This is a getter function.
     *
     * @return the player's score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * This is a getter function.
     *
     * @return the number of placeable bombs by the player.
     */
    public int getAvailableBombs()
    {
        return availableBombs;
    }

    /**
     * This is a setter method of the number of the placeable bombs by the player.
     *
     * @param availableBombs is the chosen {@code int}
     */
    public void setAvailableBombs(int availableBombs)
    {
        this.availableBombs = availableBombs;
    }

    /**
     * This is a getter function.
     *
     * @return the power of the bomb placeable by the player.
     */
    public int getBombPower()
    {
        return bombPower;
    }

    /**
     * This is a getter function.
     *
     * @return the player's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This is a setter method of the player's name.
     *
     * @param name is the chosen {@code String}
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This is a getter function.
     *
     * @return the player's width.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * This is a setter method of player's width.
     *
     * @param width is the chosen {@code double}
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * This is a getter function.
     *
     * @return the player's height.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * This is a setter method of player's height.
     *
     * @param height is the chosen {@code double}
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * This is a getter function.
     *
     * @return the player's X position.
     */
    public double getPositionX()
    {
        return positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the player's Y position.
     */
    public double getPositionY()
    {
        return positionY;
    }

    /**
     * This is a getter function.
     *
     * @return the player's movement direction in {@code int[]}.
     */
    public int[] getMoveDirection()
    {
        return moveDirection;
    }

    /**
     * This is a setter method of position of the bomb placed recently by the player.
     *
     * @param positionX is the chosen {@code int}
     * @param positionY is the chosen {@code int}
     */
    public void setPlacedBomb(int positionY, int positionX)
    {
        this.placedBomb[0] = positionY;
        this.placedBomb[1] = positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the position of the recently placed bomb by the player.
     */
    public int[] getPlacedBomb() {
        return placedBomb;
    }

    /**
     * This is a getter function.
     *
     * @return the player's movement speed.
     */
    public double getMovementSpeed() {
        return movementSpeed;
    }
}