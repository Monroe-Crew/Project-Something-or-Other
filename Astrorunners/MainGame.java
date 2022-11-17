import greenfoot.*;
import java.util.List;
public class MainGame extends World{
    public MainGame(List<Integer> playersJoined){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare(playersJoined);
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
                Platform2 blueStart = new Platform2();
                addObject(blueStart,175,192);
            }
            else if(playersJoined.get(i) == 2){
                Astronaut greenAstronaut = new Astronaut(2);
                addObject(greenAstronaut,125,384);
                Platform2 greenStart = new Platform2();
                addObject(greenStart,175,384);
            }
            else if(playersJoined.get(i) == 3){
                Astronaut pinkAstronaut = new Astronaut(3);
                addObject(pinkAstronaut,125,576);
                Platform2 pinkStart = new Platform2();
                addObject(pinkStart,175,576);
            }
            else if(playersJoined.get(i) == 4){
                Astronaut yellowAstronaut = new Astronaut(4);
                addObject(yellowAstronaut,125,768);
                Platform2 yellowStart = new Platform2();
                addObject(yellowStart,175,768);
            }
        }    
        Goal goal = new Goal();
        addObject(goal,1186,409);
    }
}
