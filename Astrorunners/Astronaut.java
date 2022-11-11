import greenfoot.*;
import java.util.List; 
import java.util.ArrayList;
public class Astronaut extends Actor{
    private boolean grounded, wHeld;
    private int xSpeed, ySpeed, xSpeedMax, ySpeedMax, frame;
    private int score;
    private String[] controls;
    
    public Astronaut(int playerID){
        this.xSpeedMax = 10;
        this.ySpeedMax = 20;
        this.score = 0;
        
        if(playerID == 1){
            controls = new String[]{"W", "A", "D"};
        }
        else if(playerID == 2){
            controls = new String[]{"I", "J", "L"};
        }
        else if(playerID == 3){
            controls = new String[]{"S", "Z", "C"};
        }
        else if(playerID == 4){
            controls = new String[]{"K", "M", "."};
        }
    }
    
    //do you want me to kill myself be honest
    public void act(){
        frame++;
        // ARE WE GROUNDED?
        grounded = onGroundCheck();
        // APPLY GRAVITY
        ySpeed++;
        // CHECK KEY PRESSES
        if(Greenfoot.isKeyDown(controls[0]) && grounded){
            ySpeed = -20;
            wHeld = true;
        }
        // RELEASE JUMP
        if(!Greenfoot.isKeyDown(controls[0]) && wHeld && ySpeed < 0) {
            ySpeed = ySpeed / 2;
            wHeld = false;
        }
        // RUN LEFT/RIGHT
        if(Greenfoot.isKeyDown(controls[2])){xSpeed++;}
        if(Greenfoot.isKeyDown(controls[1])){xSpeed--;}
        // APPLY FRICTION
        if(frame % 2 == 0) {
            if(xSpeed > 0) {xSpeed--;}
            if(xSpeed < 0) {xSpeed++;}
        }
        // CAP THEIR SPEEDS
        if(xSpeed < -xSpeedMax) {xSpeed = -xSpeedMax;}
        if(xSpeed > xSpeedMax) {xSpeed = xSpeedMax;}
        if(ySpeed < -ySpeedMax) {ySpeed = -ySpeedMax;}
        if(ySpeed > ySpeedMax) {ySpeed = ySpeedMax;}
        // UPDATE LOCATION BASED ON SPEEDS
        setLocation(getX()+xSpeed, getY()+ySpeed);
        // FIX POSITION BASED ON COLLISIONS
        collisions();
    }

    public boolean onGroundCheck(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4,  h/2, Platforms.class);
        if(BL != null) {
            return true;
        }
        Actor BR = getOneObjectAtOffset( w/4,  h/2, Platforms.class);
        if(BR != null){
            return true;
        }
        return false;
    }

    public void collisions(){
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-w/4,  h/2, Platforms.class);
        if(BL != null) {
            int ow = BL.getImage().getWidth();
            int oh = BL.getImage().getHeight();
            setLocation(getX(), BL.getY()-oh/2-h/2);
            ySpeed = 0;
        }
        Actor BR = getOneObjectAtOffset( w/4,  h/2, Platforms.class);
        if(BR != null){
            int ow = BR.getImage().getWidth();
            int oh = BR.getImage().getHeight();
            setLocation(getX(), BR.getY()-oh/2-h/2);
            ySpeed = 0;
        }
        Actor TL = getOneObjectAtOffset(-w/4, -h/2, Platforms.class);
        if(TL != null){
            int ow = TL.getImage().getWidth();
            int oh = TL.getImage().getHeight();
            setLocation(getX(), TL.getY()+oh/2+h/2);
            ySpeed = 0;
        }
        Actor TR = getOneObjectAtOffset( w/4, -h/2, Platforms.class);
        if(TR != null){
            int ow = TR.getImage().getWidth();
            int oh = TR.getImage().getHeight();
            setLocation(getX(), TR.getY()+oh/2+h/2);
            ySpeed = 0;
        }
        Actor LT = getOneObjectAtOffset(-w/2, -h/4, Platforms.class);
        if(LT != null){
            int ow = LT.getImage().getWidth();
            int oh = LT.getImage().getHeight();
            setLocation(LT.getX()+ow/2+w/2, getY());
            xSpeed = 0;
        }
        Actor LB = getOneObjectAtOffset(-w/2,  h/4, Platforms.class);
        if(LB != null){
            int ow = LB.getImage().getWidth();
            int oh = LB.getImage().getHeight();
            setLocation(LB.getX()+ow/2+w/2, getY());
            xSpeed = 0;
        }
        Actor RT = getOneObjectAtOffset( w/2, -h/4, Platforms.class);
        if(RT != null){
            int ow = RT.getImage().getWidth();
            int oh = RT.getImage().getHeight();
            setLocation(RT.getX()-ow/2-w/2, getY());
            xSpeed = 0;
        }
        Actor RB = getOneObjectAtOffset( w/2,  h/4, Platforms.class);
        if(RB != null){
            int ow = RB.getImage().getWidth();
            int oh = RB.getImage().getHeight();
            setLocation(RB.getX()-ow/2-w/2, getY());
            xSpeed = 0;
        }
    }
}
