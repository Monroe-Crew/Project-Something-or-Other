import greenfoot.*;
import java.util.*;
public class Meteoroid extends Actor{ 
    int rotation = 0;
    int radius = 250;
    public void act() {
       List<BlackHole> blackHoles = getObjectsInRange(2000, BlackHole.class);
       int bX = blackHoles.get(0).getX();
       int bY = blackHoles.get(0).getY();
       setLocation(bX, bY);
       setRotation(rotation);
       move(radius);
       rotation+=2;
    }    
}
