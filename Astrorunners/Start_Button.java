import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
public class Start_Button extends Actor
{
    public List<Integer> playersJoined = new ArrayList<Integer>();
    public static Music music; 
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            System.out.println(playersJoined);
            music.stopAllMusic();
            Greenfoot.playSound("GameBegin.mp3");
            if(playersJoined.size() > 1){
                Greenfoot.setWorld(new Controls(playersJoined));
            }
            else{
                Greenfoot.setWorld(new StartScreen());
            }
        }
    }
    public List<Integer> getPlayersJoined(){
        return this.playersJoined;
    }
}
