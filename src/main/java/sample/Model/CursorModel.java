package sample.Model;

/**
 * This is a class which contains the menu cursors' details.
 */
public class CursorModel
{
    /**
     * This is the cursors' height on the screen ({@code double}).
     */
    private double width=50;
    /**
     * This is the cursors' width on the screen ({@code double}).
     */
    private double height=50;
    /**
     * This is the cursors' X position on the screen ({@code double}).
     */
    private double positionX=200;
    /**
     * This is the cursors' Y position on the screen ({@code double}).
     */
    private double positionY=385;
    /**
     * This is the two cursors' distance from each other.
     */
    private double distance=200;

    /**
     * This is the constructor of the {@code CursorModel} class.
     */
    public CursorModel()
    {
    }

    /**
     * This is getter function.
     *
     * @return the cursors' width.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * This is a setter method of the cursors' width.
     *
     * @param width is the chosen {@code double}.
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * This is getter function.
     *
     * @return the cursors' height.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * This is a setter method of the cursors' height.
     *
     * @param height is the chosen {@code double}.
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * This is getter function.
     *
     * @return the cursors' X Position.
     */
    public double getPositionX()
    {
        return positionX;
    }

    /**
     * This is getter function.
     *
     * @return the cursors' Y Position.
     */
    public double getPositionY()
    {
        return positionY;
    }

    /**
     * This is a setter method of the cursors' Y position.
     *
     * @param positionY is the chosen {@code double}.
     */
    public void setPositionY(double positionY)
    {
        this.positionY = positionY;
    }

    /**
     * This is getter function.
     *
     * @return the cursors' distance.
     */
    public double getDistance()
    {
        return distance;
    }
}
