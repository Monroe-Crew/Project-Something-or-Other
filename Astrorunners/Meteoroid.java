import greenfoot.*;
import java.util.*;
public class Meteoroid extends Actor{ 
    private int rotation = 0;
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    public Meteoroid(int radius, double speed, int pivotX, int pivotY, int scale){
        this.radius = radius;
        this.speed = speed;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        
        setImage("Comet.png");
        
        int width = getImage().getWidth() * scale;
        int height = getImage().getHeight() * scale;
        
        getImage().scale(width,height);
    }

    public void act() {
        setLocation(pivotX, pivotY);
        setRotation((int)rotation);
        move(radius);
        rotation+=speed;
        
    }    
}
