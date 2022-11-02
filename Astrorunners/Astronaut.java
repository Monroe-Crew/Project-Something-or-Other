import greenfoot.*;
import java.util.*;
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
            double xDif = bx - getX();
            double yDif = by - getY();
            velocityX=1.0/xDif;
            velocityY=1.0/yDif;
            System.out.println(xDif +" " + yDif);
            //System.out.println(velocityX+" "+velocityY);
        }
        x+=velocityX;
        y+=velocityY;
        setLocation((int)Math.round(x), (int)Math.round(y));
    }

    public double gravityAcceleration(double gravity, double velocity){
        return velocity + gravity;
    }

    public void gravity(double velocity){
        setLocation(getX(), getY() + (int)velocity);
    }
}
