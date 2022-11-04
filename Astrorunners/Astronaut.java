import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private static double velocityX, velocityY;
    private double x, y;
    public Astronaut(double velocity){
        this.velocityX = 0;
        this.velocityY = 0;
    }

    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }

    public void act() {
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            double xDif = bx - x;
            double yDif = by - y;
            double Distance = Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));
            turnTowards(bx, by);
            int rotation = getRotation();
            setRotation(getRotation()-90);
           
            //setRotation(0);
            velocityX += 32*(Math.cos(Math.toRadians(rotation)) / Distance);
            velocityY += 32*(Math.sin(Math.toRadians(rotation)) / Distance);
            if(velocityX>10){velocityX=10;}
            if(velocityY>10){velocityY=10;}
            if(velocityX<-10){velocityX=-10;}
            if(velocityY<-10){velocityY=-10;}
            //System.out.println("Distance: " + Distance);
            //System.out.println("Rotation: " + rotation);
            //System.out.println("velocityX: " + velocityX);
            //System.out.println("velocityY: " + velocityY);
            //System.out.println("xDif: " + xDif);
            //System.out.println("yDif: " + yDif);
            if(Distance<15){
                velocityX = 0;
                velocityY = 0;
            }
            x+=velocityX;
            y+=velocityY;
        }
        if(Greenfoot.isKeyDown("W")){
            velocityY-=.1;
        }
        if(Greenfoot.isKeyDown("A")){
            velocityX-=.1;
        }
        if(Greenfoot.isKeyDown("S")){
            velocityY+=.1;
        }
        if(Greenfoot.isKeyDown("D")){
            velocityX+=.1;
        }
        setLocation((int)Math.round(x), (int)Math.round(y));
    }
}
