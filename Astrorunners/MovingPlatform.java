import greenfoot.*;
import java.util.*;
public class MovingPlatform extends Platforms{
    private double rotation;
    private double speed;
    private int radius;
    private int pivotX, pivotY;
    private double x, y;
    public MovingPlatform(int radius, double speed, int pivotX, int pivotY, int rotation){
        this.radius = radius;
        this.speed = speed;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.rotation = rotation;
    }

    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }

    public void act() {
        setLocation(pivotX, pivotY);
        setRotation((int)rotation);
        move(radius);
        rotation+=speed;
        //System.out.println(rotation);
        faceBlackHole();
    }

    private void faceBlackHole(){
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
            //setLocation((int)Math.round(x), (int)Math.round(y));
        }
    }
}
