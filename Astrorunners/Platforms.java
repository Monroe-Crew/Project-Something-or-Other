import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platforms extends Actor
{
    public static int PlatformXcord;
    public static int PlatformYcord;
    public void act() 
    {
        PlatformXcord = getX();
        PlatformYcord = getY();
    }    
}
