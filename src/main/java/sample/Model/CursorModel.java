package sample.Model;

public class CursorModel
{
    private double width=50;
    private double height=50;
    private double positionX=200;
    private double positionY=385;
    private double distance=200;

    public CursorModel()
    {
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

    public void setPositionY(double positionY)
    {
        this.positionY = positionY;
    }

    public double getDistance()
    {
        return distance;
    }
}
