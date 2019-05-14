package sample.Model;

public class TextModel {
    private int width=600;
    private int height=150;
    private double positionX=50;
    private double positionY=100;

    public TextModel()
    {
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public double getPositionX()
    {
        return positionX;
    }

    public void setPositionX(double positionX)
    {
        this.positionX = positionX;
    }

    public double getPositionY()
    {
        return positionY;
    }

    public void setPositionY(double positionY)
    {
        this.positionY = positionY;
    }
}
