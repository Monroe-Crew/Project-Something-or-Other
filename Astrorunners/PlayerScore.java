import greenfoot.*;

public class PlayerScore extends Actor
{
    public PlayerScore(String text, int fontSize){
        GreenfootImage image = new GreenfootImage(800,150);
        image.setColor(new Color(255,255,255));
        image.setFont(new Font("Arial", true, false, fontSize));
        image.drawString(text, 10, 100);
        setImage(image);
    }
    
    public void setText(String text){
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text, 2, 20);
        
    }
}
