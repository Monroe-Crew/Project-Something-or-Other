import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Start_Button extends Actor
{
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
			Greenfoot.playSound("GameBegin.mp3");
            Greenfoot.setWorld(new MainGame());
        }
    }
}
