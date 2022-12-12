import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
public class Start_Button extends Actor
{
    public List<Integer> playersJoined = new ArrayList<Integer>();
    public static Music music; 
    public void act(){
        if(Greenfoot.isKeyDown("1")  && playersJoined.size() > 1){
            System.out.println(playersJoined);
            music.stopAllMusic();
            Greenfoot.playSound("GameBegin.mp3");
            Greenfoot.setWorld(new Controls(playersJoined));
        }
    }
}