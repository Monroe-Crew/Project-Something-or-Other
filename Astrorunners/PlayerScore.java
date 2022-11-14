import greenfoot.*;

public class PlayerScore extends Actor
{
    public PlayerScore(String text){
        GreenfootImage img = new GreenfootImage(text.length() * 20, 30);
        img.setColor(Color.BLACK);
        img.drawString(text, 2, 20);
        setImage(img);
    }
    
    public void setText(String text){
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text, 2, 20);
    }
}
