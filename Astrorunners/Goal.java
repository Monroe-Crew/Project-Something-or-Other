import greenfoot.*;
public class Goal extends Platforms
{
    public void act() 
    {
        removeTouching(Astronaut.class);
    }    
}
