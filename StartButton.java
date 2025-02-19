import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    public static GreenfootSound music = new GreenfootSound("startloop.mp3");

    public void act()
    {
        if(!music.isPlaying())
        {
            music.play();
        }
        
        if (Greenfoot.mousePressed(this))
        {
            music.stop();
            AutumnWorld world = new AutumnWorld();
            Greenfoot.setWorld(world);
        }
    }
}
