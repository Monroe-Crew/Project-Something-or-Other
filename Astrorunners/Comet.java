import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Comet extends Actor{
    private int angle;
    private double speed;
    private double velocityX, velocityY;
    private double x, y;
    public Comet(int angle, double speed){
        this.angle = angle;
        this.speed = speed;
    }

    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }

    public void act(){
        velocityX += speed * Math.cos(Math.toRadians(angle));
        velocityY += speed * Math.sin(Math.toRadians(angle));
        System.out.println(velocityX + " " + velocityY);
        x += velocityX;
        y += velocityY;
        System.out.println(x + " " + y);
        setLocation((int)Math.round(x), (int)Math.round(y));
    }
}
