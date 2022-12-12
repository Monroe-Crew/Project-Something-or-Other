import greenfoot.*;
import java.util.Random;
import java.util.List;

public class Controls extends World
{
    private int frame = 0;
    private List<Integer> players;
    public Controls(List<Integer> playersJoined)
    {    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        setBackground("Controls Screen.png");
        players = playersJoined;
    }

    public void act(){
        frame++;
        if(frame == 300){
            Greenfoot.setWorld(new ExplainationScreen(players));
        }
    }
}
