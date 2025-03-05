import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SpeedPotion extends Actor
{
    private GreenfootSound soundeffect = new GreenfootSound("potionspawn.mp3");
    private GreenfootSound soundeffect2 = new GreenfootSound("potioncollect.mp3");
    
    private int speed = Greenfoot.getRandomNumber(2) + 1;
    
    public SpeedPotion()
    {
        soundeffect.play();
    }
    
    public void act()
    {
        Movement();
        onCollision();
    }
    
    private void Movement()
    {
        int y = getY();
        y += speed;
        setLocation(getX(), y);
    }
    
    private void onCollision()
    {
        if (isTouching(Catcher.class))
        {
            Scoreboard scoreboard = getWorld().getObjects(Scoreboard.class).get(0);
            scoreboard.changeScore(27);
            soundeffect2.play();
            Catcher catcher = getWorld().getObjects(Catcher.class).get(0);
            catcher.collectedPotion();
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
