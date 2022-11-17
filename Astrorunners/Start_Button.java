import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
public class Start_Button extends Actor
{
    public List<Integer> playersJoined = new ArrayList<Integer>();
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            System.out.println(playersJoined);
            Greenfoot.setWorld(new MainGame(playersJoined));
        }
    }
    public List<Integer> getPlayersJoined(){
        return this.playersJoined;
    }
}
