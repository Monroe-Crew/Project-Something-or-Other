import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private double velocityX, velocityY;
    private double x, y;
    public Astronaut(){
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
            System.out.println("Distance: " + Distance);
            System.out.println("Rotation: " + rotation);
            System.out.println("velocityX: " + velocityX);
            System.out.println("velocityY: " + velocityY);
            System.out.println("xDif: " + xDif);
            System.out.println("yDif: " + yDif);
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
        collisions();
    }

    public void collisions() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4,  h/2, Platforms.class);
        if(BL != null) {
            int ow = BL.getImage().getWidth();
            int oh = BL.getImage().getHeight();
            x = x;
            y = BL.getY()-oh/2-h/2;
            setLocation((int)Math.round(x), (int)Math.round(y));
            velocityY = 0;
            System.out.println("BL");
        }
        Actor BR = getOneObjectAtOffset( w/4,  h/2, Platforms.class);
        if(BR != null){
            int ow = BR.getImage().getWidth();
            int oh = BR.getImage().getHeight();
            x = x;
            y = BR.getY()-oh/2-h/2;
            setLocation((int)Math.round(x), (int)Math.round(y));
            velocityY = 0;
            System.out.println("BR");
        }
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Platforms.class);
        if(TL != null){
            int ow = TL.getImage().getWidth();
            int oh = TL.getImage().getHeight();
            x = x;
            y = TL.getY()-oh/2-h/2;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityY = 0;
        }
        Actor TR = getOneObjectAtOffset( w/4, -h/2, Platforms.class);
        if(TR != null){
            int ow = TR.getImage().getWidth();
            int oh = TR.getImage().getHeight();
            x = x;
            y = TR.getY()-oh/2-h/2;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityY = 0;
        }
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Platforms.class);
        if(LT != null){
            int ow = LT.getImage().getWidth();
            int oh = LT.getImage().getHeight();
            x = LT.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
        }
        Actor LB = getOneObjectAtOffset(-w/2,  h/4, Platforms.class);
        if(LB != null){
            int ow = LB.getImage().getWidth();
            int oh = LB.getImage().getHeight();
            x = LB.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
        }
        Actor RT = getOneObjectAtOffset( w/2, -h/4, Platforms.class);
        if(RT != null){
            int ow = RT.getImage().getWidth();
            int oh = RT.getImage().getHeight();
            x = RT.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
        }
        Actor RB = getOneObjectAtOffset( w/2,  h/4, Platforms.class);
        if(RB != null){
            int ow = RB.getImage().getWidth();
            int oh = RB.getImage().getHeight();
            x = RB.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
        }
    }
}
