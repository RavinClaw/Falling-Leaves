import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class StartOfGameWorld extends World
{   
    public StartOfGameWorld()
    {
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        StartButton startButton = new StartButton();
        addObject(startButton,310,341);
        FallingLeavesText fallingLeavesText = new FallingLeavesText();
        addObject(fallingLeavesText,305,55);
    }
}
