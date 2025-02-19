import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RetryButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RetryButton extends Actor
{
    private GreenfootSound endloop = new GreenfootSound("endloop.mp3");

    public void act()
    {
        if (!endloop.isPlaying())
        {
            endloop.play();
        }
        
        if (Greenfoot.mousePressed(this))
        {
            endloop.stop();
            AutumnWorld world = new AutumnWorld();
            Greenfoot.setWorld(world); 
        }
    }
}
