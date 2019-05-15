package sample.Model;

/**
 * This is the class which contains the Bomb's details.
 */
public class BombModel
{
    /**
     * This is the bomb's height on the screen ({@code double}).
     */
    private double height=50;
    /**
     * This is the bomb's width on the screen ({@codde double}).
     */
    private double width=50;
    /**
     * This is the bomb's X position on the screen ({@code double}).
     */
    private double positionX;
    /**
     * This is the bomb's Y position on the screen ({@code double}).
     */
    private double positionY;
    /**
     * This is the bombs lifetime ({@code int}).
     */
    private int lifeTime = 240;
    /**
     * This is the power of the bomb ({@code int}).
     */
    private int power;

    /**
     * This is the constructor of the {@code BombModel} class.
     *
     * @param positionX is the X position of the bomb on the screen.
     * @param positionY is the Y position of the bomb on the screen.
     * @param power is the power of the bomb.
     */
    public BombModel(double positionX, double positionY, int power)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's height.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * This is a setter method the the bomb's height.
     *
     * @param height is the chosen {@code double}.
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's height.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * This is a setter method the the bomb's width.
     *
     * @param width is the chosen {@code double}.
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's X position.
     */
    public double getPositionX()
    {
        return positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's Y position.
     */
    public double getPositionY()
    {
        return positionY;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's lifetime.
     */
    public int getLifeTime()
    {
        return lifeTime;
    }

    /**
     * This is a setter method the the bomb's lifetime.
     *
     * @param lifeTime is the chosen {@code int}.
     */
    public void setLifeTime(int lifeTime)
    {
        this.lifeTime = lifeTime;
    }

    /**
     * This is a getter function.
     *
     * @return the bomb's power.
     */
    public int getPower()
    {
        return power;
    }
}
