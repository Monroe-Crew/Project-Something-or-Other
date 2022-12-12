import greenfoot.*;
import java.util.*;
import java.lang.Math;
public class Astronaut extends Actor{
    private GreenfootImage left,right;
    private int gameID;
    private boolean haveJump;
    private boolean isRight = true;
    private GreenfootImage walk1,walk2,walk1Left,walk2Left;
    private boolean walkImage = true;
    private double velocityX, velocityY;
    private double x, y;
    private int rotation = 0;
    private String[] controls;
    private int playerID;
    private int wins;
    private int timer;
    //these two are for grabbing the respawn cords >:3
    private int spawnX;
    private int spawnY;
    //this is for the music to work >_< emil is looser
    public static Music music;
    public Astronaut(int PlayerID,int gameID){
        this.velocityX = 0;
        this.velocityY = 0;
        setplayerID(PlayerID);
        setGameID(gameID);
        // Sets player control, spawnpoint, and image.
        if(PlayerID == 1){ // Blue Astronaut
            controls = new String[]{"W","A","D","R"};
            spawnX = 125;
            spawnY = 192;

            setImage("Blue Astronaut.png"); 
            right=new GreenfootImage(getImage());
            left=new GreenfootImage(getImage());
            left.mirrorHorizontally();
            walk1=new GreenfootImage("Blue Astronaut run1.png");
            walk2=new GreenfootImage("Blue Astronaut run2.png");
            walk1Left=new GreenfootImage(walk1);
            walk1Left.mirrorHorizontally();
            walk2Left=new GreenfootImage(walk2);
            walk2Left.mirrorHorizontally();
        }else if(PlayerID == 2){ // Green Astronaut
            controls = new String[]{"T","F","H","U"};
            spawnX = 125;
            spawnY = 384;

            setImage("Green Astronaut.png");
            right=new GreenfootImage(getImage());
            left=new GreenfootImage(getImage());
            left.mirrorHorizontally();
            walk1=new GreenfootImage("Green Astronaut run1.png");
            walk2=new GreenfootImage("Green Astronaut run2.png");
            walk1Left=new GreenfootImage(walk1);
            walk1Left.mirrorHorizontally();
            walk2Left=new GreenfootImage(walk2);
            walk2Left.mirrorHorizontally();
        }else if(PlayerID ==  3){ // Pink Astronaut
            controls = new String[]{"I","J","L","U"};
            spawnX = 125;
            spawnY = 576;

            setImage("Pink Astronaut.png");
            right=new GreenfootImage(getImage());
            left=new GreenfootImage(getImage());
            left.mirrorHorizontally();
        }else if(PlayerID == 4){ // Yellow Astronaut
            controls = new String[]{"UP","LEFT","RIGHT","8"};
            spawnX = 125;
            spawnY = 768;

            setImage("Yellow Astronaut.png");
            right=new GreenfootImage(getImage());
            left=new GreenfootImage(getImage());
            left.mirrorHorizontally();
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
    
    public int getGameID(){
        return this.gameID;
    }

    public int setGameID(int i){
        return this.gameID = i;
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
        x = getX();
        y = getY();
    }

    public void act() {
        timer++;
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        List<Platforms> platforms = getObjectsInRange(500, Platforms.class);
        if(blackholes.size() > 0) {
            BlackHole b = blackholes.get(0);
            int bx = b.getX();
            int by = b.getY();
            double xDif = bx - x;
            double yDif = by - y;
            double Distance = Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));
            if(feetOnGround()){
                haveJump=true;
            }
            if(!feetOnGround()){
                turnTowards(bx, by);
                rotation = getRotation();
                setRotation(getRotation()-90);
                velocityX += (Math.cos(Math.toRadians(rotation)) / ((Math.log(Distance) / Math.log(2)))*2);
                velocityY += (Math.sin(Math.toRadians(rotation)) / ((Math.log(Distance) / Math.log(2)))*2);
            }
            if(
            Distance<50||
            isTouching(Meteoroid.class)||
            isTouching(Comet.class)||
            !onScreen(getX(),getY())
            )
            {respawn();}
            
            music.jumpMusic.setVolume(35); 
            if(Greenfoot.isKeyDown(controls[0])){
                if(feetOnGround()){
                    music.jumpMusic.play(); 
                }
                velocityX -= (Math.cos(Math.toRadians(rotation)) / 5);
                velocityY -= (Math.sin(Math.toRadians(rotation)) / 5);
            }
            if(Greenfoot.isKeyDown(controls[1])){
                velocityX -= (Math.sin(Math.toRadians(rotation)) / 10);
                velocityY -= (Math.cos(Math.toRadians(rotation-180)) / 10);
                setImage(left);
            }
            if(Greenfoot.isKeyDown(controls[2])){
                velocityX += (Math.sin(Math.toRadians(rotation)) / 10);
                velocityY += (Math.cos(Math.toRadians(rotation-180)) / 10);
                setImage(right);
            }
            if(gameID==0){
                if(Greenfoot.isKeyDown(controls[3])){
                    respawn();
                }
            }
            if(gameID==2 && Greenfoot.isKeyDown(controls[3]) && haveJump){
                if(feetOnGround()){
                    music.jumpMusic.play(); 
                }
                haveJump=false;
                velocityX = Math.cos(Math.toRadians(rotation))*-20;
                velocityY = Math.sin(Math.toRadians(rotation))*-20;
            }
            collisions();
        }
        else{
            if(Greenfoot.isKeyDown(controls[1])){
                x -=5;
                walkAnimation(false);
            }
            if(Greenfoot.isKeyDown(controls[2])){
                x +=5;
                walkAnimation(true);
            }
            if(Greenfoot.isKeyDown(controls[3])){
                if(feetOnGround()){
                    music.jumpMusic.play(); 
                }
                velocityY += -100;
            }
            velocityY =+5;
        }
        if(velocityX>5){velocityX=5;}
        if(velocityY>5){velocityY=5;}
        if(velocityX<-5){velocityX=-5;}
        if(velocityY<-5){velocityY=-5;}

        x+=velocityX;
        y+=velocityY;
        //score text creation caden gets no bithces
        String score = "Player " + playerID + "Score:" + getWins();
        //player score tracking implentation; implemetnt this dick pls >:D
        //PlayerScore(score, 11); LOLOLOL
        setLocation((int)Math.round(x), (int)Math.round(y));
        if(timer==60){timer=0;}
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
    //obviously dumbass >:(
    public void respawn(){
        boolean SoundPlayed = false;
        if(SoundPlayed == false){
            music.DeathSFX.play();
            SoundPlayed = true;
        }
        x = getspawnX();
        y = getspawnY();
        velocityX = 0;
        velocityY = 0;
        SoundPlayed = false;
    }

    public void walkAnimation(boolean direction){
        if(timer%10==0){
            if(walkImage){
                if(direction){
                    setImage(walk1);
                }
                else{
                    setImage(walk1Left);
                }
                walkImage=false;
            }
            else if(!walkImage){
                if(direction){
                    setImage(walk2);
                }
                else{
                    setImage(walk2Left);
                }
                walkImage=true;
            }
        }
    }

    public boolean onScreen(int x, int y){
        if((x>1280 || x<0) || (y>960 || y<0)){
            return false;
        }
        return true;
    }

    public void collisions() {
        List<BlackHole> blackholes = getObjectsInRange(2000, BlackHole.class);
        //BlackHole b = blackholes.get(0); 
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        double[] BLA = pointRotation(x,y,x-w/4,y+h/2,rotation);
        List<Platforms> BL = getWorld().getObjectsAt((int)BLA[0],(int)BLA[1], Platforms.class);
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
            if(LT.size() > 0){
                velocityY *= Math.sin(Math.toRadians(LT.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(LT.get(0).getRotation())) * -1;
            }
            double[] LBA = pointRotation(x,y,x-w/2,y+h/4,rotation);
            List<Platforms> LB = getWorld().getObjectsAt((int)LBA[0],(int)LBA[1], Platforms.class);
            if(LB.size() > 0){
                velocityY *= Math.sin(Math.toRadians(LB.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(LB.get(0).getRotation())) * -1;
            }
            double[] RTA = pointRotation(x,y,x+w/2,y-h/4,rotation);
            List<Platforms> RT = getWorld().getObjectsAt((int)RTA[0],(int)RTA[1], Platforms.class);
            if(RT.size() > 0){
                velocityY *= Math.sin(Math.toRadians(RT.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(RT.get(0).getRotation())) * -1;
            }
            double[] RBA = pointRotation(x,y,x+w/2,y+h/4,rotation);
            List<Platforms> RB = getWorld().getObjectsAt((int)RBA[0],(int)RBA[1], Platforms.class);
            if(RB.size() > 0){
                velocityY *= Math.sin(Math.toRadians(RB.get(0).getRotation()-180)) * -1;
                velocityX *= Math.cos(Math.toRadians(RB.get(0).getRotation())) * -1;
            }
        }
    }

    public void collisions2() {
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4,  h/2, Platforms.class);
        if(BL != null) {
            int ow = BL.getImage().getWidth();
            int oh = BL.getImage().getHeight();
            setLocation(getX(), BL.getY()-oh/2-h/2);
            velocityY = 0;
            if(velocityX>0){
                velocityX-=.01;
            }
            else{
                velocityX+=.01;
            }
        }
        Actor BR = getOneObjectAtOffset( w/4,  h/2, Platforms.class);
        if(BR != null){
            int ow = BR.getImage().getWidth();
            int oh = BR.getImage().getHeight();
            setLocation(getX(), BR.getY()-oh/2-h/2);
            velocityY = 0;
            if(velocityX>0){
                velocityX-=.01;
            }
            else{
                velocityX+=.01;
            }
        }
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Platforms.class);
        if(TL != null){
            int ow = TL.getImage().getWidth();
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY()+oh/2+h/2);
            velocityY = 0;
            if(velocityX>0){
                velocityX-=.01;
            }
            else{
                velocityX+=.01;
            }
        }
        Actor TR = getOneObjectAtOffset( w/4, -h/2, Platforms.class);
        if(TR != null){
            int ow = TR.getImage().getWidth();
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY()+oh/2+h/2);
            velocityY = 0;
            if(velocityX>0){
                velocityX-=.01;
            }
            else{
                velocityX+=.01;
            }
        }
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Platforms.class);
        if(LT != null){
            int ow = LT.getImage().getWidth();
            int oh = LT.getImage().getHeight();
            setLocation(LT.getX()+ow/2+w/2, getY());
            velocityX = 0;
        }
        Actor LB = getOneObjectAtOffset(-w/2,  h/4, Platforms.class);
        if(LB != null){
            int ow = LB.getImage().getWidth();
            int oh = LB.getImage().getHeight();
            setLocation(LB.getX()+ow/2+w/2, getY());
            velocityX = 0;
        }
        Actor RT = getOneObjectAtOffset( w/2, -h/4, Platforms.class);
        if(RT != null){
            int ow = RT.getImage().getWidth();
            int oh = RT.getImage().getHeight();
            setLocation(RT.getX()-ow/2-w/2, getY());
            velocityX = 0;
        }
        Actor RB = getOneObjectAtOffset( w/2,  h/4, Platforms.class);
        if(RB != null){
            int ow = RB.getImage().getWidth();
            int oh = RB.getImage().getHeight();
            setLocation(RB.getX()-ow/2-w/2, getY());
            velocityX = 0;
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
