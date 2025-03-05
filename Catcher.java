     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Catcher  extends Actor
{
    private static int moveSpeed = 7;
    private static int potionMoveSpeed = 12;
    private static long lastSpawnTime = System.currentTimeMillis();
    private static int potionCooldown = 6000; // 6 Seconds
    private static Boolean usedPotion = false;
    private static Boolean isPotionActive = false;
    
    
    public void act() 
    {
        Movement();
        BorderControl();
        
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastSpawnTime;
        
        if (usedPotion == false) {
            if (elapsedTime >= potionCooldown) {
                usedPotion = true;
                isPotionActive = false;
                lastSpawnTime = currentTime;
            }
        }
    }
    
    public void collectedPotion()
    {
        isPotionActive = true;
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
            if (isPotionActive == true) {
                x -= potionMoveSpeed;
            }
            else {
                x -= moveSpeed;
            }
        }
        else if (Greenfoot.isKeyDown("D"))
        {
            if (isPotionActive == true) {
                x += potionMoveSpeed;
            }
            else {
                x += moveSpeed;
            }
        }
        setLocation(x, getWorld().getHeight() - 40);
    }
}
