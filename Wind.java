import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Wind here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wind extends Actor
{
    int random_direction = Greenfoot.getRandomNumber(2);
    private static int changeTimeCooldown = 5000;
    private static long lastChangeTime = System.currentTimeMillis();
    
    public void act()
    {
        windCondition();
    }
    
    public void windCondition()
    {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastChangeTime;
        
        if (elapsedTime >= changeTimeCooldown)
        {
            random_direction = Greenfoot.getRandomNumber(4);
            lastChangeTime = currentTime;
        }
        
        List<Leaf> leafs = getWorld().getObjects(Leaf.class);
        for (Leaf leaf : leafs)
        {
            if (random_direction == 1) {
                leaf.changeDirection(-random_direction);
                leaf.turn(-random_direction);
            }
            else {
                leaf.changeDirection(random_direction - 1);
                leaf.turn(random_direction - 1);
            }
        }
        
        List<Pumpkin> pumpkins = getWorld().getObjects(Pumpkin.class);
        for (Pumpkin pumpkin : pumpkins)
        {
            if (random_direction == 1) {
                pumpkin.changeDirection(-random_direction);
                pumpkin.turn(-random_direction);
            }
            else {
                pumpkin.changeDirection(random_direction - 1);
                pumpkin.turn(random_direction - 1);
            }
        }
        
        List<SpeedPotion> speedpotions = getWorld().getObjects(SpeedPotion.class);
        for (SpeedPotion speedpotion : speedpotions)
        {
            if (random_direction == 1) {
                speedpotion.changeDirection(-random_direction);
                speedpotion.turn(-random_direction);
            }
            else {
                speedpotion.changeDirection(random_direction - 1);
                speedpotion.turn(random_direction - 1);
            }
        }
    }
}
