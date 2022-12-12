import greenfoot.*;
import java.util.*;
public class CometGame extends World{
    private int round;
    public static Music music;
    private int frame = 0;
    private int frequency = 300;
    Random rand = new Random();
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
        int numPlayers = playersJoined.size();
        
        Ground ground = new Ground(numPlayers, playersJoined, round);
        addObject(ground, 640, 900);
        
        setPaintOrder(Ground.class, Comet.class);

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
        int numPlayers = allPlayers.size();
        
        music.gameMusic.playLoop(); 
        for(int i = 0; i < allPlayers.size(); i++){
            int playerID = allPlayers.get(i).getPlayerID();
            if(playerID == 1){
                addObject(allPlayers.get(i),240,816);
            }
            else if(playerID == 2){
                addObject(allPlayers.get(i),440,816);
            }
            else if(playerID == 3){
                addObject(allPlayers.get(i),840,816);
            }
            else if(playerID == 4){
                addObject(allPlayers.get(i),1040,816);
            }
        }
        List<Integer> playersJoined = new ArrayList<Integer>();
        for(int i = 0; i < allPlayers.size(); i++){
            playersJoined.add(allPlayers.get(i).getPlayerID());
        }
        
        Ground ground = new Ground(numPlayers, playersJoined, round);
        addObject(ground, 640, 900);
    }
    
    public void act(){
        frame++;
        //System.out.println(frame);
        if(frame % frequency == 0){            
            addObject(new Comet(rand.nextInt(90) + 46, .5, 1.5), rand.nextInt(880) + 201, -100);
        }
        if(frame % 600 == 0){
            frequency /= 2;
        }
    }
}