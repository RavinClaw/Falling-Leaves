import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lives extends Actor
{
    private GreenfootSound soundeffect = new GreenfootSound("gameover.mp3");
    private GreenfootSound gameloop = new GreenfootSound("gameloop.mp3");
    public static int lives = 5;

    public Lives()
    {
        GreenfootImage img = new GreenfootImage(100, 70);
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.RED);
        img.drawString("Lives:  " + lives, 2, 20);
        setImage(img);
    }
    
    public void act()
    {
        if (!gameloop.isPlaying())
        {
            gameloop.play();
        }
        
        if (lives < 1)
        {
            Scoreboard scoreboard = getWorld().getObjects(Scoreboard.class).get(0);
            scoreboard.reset();
            Lives lives = getWorld().getObjects(Lives.class).get(0);
            lives.reset();
            gameloop.stop();
            soundeffect.play();
            GameOverWorld world = new GameOverWorld();
            Greenfoot.setWorld(world);
        }
        this.changeLives(0);
    }
    
    public void changeLives( int points )
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.RED);
        lives -= points;
        img.drawString("Lives:  " + lives, 2, 20);
        setImage(img);
    }
    
    public void addLives( int points )
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.RED);
        lives += points;
        img.drawString("Lives:  " + lives, 2, 20);
        setImage(img);
    }
    
    public void reset()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.RED);
        lives = 5;
        img.drawString("Lives:  " + lives, 2, 20);
        setImage(img);
    }
}
