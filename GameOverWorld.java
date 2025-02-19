import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOverWorld extends World
{
    public GameOverWorld()
    {
        super(750, 500, 1, true);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RetryButton retryButton = new RetryButton();
        addObject(retryButton,370,320);
        GameOverText gameOverText = new GameOverText();
        addObject(gameOverText,340,100);
    }
}
