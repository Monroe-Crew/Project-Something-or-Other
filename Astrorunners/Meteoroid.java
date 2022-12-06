import greenfoot.*;
import java.util.*;
public class Meteoroid extends Actor{ 
    private int rotation = 0;
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    public Meteoroid(int radius, double speed, int pivotX, int pivotY){
        setImage("Comet.png");
        this.radius = radius;
        this.speed = speed;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    public void act() {
        setLocation(pivotX, pivotY);
        setRotation((int)rotation);
        move(radius);
        rotation+=speed;
        
    }    
}
