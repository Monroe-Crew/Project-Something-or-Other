import greenfoot.*;
import java.util.*;;
public class MainGame extends World{
    private int round;
    
    public MainGame(List<Integer> playersJoined, int round){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        round++;
        this.round = round;
        prepare(playersJoined);
    }
    
    public MainGame(int round, List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        round++;
        this.round = round;
        prepareOther(allPlayers);
    }

    private void prepare(List<Integer> playersJoined){
        // Constructs stage
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
        
        int numPlayers = playersJoined.size();
        for(int i = 0; i < numPlayers; i++){
            if(playersJoined.get(i) == 1){
                Astronaut blueAstronaut = new Astronaut(1);
                addObject(blueAstronaut,125,192);
                Astronaut.setspawnX(125);
                Astronaut.setspawnY(192);
                Platform2 blueStart = new Platform2();
                addObject(blueStart,175,192);
            }
            else if(playersJoined.get(i) == 2){
                Astronaut greenAstronaut = new Astronaut(2);
                addObject(greenAstronaut,125,384);
                Astronaut.setspawnX(125);
                Astronaut.setspawnY(384);
                Platform2 greenStart = new Platform2();
                addObject(greenStart,175,384);
            }
            else if(playersJoined.get(i) == 3){
                Astronaut pinkAstronaut = new Astronaut(3);
                addObject(pinkAstronaut,125,576);
                Astronaut.setspawnX(125);
                Astronaut.setspawnY(576);
                Platform2 pinkStart = new Platform2();
                addObject(pinkStart,175,576);
            }
            else if(playersJoined.get(i) == 4){
                Astronaut yellowAstronaut = new Astronaut(4);
                addObject(yellowAstronaut,125,768);
                Astronaut.setspawnX(125);
                Astronaut.setspawnY(768);
                Platform2 yellowStart = new Platform2();
                addObject(yellowStart,175,768);
            }
        }    
        Goal goal = new Goal(numPlayers, playersJoined, round);
        addObject(goal,1186,409);
    }
    
    private void prepareOther(List<Astronaut> allPlayers){
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
        
        for(int i = 0; i < allPlayers.size(); i++){
            int playerID = allPlayers.get(i).getPlayerID();
            if(playerID == 1){
                addObject(allPlayers.get(i),125,192);
                Platform2 blueStart = new Platform2();
                addObject(blueStart,175,192);
            }
            else if(playerID == 2){
                addObject(allPlayers.get(i),125,384);
                Platform2 greenStart = new Platform2();
                addObject(greenStart,175,384);
            }
            else if(playerID == 3){
                addObject(allPlayers.get(i),125,576);
                Platform2 pinkStart = new Platform2();
                addObject(pinkStart,175,576);
            }
            else if(playerID == 4){
                addObject(allPlayers.get(i),125,768);
                Platform2 yellowStart = new Platform2();
                addObject(yellowStart,175,768);
            }
        }
        List<Integer> playersJoined = new ArrayList<Integer>();
        for(int i = 0; i < allPlayers.size(); i++){
            playersJoined.add(allPlayers.get(i).getPlayerID());
        }
        Goal goal = new Goal(allPlayers.size(), playersJoined, round);
        addObject(goal,1186,409);
    }
}
