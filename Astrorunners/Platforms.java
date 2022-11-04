import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Platforms extends Actor
{
    public void act() 
    {
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            turnTowards(bx, by);
            int rotation = getRotation();
            setRotation(getRotation()-90);
        }
    }    
}
