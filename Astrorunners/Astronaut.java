import greenfoot.*; 
public class Astronaut extends Actor
{
    public void act() 
    {  
        int gravity = 5;
        if(Greenfoot.isKeyDown("E")){setLocation(getX(),getY()-30);}
        if(Greenfoot.isKeyDown("D")){setLocation(getX()+5, getY());}
        if(Greenfoot.isKeyDown("A")){setLocation(getX()-5,getY());}
        setLocation(getX(), getY()+gravity);
        //I'm going to keep myself safe :3
    }    
}
