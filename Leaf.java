import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Leaf  extends Actor
{
    private GreenfootSound soundeffect = new GreenfootSound("leafcollect.mp3");
    private GreenfootSound soundeffect2 = new GreenfootSound("leafdie.mp3");
    
    private GreenfootImage leaf1 = new GreenfootImage("cutoutleaf0.png");
    private GreenfootImage leaf2 = new GreenfootImage("cutoutleaf1.png");
    private GreenfootImage leaf3 = new GreenfootImage("cutoutleaf2.png");
    private GreenfootImage leaf4 = new GreenfootImage("cutoutleaf3.png");
    
    private int speed = Greenfoot.getRandomNumber(2) + 1;
    private int leaf_image = Greenfoot.getRandomNumber(4);

    public Leaf()
    {
        if (leaf_image == 0) {
            setImage(leaf1);
        }
        else if (leaf_image == 1) {
            setImage(leaf2);
        }
        else if (leaf_image == 2) {
            setImage(leaf3);
        }
        else if (leaf_image == 3) {
            setImage(leaf4);
        }
    }
    
    public void act()
    {
        Movement();
        onCollision();
    }
    
    public void Movement() 
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
            scoreboard.changeScore(1);
            soundeffect.play();
            getWorld().removeObject(this);
            return;
        }
        if (getY() >= getWorld().getHeight() - 5)
        {
            Lives lives = getWorld().getObjects(Lives.class).get(0);
            lives.changeLives(1);
            soundeffect2.play();
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
