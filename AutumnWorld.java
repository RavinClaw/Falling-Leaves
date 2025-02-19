import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AutumnWorld  extends World
{
    private static int spawnCooldown = 1000;
    private static long lastSpawnTime = System.currentTimeMillis();
    private static GreenfootSound soundeffect = new GreenfootSound("pumpkinspawn.mp3");

    public AutumnWorld()
    {    
        // Create a new world 750 by 500 pixels in size.
        super(750, 500, 1, false);

        prepare();
        
        Scoreboard scoreboard = getObjects(Scoreboard.class).get(0);
        scoreboard.reset();
        Lives lives = getObjects(Lives.class).get(0);
        lives.reset();
    }

    /**
     * act - things you want to do each time around go in here
     * 
     */
    public void act() {
        spawnNewLeaf();
    }
    
    public void spawnNewLeaf()
    {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastSpawnTime;
        
        int random_chance = Greenfoot.getRandomNumber(100);
        
        if (elapsedTime >= spawnCooldown)
        {
            if (random_chance == 58 || random_chance == 78 || random_chance == 12 || random_chance == 33 || random_chance == 46) {
                soundeffect.play();
                addObject(new Pumpkin(), Greenfoot.getRandomNumber(getWidth()), 0);
                lastSpawnTime = currentTime;
            } else {
                addObject(new Leaf(), Greenfoot.getRandomNumber(getWidth()), 0);
                lastSpawnTime = currentTime;
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        Catcher catcher = new Catcher();
        addObject(catcher,364,461);
        Scoreboard scoreboard = new Scoreboard();
        addObject(scoreboard,150,50);
        Lives lives = new Lives();
        addObject(lives, 52, 75);
        Wind wind = new Wind();
        addObject(wind,760,510);
    }
}
