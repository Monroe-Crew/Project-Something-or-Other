import greenfoot.*;
public class MovingPlatform extends Platforms{
    private int rotation = getRotation();
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    public MovingPlatform(int radius, double speed, int pivotX, int pivotY){
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
