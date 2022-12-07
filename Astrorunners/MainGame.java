import greenfoot.*;
import java.util.*;;
public class MainGame extends World{
    private int round;

    public MainGame(List<Integer> playersJoined, int round){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        prepare(playersJoined);
    }

    public MainGame(int round, List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        round++;
        this.round = round;
        altPrepare(allPlayers);
    }

    private void prepare(List<Integer> playersJoined){
        // Constructs stage
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,640,480);

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
            addObject(pinkStart,167,607);
            addObject(yellowStart,216,725);

            case 3: // Pink
            addObject(pinkAstronaut,125,576);
            addObject(pinkStart,167,607);

            default: // Blue Green
            addObject(blueAstronaut,125,192);
            addObject(greenAstronaut,125,384);
            addObject(blueStart,216,235);
            addObject(greenStart,167,363);
        }
        
        Platform1 platform1 = new Platform1();
        addObject(platform1, 415, 480);
        Platform1 platform2 = new Platform1();
        addObject(platform2, 640, 255);
        Platform1 platform3 = new Platform1();
        addObject(platform3, 640, 705);
        Platform1 platform4 = new Platform1();
        addObject(platform4, 481, 321);
        Platform1 platform5 = new Platform1();
        addObject(platform5, 481, 639);
        Platform1 platform6 = new Platform1();
        addObject(platform6, 799, 321);
        Platform1 platform7 = new Platform1();
        addObject(platform7, 799, 639);
        
        Meteoroid meteoroid = new Meteoroid(500, -2.5, 1520, 480, 3);
        addObject(meteoroid, 1045, 480);
        //(150,150);
        
        Goal goal = new Goal(numPlayers, playersJoined, round);
        addObject(goal,1175,480);
    }

    private void altPrepare(List<Astronaut> allPlayers){ //takes in a list of the astronauts for after round updates.
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
