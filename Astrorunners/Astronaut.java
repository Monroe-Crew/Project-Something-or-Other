import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private double velocityX, velocityY;
    private double x, y;
    private int rotation = 0;
    private String[] controls;
    private int playerID;
    private int wins;
    //these two are for grabbing the respawn cords :3
    private int spawnX;
    private int spawnY;
    public Astronaut(int PlayerID){
        this.velocityX = 0;
        this.velocityY = 0;
        setplayerID(PlayerID);

        // Sets player control, spawnpoint, and image.
        if(PlayerID == 1){ // Blue Astronaut
            controls = new String[]{"W","A","S","D","R"};
            spawnX = 125;
            spawnY = 192;

            setImage("Blue Astronaut.png"); 
        }else if(PlayerID == 2){ // Green Astronaut
            controls = new String[]{"T","F","G","H","U"};
            spawnX = 125;
            spawnY = 384;

            setImage("Blue Astronaut.png");
        }else if(PlayerID ==  3){ // Pink Astronaut
            controls = new String[]{"I","J","K","L","U"};
            spawnX = 125;
            spawnY = 576;

            setImage("Blue Astronaut.png");
        }else if(PlayerID == 4){ // Yellow Astronaut
            controls = new String[]{"UP","LEFT","DOWN","RIGHT","8"};
            spawnX = 125;
            spawnY = 768;

            setImage("Blue Astronaut.png");
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
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        List<Platforms> platforms = getObjectsInRange(500, Platforms.class);
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            double xDif = bx - x;
            double yDif = by - y;
            double Distance = Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));
            if(!feetOnGround()){
                turnTowards(bx, by);
                rotation = getRotation();
                setRotation(getRotation()-90);
                velocityX += 50*(Math.cos(Math.toRadians(rotation)) / Distance);
                velocityY += 50*(Math.sin(Math.toRadians(rotation)) / Distance);
            }

            if(Distance<15){
                velocityX = 0;
                velocityY = 0;
            }

        }
        if(Greenfoot.isKeyDown(controls[0])&&feetOnGround()){
            velocityY = -.15;
        }
        if(Greenfoot.isKeyDown(controls[1])){
            velocityX-=.15;
        }
        if(Greenfoot.isKeyDown(controls[2])){
            velocityY+=.15;
        }
        if(Greenfoot.isKeyDown(controls[3])){
            velocityX+= .15;
        }
        if(Greenfoot.isKeyDown(controls[4]) &&feetOnGround() ) {
            velocityY = 4 * Math.cos(Math.toRadians(platforms.get(0).getRotation())) * -1;
            velocityX = 4 * Math.sin(Math.toRadians(platforms.get(0).getRotation()-180)) * -1;
        }

        if(velocityX>10){velocityX=10;}
        if(velocityY>10){velocityY=10;}
        if(velocityX<-10){velocityX=-10;}
        if(velocityY<-10){velocityY=-10;}

        x+=velocityX;
        y+=velocityY;

        if(isTouching(BlackHole.class)|| !onScreen(getX(),getY())||isTouching(Meteoroid.class)){respawn();}
        //System.out.println("Distance: " + Distance);
        //System.out.println("Rotation: " + rotation);
        //System.out.println("velocityX: " + velocityX);
        //System.out.println("velocityY: " + velocityY);
        //System.out.println("xDif: " + xDif);
        //System.out.println("yDif: " + yDif);
        //score text creation
        String score = "Player " + playerID + "Score:" + getWins();
        //player score tracking implentation
        //PlayerScore(score, 11);
        setLocation((int)Math.round(x), (int)Math.round(y));
        collisions();
    }

    public boolean feetOnGround() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();

        double[] BLA = pointRotation(x,y,x-w/4,y+h/2+5,rotation);
        List<Platforms> BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);

        double[] BRA = pointRotation(x,y,x+w/4,y+h/2+5,rotation);
        List<Platforms> BR = getWorld().getObjectsAt((int)BRA[0],(int)BRA[1], Platforms.class);
        if(BL.size() > 0 || BR.size() > 0) {
            return true;
        }
        return false;
    }

    //RESPAWN CODE THIS SETS THE LOCATION WHEN THE ASTRONATS DIE
    public void respawn(){
        x = getspawnX();
        y = getspawnY();
        velocityX = 0;
        velocityY = 0;
    }

    public boolean onScreen(int x, int y){
        if((x>1280 || x<0) || (y>960 || y<0)){
            return false;
        }
        return true;
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
