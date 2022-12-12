import greenfoot.*;
import java.util.*;
public class CometGame extends World{
    private int round;
    private int frame = 0;
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
        Ground ground = new Ground();
        addObject(ground, 640, 900);
        
        int numPlayers = playersJoined.size();

        Astronaut blueAstronaut = new Astronaut(1);
        Astronaut greenAstronaut = new Astronaut(2);
        Astronaut pinkAstronaut = new Astronaut(3);
        Astronaut yellowAstronaut = new Astronaut(4);
        
        switch(numPlayers){
            case 4: // Pink, Yellow
            addObject(yellowAstronaut,1040,816);

            case 3: // Pink
            addObject(pinkAstronaut,840,816);

            default: // Blue Green
            addObject(blueAstronaut,240,816);
            addObject(greenAstronaut,440,816);
        }
    }
    
    private void altPrepare(List<Astronaut> allPlayers){
        Ground ground = new Ground();
        addObject(ground, 640, 900);
    }
    
    public void act(){
        frame++;
        System.out.println(frame);
        if(frame % 120 == 0){
            System.out.println("run");
            addObject(new Comet(30, 5), 640, 480);
        }
    }
}