import greenfoot.*;
import java.util.*;
public class CometGame extends World{
    private int round;
    public CometGame(List<Integer> playersJoined, int round){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        prepare(playersJoined);
    }

    public CometGame(int round, List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        altPrepare(allPlayers);
    }
    
    private void prepare(List<Integer> playersJoined){
        BlackHole blackHole = new BlackHole();
        addObject(blackHole, 640, 480);
        
        int numPlayers = playersJoined.size();

        Astronaut blueAstronaut = new Astronaut(1);
        Astronaut greenAstronaut = new Astronaut(2);
        Astronaut pinkAstronaut = new Astronaut(3);
        Astronaut yellowAstronaut = new Astronaut(4);
        
        MovingPlatform platform1 = new MovingPlatform(150, 1, 640, 480, 180);
        addObject(platform1, 490, 480);
        
        switch(numPlayers){
            case 4: // Pink, Yellow
            addObject(yellowAstronaut,182,768);

            case 3: // Pink
            addObject(pinkAstronaut,105,630);

            default: // Blue Green
            addObject(blueAstronaut,182,212);
            addObject(greenAstronaut,119,340);
        }
    }
    
    private void altPrepare(List<Astronaut> allPlayers){
        
    }
}
