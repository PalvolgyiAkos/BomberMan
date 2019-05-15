package sample.Model;

/**
 * This is the class which contains the Tile's details.
 */
public class TileModel
{
    /**
     * This is the tile's width on the screen ({@code double}).
     */
    private double width=50;
    /**
     * This is the tile's height on the screen ({@code double}).
     */
    private double height=50;
    /**
     * This is the tile's X position on the screen ({@code double}).
     */
    private double positionX;
    /**
     * This is the tile's Y position on the screen ({@code double}).
     */
    private double positionY;

    /**
     * This is the constructor of the {@code TileModel} class.
     *
     * @param positionX is the X position of the bomb on the screen.
     * @param positionY is the Y position of the bomb on the screen.
     */
    public TileModel(double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * This is a getter function.
     *
     * @return the tile's width.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * This is a getter function.
     *
     * @return the tile's height.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * This is a getter function.
     *
     * @return the tile's X position.
     */
    public double getPositionX()
    {
        return positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the tile's Y position.
     */
    public double getPositionY()
    {
        return positionY;
    }
}
