import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;
public class Platforms extends Actor
{
    private double velocityX, velocityY;
    private double x, y;
    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }

    public void act() {
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            turnTowards(bx, by);
            int rotation = getRotation();
            setRotation(getRotation()-90);
            setLocation((int)Math.round(x), (int)Math.round(y));
        }
    }

    private double[] pointRotation(double pivotX, double pivotY, double pointX, double pointY, int rotation){
        //System.out.println("pointRotation: "+pivotX+" "+pivotY+" "+pointX+" "+pointY);
        double[] newPoint = new double[2];
        newPoint[0] = Math.cos(Math.toRadians(rotation-90)) * (pointX-pivotX) -
        Math.sin(Math.toRadians(rotation-90)) * (pointY-pivotY) + pivotX;
        newPoint[1] = Math.sin(Math.toRadians(rotation-90)) * (pointX-pivotX) +
        Math.cos(Math.toRadians(rotation-90)) * (pointY-pivotY) + pivotY;
        //System.out.println("pointRotation returning: "+newPoint[0]+" "+newPoint[1]);
        return newPoint;
    }
}
