import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private double velocityX, velocityY;
    private double x, y;
    private int rotation = 0;
    Thingy thingyBL = new Thingy("BL");
    Thingy thingyBR = new Thingy("BR");
    Thingy thingyTL = new Thingy("TL");
    Thingy thingyTR = new Thingy("TR");
    Thingy thingyLT = new Thingy("LT");
    Thingy thingyLB = new Thingy("LB");
    Thingy thingyRT = new Thingy("RT");
    Thingy thingyRB = new Thingy("RB");
    public Astronaut(){
        this.velocityX = 0;
        this.velocityY = 0;
    }

    public void addedToWorld(World world) {
        getWorld().addObject(thingyBL,0,0);
        getWorld().addObject(thingyBR,0,0);
        getWorld().addObject(thingyTL,0,0);
        getWorld().addObject(thingyTR,0,0);
        getWorld().addObject(thingyLT,0,0);
        getWorld().addObject(thingyLB,0,0);
        getWorld().addObject(thingyRT,0,0);
        getWorld().addObject(thingyRB,0,0);
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
            rotation = getRotation();
            setRotation(getRotation()-90);

            //setRotation(0);
            velocityX += 50*(Math.cos(Math.toRadians(rotation)) / Distance);
            velocityY += 50*(Math.sin(Math.toRadians(rotation)) / Distance);
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
        collisions();
    }

    public void collisions() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        double[] BLA = pointRotation(x,y,x-w/4,y+h/2);
        Actor BL = getOneObjectAtOffset((int)BLA[0],(int)BLA[1], Platforms.class);
        thingyBL.setLocation((int)BLA[0],(int)BLA[1]);
        if(BL != null) {
            int ow = BL.getImage().getWidth();
            int oh = BL.getImage().getHeight();
            x = x;
            y = BL.getY()-oh/2-h/2;
            setLocation((int)Math.round(x), (int)Math.round(y));
            velocityY = 0;
            System.out.println("BL");
        }
        double[] BRA = pointRotation(x,y,x+w/4,y+h/2);
        Actor BR = getOneObjectAtOffset((int)BRA[0],(int)BRA[1], Platforms.class);
        thingyBR.setLocation((int)BRA[0],(int)BRA[1]);
        if(BR != null){
            int ow = BR.getImage().getWidth();
            int oh = BR.getImage().getHeight();
            x = x;
            y = BR.getY()-oh/2-h/2;
            setLocation((int)Math.round(x), (int)Math.round(y));
            velocityY = 0;
            System.out.println("BR");
        }
        double[] TLA = pointRotation(x,y,x-w/4,y-h/2);
        Actor TL = getOneObjectAtOffset((int)TLA[0],(int)TLA[1], Platforms.class);
        thingyTL.setLocation((int)TLA[0],(int)TLA[1]);
        if(TL != null){
            int ow = TL.getImage().getWidth();
            int oh = TL.getImage().getHeight();
            x = x;
            y = TL.getY()-oh/2-h/2;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityY = 0;
            System.out.println("TL");
        }
        double[] TRA = pointRotation(x,y,x+w/4,y-h/2);
        Actor TR = getOneObjectAtOffset((int)TRA[0],(int)TRA[1], Platforms.class);
        thingyTR.setLocation((int)TRA[0],(int)TRA[1]);
        if(TR != null){
            int ow = TR.getImage().getWidth();
            int oh = TR.getImage().getHeight();
            x = x;
            y = TR.getY()-oh/2-h/2;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityY = 0;
            System.out.println("TR");
        }
        double[] LTA = pointRotation(x,y,x-w/2,y-h/4);
        Actor LT = getOneObjectAtOffset((int)LTA[0],(int)LTA[1], Platforms.class);
        thingyLT.setLocation((int)LTA[0],(int)LTA[1]);
        if(LT != null){
            int ow = LT.getImage().getWidth();
            int oh = LT.getImage().getHeight();
            x = LT.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("LT");
        }
        double[] LBA = pointRotation(x,y,x-w/2,y+h/4);
        Actor LB = getOneObjectAtOffset((int)LBA[0],(int)LBA[1], Platforms.class);
        thingyLB.setLocation((int)LBA[0],(int)LBA[1]);
        if(LB != null){
            int ow = LB.getImage().getWidth();
            int oh = LB.getImage().getHeight();
            x = LB.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("LB");
        }
        double[] RTA = pointRotation(x,y,x+w/2,y-h/4);
        Actor RT = getOneObjectAtOffset((int)RTA[0],(int)RTA[1], Platforms.class);
        thingyRT.setLocation((int)RTA[0],(int)RTA[1]);
        if(RT != null){
            int ow = RT.getImage().getWidth();
            int oh = RT.getImage().getHeight();
            x = RT.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("RT");
        }
        double[] RBA = pointRotation(x,y,x+w/2,y+h/4);
        Actor RB = getOneObjectAtOffset((int)RBA[0],(int)RBA[1], Platforms.class);
        thingyRB.setLocation((int)RBA[0],(int)RBA[1]);
        if(RB != null){
            int ow = RB.getImage().getWidth();
            int oh = RB.getImage().getHeight();
            x = RB.getX()+ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("RB");
        }
    }
    private double[] pointRotation(double pivotX, double pivotY, double pointX, double pointY){
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
