import greenfoot.*;
public class Thingy extends Actor {
    
    public Thingy(String text) {
        GreenfootImage image = new GreenfootImage(20,20);
        image.setColor(new Color(255,0,0));
        image.fillOval(0,0,10,10);
        image.setFont(new Font("Arial", false, false, 10));
        image.setColor(new Color(255,255,255));
        image.drawString(text,0,12);
        setImage(image);
    }
}