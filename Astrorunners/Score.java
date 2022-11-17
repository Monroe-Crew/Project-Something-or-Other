import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Score extends Actor
{
    public void Score(int PlayID, int score){
        GreenfootImage scoreString = new GreenfootImage (300,100);
        scoreString.drawString("Player "+PlayID+" Score: "+ score,200,200);
        setImage(scoreString); 
    }
    public void act()
    {
        // Add your action code here.
    }
}
