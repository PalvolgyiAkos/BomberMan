package sample.Model;

public class BombModel
{
    private double height=50;
    private double width=50;
    private double positionX;
    private double positionY;
    private int lifeTime = 240;
    private int power;

    /**
     *
     * @param positionX
     * @param positionY
     * @param power
     */
    public BombModel(double positionX, double positionY, int power)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getPositionX()
    {
        return positionX;
    }

    public double getPositionY()
    {
        return positionY;
    }

    public int getLifeTime()
    {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime)
    {
        this.lifeTime = lifeTime;
    }

    public int getPower()
    {
        return power;
    }
}
