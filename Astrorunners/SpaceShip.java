import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class SpaceShip extends Actor{
    private double velocityX, velocityY;
    private double x, y;
    private int rotation = 0;
    private String[] controls;
    private int playerID;
    private int wins;
    //these two are for grabbing the respawn cords :3
    private int spawnX;
    private int spawnY;
    public SpaceShip(int PlayerID){
        this.velocityX = 0;
        this.velocityY = 0;
        setplayerID(PlayerID);
        if(PlayerID == 1){
            controls = new String[]{"W","A","S","D","R"};
            spawnX = 125;
            spawnY = 192;
        }else if(PlayerID == 2){
            controls = new String[]{"I","J","K","L","O"};
            spawnX = 125;
            spawnY = 384;
        }else if(PlayerID ==  3){
            controls = new String[]{"UP","LEFT","DOWN","RIGHT","B"};
            spawnX = 125;
            spawnY = 576;
        }else if(PlayerID == 4){
            controls = new String[]{"5","1","2","3","9"};
            spawnX = 125;
            spawnY = 768;
        }
    }

    public int getspawnX(){
        return spawnX;
    }

    public int setspawnY(int i){
        return spawnY = i;
    }

    public int getspawnY(){
        return spawnY;
    }

    public int setplayerID(int i){
        return this.playerID = i;
    }

    public int getPlayerID(){
        return this.playerID;
    }

    public int setWins(int w){
        return this.wins = w;
    }

    public int getWins(){
        return this.wins;
    }

    public void addedToWorld(World world) {
        /*
        getWorld().addObject(thingyBL,0,0);
        getWorld().addObject(thingyBR,0,0);
        getWorld().addObject(thingyTL,0,0);
        getWorld().addObject(thingyTR,0,0);
        getWorld().addObject(thingyLT,0,0);
        getWorld().addObject(thingyLB,0,0);
        getWorld().addObject(thingyRT,0,0);
        getWorld().addObject(thingyRB,0,0);
         */
        x = getX();
        y = getY();
    }

    public void act() {
        if(Greenfoot.isKeyDown(controls[0])){
            velocityY-=.5;
            if(getRotation()!=270){
                if (getRotation()<270){
                    setRotation(getRotation()-5);
                }
                else{
                    setRotation(getRotation()+5);
                }
            }
            System.out.print(getRotation());
        }
        if(Greenfoot.isKeyDown(controls[1])){
            velocityX-=.5;
        }
        if(Greenfoot.isKeyDown(controls[2])){
            velocityY+=.5;
        }
        if(Greenfoot.isKeyDown(controls[3])){
            velocityX+=.5;
        }

        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        List<Platforms> platforms = getObjectsInRange(100, Platforms.class);
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            double xDif = bx - x;
            double yDif = by - y;
            double Distance = Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));
            velocityX += ((xDif) / Distance)/2;
            velocityY += ((yDif) / Distance)/2;

            if(Distance<15){
                velocityX = 0;
                velocityY = 0;
            }
        }
        if(velocityX>10){velocityX=10;}
        if(velocityY>10){velocityY=10;}
        if(velocityX<-10){velocityX=-10;}
        if(velocityY<-10){velocityY=-10;}

        x+=velocityX;
        y+=velocityY;

        //if(isTouching(BlackHole.class)){respawn();}

        //System.out.println("Distance: " + Distance);
        //System.out.println("Rotation: " + rotation);
        //System.out.println("velocityX: " + velocityX);
        //System.out.println("velocityY: " + velocityY);
        //System.out.println("xDif: " + xDif);
        //System.out.println("yDif: " + yDif);

        setLocation((int)Math.round(x), (int)Math.round(y));
        collisions();
    }
    //RESPAWN CODE THIS SETS THE LOCATION WHEN THE ASTRONATS DIE
    //obviously
    public void respawn(){
        x = getspawnX();
        y = getspawnY();
        velocityX = 0;
        velocityY = 0;
    }

    public void collisions() {
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        BlackHole b = blackholes.get(0);
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        double[] BLA = pointRotation(x,y,x-w/4,y+h/2,rotation);
        List<Platforms> BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);
        //thingyBL.setLocation((int)BLA[0],(int)BLA[1]);
        if(blackholes.size() > 0){
            if(BL.size() > 0) {
                while(BL.size() > 0) {
                    turn(-90);
                    move(1);
                    turn(90);
                    x = getX();
                    y = getY();
                    BLA = pointRotation(x,y,x-w/4,y+h/2,rotation);
                    BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);
                }
                setLocation((int)Math.round(x), (int)Math.round(y));
                velocityX=0; velocityY=0;
            }
            double[] BRA = pointRotation(x,y,x+w/4,y+h/2,rotation);
            List<Platforms> BR = getWorld().getObjectsAt((int)BRA[0],(int)BRA[1], Platforms.class);
            //thingyBR.setLocation((int)BRA[0],(int)BRA[1]);
            if(BR.size() > 0){
                while(BR.size() > 0) {
                    turn(-90);
                    move(1);
                    turn(90);
                    x = getX();
                    y = getY();
                    BRA = pointRotation(x,y,x+w/4,y+h/2,rotation);
                    BR = getWorld().getObjectsAt((int)BRA[0],(int)BRA[1], Platforms.class);
                }
                setLocation((int)Math.round(x), (int)Math.round(y));
                velocityX=0; velocityY=0;
            }
            double[] TLA = pointRotation(x,y,x-w/4,y-h/2,rotation);
            List<Platforms> TL = getWorld().getObjectsAt((int)TLA[0],(int)TLA[1], Platforms.class);
            //thingyTL.setLocation((int)TLA[0],(int)TLA[1]);
            if(TL.size() > 0){
                while(TL.size() > 0) {
                    turn(90);
                    move(1);
                    turn(-90);
                    x = getX();
                    y = getY();
                    TLA = pointRotation(x,y,x+w/4,y-h/2,rotation);
                    velocityY *= Math.cos(Math.toRadians(TL.get(0).getRotation())) * -1;
                    velocityX *= Math.sin(Math.toRadians(TL.get(0).getRotation()-180)) * -1;
                    TL = getWorld().getObjectsAt((int)TLA[0],(int)TLA[1], Platforms.class);
                }
                setLocation((int)Math.round(x),(int)Math.round(y));
            }
            double[] TRA = pointRotation(x,y,x+w/4,y-h/2,rotation);
            List<Platforms> TR = getWorld().getObjectsAt((int)TRA[0],(int)TRA[1], Platforms.class);
            //thingyTR.setLocation((int)TRA[0],(int)TRA[1]);
            if(TR.size() > 0){
                while(TR.size() > 0) {
                    turn(90);
                    move(1);
                    turn(-90);
                    x = getX();
                    y = getY();
                    TRA = pointRotation(x,y,x+w/4,y-h/2,rotation);
                    velocityY *= Math.cos(Math.toRadians(TR.get(0).getRotation())) * -1;
                    velocityX *= Math.sin(Math.toRadians(TR.get(0).getRotation()-180)) * -1;
                    TR = getWorld().getObjectsAt((int)TRA[0],(int)TRA[1], Platforms.class);
                }
                setLocation((int)Math.round(x),(int)Math.round(y));
            }
            double[] LTA = pointRotation(x,y,x-w/2,y-h/4,rotation);
            List<Platforms> LT = getWorld().getObjectsAt((int)LTA[0],(int)LTA[1], Platforms.class);
            //thingyLT.setLocation((int)LTA[0],(int)LTA[1]);
            if(LT.size() > 0){
                velocityY *= Math.sin(Math.toRadians(LT.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(LT.get(0).getRotation())) * -1;
            }
            double[] LBA = pointRotation(x,y,x-w/2,y+h/4,rotation);
            List<Platforms> LB = getWorld().getObjectsAt((int)LBA[0],(int)LBA[1], Platforms.class);
            //thingyLB.setLocation((int)LBA[0],(int)LBA[1]);
            if(LB.size() > 0){
                velocityY *= Math.sin(Math.toRadians(LB.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(LB.get(0).getRotation())) * -1;
            }
            double[] RTA = pointRotation(x,y,x+w/2,y-h/4,rotation);
            List<Platforms> RT = getWorld().getObjectsAt((int)RTA[0],(int)RTA[1], Platforms.class);
            //thingyRT.setLocation((int)RTA[0],(int)RTA[1]);
            if(RT.size() > 0){
                velocityY *= Math.sin(Math.toRadians(RT.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(RT.get(0).getRotation())) * -1;
            }
            double[] RBA = pointRotation(x,y,x+w/2,y+h/4,rotation);
            List<Platforms> RB = getWorld().getObjectsAt((int)RBA[0],(int)RBA[1], Platforms.class);
            //thingyRB.setLocation((int)RBA[0],(int)RBA[1]);
            if(RB.size() > 0){
                velocityY *= Math.sin(Math.toRadians(RB.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(RB.get(0).getRotation())) * -1;
            }
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
