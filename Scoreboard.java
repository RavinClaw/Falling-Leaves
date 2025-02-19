import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends Actor
{
    public static int score = 0;

    public Scoreboard()
    {
        GreenfootImage img = new GreenfootImage(300, 70);
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.WHITE);
        img.drawString("Score: " + score, 2, 20);
        setImage(img);
    }
    
    public void act()
    {
        this.changeScore(0);
    }
    
    public void changeScore( int points )
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.WHITE);
        score += points;
        img.drawString("Score: " + score, 2, 20);
        setImage(img);
    }
    
    public void reset() {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Comic Sans MS", 24));
        img.setColor(Color.WHITE);
        score = 0;
        img.drawString("Score: " + score, 2, 20);
        setImage(img);
    }
}
