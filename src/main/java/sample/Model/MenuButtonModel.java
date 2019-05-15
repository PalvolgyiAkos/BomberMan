package sample.Model;

/**
 * This is a class which contains the menubutton's details.
 */
public class MenuButtonModel
{
    /**
     * This is the menubutton's width.
     */
    private int width=150;
    /**
     * This is the menubutton's height.
     */
    private int height=50;
    /**
     * This is the menubutton's X position on screen.
     */
    private int positionX=275;
    /**
     * This is the menubutton's Y position on screen.
     */
    private int PositionY=600;

    /**
     * This is the constructor of the {@code MenuButtonModel} class.
     */
    public MenuButtonModel()
    {
    }

    /**
     * This is a getter function.
     *
     * @return the menubutton's width.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * This is a setter method of the menubutton's width.
     *
     * @param width is the chosen {@code int}
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * This is a getter function.
     *
     * @return the menubutton's height.
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * This is a setter method of the menubutton's height.
     *
     * @param height is the chosen {@code int}
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * This is a getter function.
     *
     * @return the menubutton's X position.
     */
    public int getPositionX()
    {
        return positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the menubutton's Y position.
     */
    public int getPositionY()
    {
        return PositionY;
    }

    /**
     * This is a setter method of the menubutton's Y position.
     *
     * @param positionY is the chosen {@code int}
     */
    public void setPositionY(int positionY)
    {
        PositionY = positionY;
    }
}
