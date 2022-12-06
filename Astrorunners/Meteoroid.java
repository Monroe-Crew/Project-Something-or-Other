import greenfoot.*;
import java.util.*;
public class Meteoroid extends Actor{ 
    private int rotation = 0;
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    public Meteoroid(int radius, double speed, int pivotX, int pivotY, double scale){
        this.radius = radius;
        this.speed = speed;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        int width = (int)Math.round(getImage().getWidth() * scale);
        int height = (int)Math.round(getImage().getHeight() * scale);
        getImage().scale(width,height);
        getImage().rotate(-90);
    }

    public void act() {
        setLocation(pivotX, pivotY);
        setRotation((int)rotation);
        move(radius);
        rotation+=speed;
        
    }    
}
