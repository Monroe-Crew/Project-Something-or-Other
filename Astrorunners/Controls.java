import greenfoot.*;
import java.util.Random;
import java.util.List;

public class Controls extends World
{
    private int frame = 0;
    Random rand = new Random();
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
            switch(rand.nextInt(3)){
                case 2:
                    Greenfoot.setWorld(new MeteoroidGame(players, 0));
                    break;
                case 1:
                    Greenfoot.setWorld(new CometGame(players, 0));
                    break;
                default:
                    Greenfoot.setWorld(new MainGame(players, 0));
            }
        }
    }
}
