     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Catcher  extends Actor
{
    private static int moveSpeed = 7;
    
    /**
     * Act - do whatever the Catcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Movement();
        BorderControl();
    }
    
    private void BorderControl()
    {
        if (getX() > 755) {
            setLocation(0, getY());
        }
        if (getX() < -5) {
            setLocation(750, getY());
        }
    }
    
    private void Movement()
    {
        int x = getX();
        
        if (Greenfoot.isKeyDown("A"))
        {
            x -= moveSpeed;
        }
        else if (Greenfoot.isKeyDown("D"))
        {
            x += moveSpeed;
        }
        setLocation(x, getWorld().getHeight() - 40);
    }
}
