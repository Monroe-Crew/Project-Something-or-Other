import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Comet extends Actor{
    private int angle;
    private double speed;
    private double velocityX, velocityY;
    private double x, y;
    public Comet(int angle, double speed, double scale){
        this.angle = angle;
        this.speed = speed;
        
        setRotation(angle + 90);
        
        double width = getImage().getWidth() * scale;
        double height = getImage().getHeight() * scale;
        
        getImage().scale((int)width,(int)height);
    }

    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }

    public void act(){
        velocityX += speed * Math.cos(Math.toRadians(angle));
        velocityY += speed * Math.sin(Math.toRadians(angle));
        x += velocityX;
        y += velocityY;
        setLocation((int)Math.round(x), (int)Math.round(y));
        removeTouching(Astronaut.class);
    }
}
