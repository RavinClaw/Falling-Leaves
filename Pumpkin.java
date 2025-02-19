import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pumpkin extends Actor
{
    private int speed = Greenfoot.getRandomNumber(5) + 1;
    private GreenfootSound soundeffect = new GreenfootSound("pumpkincollect.mp3");
    
    public void act()
    {
        Movement();
        onCollision();
    }
    
    private void Movement()
    {
        setLocation(getX(), getY() + speed);
    }
    
    private void onCollision()
    {
        if (isTouching(Catcher.class))
        {
            Scoreboard scoreboard = getWorld().getObjects(Scoreboard.class).get(0);
            scoreboard.changeScore(5);
            Lives lives = getWorld().getObjects(Lives.class).get(0);
            lives.addLives(1);
            soundeffect.play();
            getWorld().removeObject(this);
            return;
        }
        if (getY() >= getWorld().getHeight() - 5)
        {
            getWorld().removeObject(this);
            return;
        }
        if (getX() <= -5)
        {
            setLocation(750, getY());
            return;
        }
        if (getX() >= 755)
        {
            setLocation(0, getY());
            return;
        }
    }
    
    public void changeDirection( int direction )
    {
        int x = getX();
        x += direction;
        setLocation(x, getY());
    }
}
