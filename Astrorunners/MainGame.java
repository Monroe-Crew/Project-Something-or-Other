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

        int numPlayers = playersJoined.size();

        Astronaut blueAstronaut = new Astronaut(1);
        Astronaut greenAstronaut = new Astronaut(2);
        Astronaut pinkAstronaut = new Astronaut(3);
        Astronaut yellowAstronaut = new Astronaut(4);

        Platform2 pinkStart = new Platform2();
        Platform2 yellowStart = new Platform2();
        Platform2 blueStart = new Platform2();
        Platform2 greenStart = new Platform2();

        switch(numPlayers){
            case 4: // Pink, Yellow
            addObject(pinkAstronaut,125,576);
            addObject(yellowAstronaut,125,768);
            addObject(pinkStart,175,576);
            addObject(yellowStart,175,768);

            case 3: // Pink
            addObject(pinkAstronaut,125,576);
            addObject(pinkStart,175,576);

            default: // Blue Green
            addObject(blueAstronaut,125,192);
            addObject(greenAstronaut,125,384);
            addObject(blueStart,175,192);
            addObject(greenStart,175,384);
        }
        
        Goal goal = new Goal(numPlayers, playersJoined, round);
        addObject(goal,1186,409);
    }

    private void prepareOther(List<Astronaut> allPlayers){
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
