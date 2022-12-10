import greenfoot.*;
import java.util.*;
public class Meteoroid extends Actor{ 
    private double rotation = 0;
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    public Meteoroid(int radius, double speed, int pivotX, int pivotY, double scale){
        this.radius = radius;
        this.speed = speed;
        this.pivotX = pivotX;
        this.pivotY = pivotY;

        double width = getImage().getWidth() * scale;
        double height = getImage().getHeight() * scale;
        
        getImage().scale((int)width,(int)height);
    }

    public void act() {
        setLocation(pivotX, pivotY);
        setRotation((int)rotation + 45);
        move(radius);
        rotation+=speed;
        
    }    
}
