import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private double velocityX, velocityY;
    private double x, y;
    private int rotation = 0;
    private boolean isColliding = false;
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
            if(!isColliding){

                turnTowards(bx, by);
                rotation = getRotation();
                setRotation(getRotation()-90);

                //setRotation(0);
                velocityX += 30*(Math.cos(Math.toRadians(rotation)) / Distance);
                velocityY += 30*(Math.sin(Math.toRadians(rotation)) / Distance);
            }
            else{
                velocityX /= 2;
                velocityY /= 2;
            }

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
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        BlackHole b = blackholes.get(0);
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        double[] BLA = pointRotation(x,y,x-w/4,y+h/2,rotation);
        List<Platforms> BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);
        thingyBL.setLocation((int)BLA[0],(int)BLA[1]);
        if(blackholes.size() > 0){
            if(BL.size() > 0) {
                //int ow = BL.get(0).getImage().getWidth();
                //int oh = BL.get(0).getImage().getHeight();
                //double[] OA = pointRotation(b.getX(),b.getY(),x,y,rotation);
                //x = OA[0];
                //y = OA[1];
                while(BL.size() > 0) {
                    turn(-90);
                    move(1);
                    turn(90);
                    x = getX();
                    y = getY();
                    BLA = pointRotation(x,y,x-w/4,y+h/2,rotation);
                    BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);
                    isColliding = true;
                }
                setLocation((int)Math.round(x), (int)Math.round(y));
                //velocityX *= .5;
                //velocityY *= .5;
                System.out.println("BL");
            }
            isColliding = false;
            double[] BRA = pointRotation(x,y,x+w/4,y+h/2,rotation);
            List<Platforms> BR = getWorld().getObjectsAt((int)BRA[0],(int)BRA[1], Platforms.class);
            thingyBR.setLocation((int)BRA[0],(int)BRA[1]);
            if(BR.size() > 0){
                //int ow = BR.get(0).getImage().getWidth();
                //int oh = BR.get(0).getImage().getHeight();
                //double[] OA = pointRotation(b.getX(),b.getY(),x,y,rotation);
                //x = OA[0];
                //y = OA[1];
                while(BR.size() > 0) {
                    turn(-90);
                    move(1);
                    turn(90);
                    x = getX();
                    y = getY();
                    BRA = pointRotation(x,y,x+w/4,y+h/2,rotation);
                    BR = getWorld().getObjectsAt((int)BRA[0],(int)BRA[1], Platforms.class);
                    isColliding = true;
                }
                setLocation((int)Math.round(x), (int)Math.round(y));
                //velocityX *= .5;
                //velocityY *= .5;
                System.out.println("BR");
            }
            isColliding = false;
            double[] TLA = pointRotation(x,y,x-w/4,y-h/2,rotation);
            List<Platforms> TL = getWorld().getObjectsAt((int)TLA[0],(int)TLA[1], Platforms.class);
            thingyTL.setLocation((int)TLA[0],(int)TLA[1]);
            if(TL.size() > 0){
                //int ow = TL.get(0).getImage().getWidth();
                //int oh = TL.get(0).getImage().getHeight();
                //x = x;
                //y = TL.get(0).getY()+oh/2+h/2;
                while(TL.size() > 0) {
                    turn(90);
                    move(1);
                    turn(-90);
                    x = getX();
                    y = getY();
                    TLA = pointRotation(x,y,x-w/4,y-h/2,rotation);
                    TL = getWorld().getObjectsAt((int)TLA[0],(int)TLA[1], Platforms.class);
                }
                setLocation((int)Math.round(x),(int)Math.round(y));
                velocityX *= 1;
                velocityY *= -1;
                System.out.println("TL");
            }
            double[] TRA = pointRotation(x,y,x+w/4,y-h/2,rotation);
            List<Platforms> TR = getWorld().getObjectsAt((int)TRA[0],(int)TRA[1], Platforms.class);
            thingyTR.setLocation((int)TRA[0],(int)TRA[1]);
            if(TR.size() > 0){
                //int ow = TR.get(0).getImage().getWidth();
                //int oh = TR.get(0).getImage().getHeight();
                //x = x;
                //y = TR.get(0).getY()+oh/2+h/2;
                while(TR.size() > 0) {
                    turn(90);
                    move(1);
                    turn(-90);
                    x = getX();
                    y = getY();
                    TRA = pointRotation(x,y,x+w/4,y-h/2,rotation);
                    TR = getWorld().getObjectsAt((int)TRA[0],(int)TRA[1], Platforms.class);
                }
                setLocation((int)Math.round(x),(int)Math.round(y));
                velocityX *= 1;
                velocityY *= -1;
                System.out.println("TR");
            }
            /*
            double[] LTA = pointRotation(x,y,x-w/2,y-h/4,rotation);
            List<Platforms> LT = getWorld().getObjectsAt((int)LTA[0],(int)LTA[1], Platforms.class);
            thingyLT.setLocation((int)LTA[0],(int)LTA[1]);
            if(LT.size() > 0){
            int ow = LT.get(0).getImage().getWidth();
            int oh = LT.get(0).getImage().getHeight();
            x = LT.get(0).getX()-ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("LT");
            }
            double[] LBA = pointRotation(x,y,x-w/2,y+h/4,rotation);
            List<Platforms> LB = getWorld().getObjectsAt((int)LBA[0],(int)LBA[1], Platforms.class);
            thingyLB.setLocation((int)LBA[0],(int)LBA[1]);
            if(LB.size() > 0){
            int ow = LB.get(0).getImage().getWidth();
            int oh = LB.get(0).getImage().getHeight();
            x = LB.get(0).getX()-ow/2+w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("LB");
            }
            double[] RTA = pointRotation(x,y,x+w/2,y-h/4,rotation);
            List<Platforms> RT = getWorld().getObjectsAt((int)RTA[0],(int)RTA[1], Platforms.class);
            thingyRT.setLocation((int)RTA[0],(int)RTA[1]);
            if(RT.size() > 0){
            int ow = RT.get(0).getImage().getWidth();
            int oh = RT.get(0).getImage().getHeight();
            x = RT.get(0).getX()-ow/2-w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("RT");
            }
            double[] RBA = pointRotation(x,y,x+w/2,y+h/4,rotation);
            List<Platforms> RB = getWorld().getObjectsAt((int)RBA[0],(int)RBA[1], Platforms.class);
            thingyRB.setLocation((int)RBA[0],(int)RBA[1]);
            if(RB.size() > 0){
            int ow = RB.get(0).getImage().getWidth();
            int oh = RB.get(0).getImage().getHeight();
            x = RB.get(0).getX()-ow/2-w/2;
            y = y;
            setLocation((int)Math.round(x),(int)Math.round(y));
            velocityX = 0;
            System.out.println("RB");
            }
             */
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
