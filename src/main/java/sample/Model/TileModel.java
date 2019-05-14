package sample.Model;

public class TileModel
{
    private double width=50;
    private double height=50;
    private double positionX;
    private double positionY;

    public TileModel(double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public double getPositionX()
    {
        return positionX;
    }

    public double getPositionY()
    {
        return positionY;
    }
}
