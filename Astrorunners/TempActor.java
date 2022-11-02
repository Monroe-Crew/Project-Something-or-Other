import greenfoot.*; 
public class TempActor extends Actor
{
     private static int XCord;
    private static int YCord;
    public int getXCord(){
      return XCord;    
    }
    public void SetXCord(){
        
    }
     
    public void act() 
    {  
        int gravity = 5;
        if(Greenfoot.isKeyDown("E")){setLocation(getX(),getY()-30);}
        if(Greenfoot.isKeyDown("D")){setLocation(getX()+5, getY());}
        if(Greenfoot.isKeyDown("A")){setLocation(getX()-5,getY());}
        setLocation(getX(), getY()+gravity);
        if(isTouching(Platforms.class)){setLocation(getX(),getY()-gravity);}
        //I'm going to keep myself safe :3
    }   
}
