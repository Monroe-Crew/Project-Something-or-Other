import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Actor
{
    private double decayInterval;
    private int distanceInterval;
    private int rotation;
    private double xPos;
    private double yPos;
    private double transparency = 255;
    public Particle(int distance, int decayTime, int height, int width, Color color, int x, int y){
        this.xPos = x;
        this.yPos = y;
        this.decayInterval = 255/(decayTime*60);
        this.distanceInterval = (int)(distance/(decayTime*60));
        this.rotation = Greenfoot.getRandomNumber(360);
        GreenfootImage particleImage = new GreenfootImage(height,width);
        particleImage.setColor(color);
        particleImage.fillRect(0,0,height,width);
        setImage(particleImage);
        
    }

    public void act()
    {
        transparency -= decayInterval;
        this.xPos += Math.cos (Math.toRadians(rotation))*distanceInterval;
        this.yPos +=  Math.sin (Math.toRadians(rotation))*distanceInterval;
        if(transparency > 0){
            setLocation((int)this.xPos,(int)this.yPos);
            getImage().setTransparency((int)transparency);
        } else{
        getWorld().removeObject(this);
        }
    }
}
