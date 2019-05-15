package sample.Model;

/**
 * This is a class which contains the text element's details.
 */
public class TextModel {
    /**
     * This is the text's width.
     */
    private int width=600;
    /**
     * This is the text's height.
     */
    private int height=150;
    /**
     * This is the text's X position.
     */
    private double positionX=50;
    /**
     * This is the text's Y position.
     */
    private double positionY=100;

    /**
     * This is the constructor of the {@code TextModel} class.
     */
    public TextModel()
    {
    }

    /**
     * This is a getter function.
     *
     * @return the text's X position.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * This is a setter method of the text's width.
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
     * @return the text's X position.
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * This is a setter method of text's height.
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
     * @return the text's X position.
     */
    public double getPositionX()
    {
        return positionX;
    }

    /**
     * This is a setter of the text's X position.
     *
     * @param positionX is the chosen {@code double}
     */
    public void setPositionX(double positionX)
    {
        this.positionX = positionX;
    }

    /**
     * This is a getter function.
     *
     * @return the tile's X position.
     */
    public double getPositionY()
    {
        return positionY;
    }

    /**
     * This is a setter of the text's Y position.
     *
     * @param positionY is the chosen {@code double}
     */
    public void setPositionY(double positionY)
    {
        this.positionY = positionY;
    }
}
