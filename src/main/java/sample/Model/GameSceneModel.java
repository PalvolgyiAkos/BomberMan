package sample.Model;

/**
 * This is a class which contains the scene's details.
 */
public class GameSceneModel
{
    /**
     * This is the scene's width.
     */
    private int width = 700;
    /**
     * This is the scene's height.
     */
    private int height= 700;

    /**
     * This is the constructor of the {@code GameSceneModel} class.
     */
    public GameSceneModel()
    {
    }

    /**
     * This is a getter function.
     *
     * @return the scene's width.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * This is a setter method of the scene's width.
     *
     * @param width is the chosen {@code int}.
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * This is a getter function.
     *
     * @return the scene's height.
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * This is a setter method of the scene's height.
     *
     * @param height is the chosen {@code int}.
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
}
