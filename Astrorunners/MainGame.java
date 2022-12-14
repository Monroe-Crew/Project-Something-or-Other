import greenfoot.*;
import java.util.*;;
public class MainGame extends World{
    private int round;
    public static Music music;
    public MainGame(List<Integer> playersJoined, int round){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        prepare(playersJoined);
    }

    public MainGame(int round, List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        altPrepare(allPlayers);
    }

    private void prepare(List<Integer> playersJoined){
        // Constructs stage
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,640,480);
        music.gameMusic.playLoop(); 
        int numPlayers = playersJoined.size();

        Astronaut blueAstronaut = new Astronaut(1,0);
        Astronaut greenAstronaut = new Astronaut(2,0);
        Astronaut pinkAstronaut = new Astronaut(3,0);
        Astronaut yellowAstronaut = new Astronaut(4,0);

        Platform2 pinkStart = new Platform2();
        Platform2 yellowStart = new Platform2();
        Platform2 blueStart = new Platform2();
        Platform2 greenStart = new Platform2();

        switch(numPlayers){
            case 4: // Pink, Yellow
            addObject(yellowAstronaut,182,768);
            addObject(yellowStart,216,744);

            case 3: // Pink
            addObject(pinkAstronaut,105,630);
            addObject(pinkStart,167,607);

            default: // Blue Green
            addObject(blueAstronaut,182,212);
            addObject(greenAstronaut,119,340);
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
        addObject(blackHole,640,480);
        music.gameMusic.playLoop(); 
        for(int i = 0; i < allPlayers.size(); i++){
            int playerID = allPlayers.get(i).getPlayerID();
            if(playerID == 1){
                addObject(allPlayers.get(i),182,212);
                Platform2 blueStart = new Platform2();
                addObject(blueStart,216,235);
            }
            else if(playerID == 2){
                addObject(allPlayers.get(i),119,340);
                Platform2 greenStart = new Platform2();
                addObject(greenStart,167,363);
            }
            else if(playerID == 3){
                addObject(allPlayers.get(i),105,630);
                Platform2 pinkStart = new Platform2();
                addObject(pinkStart,167,607);
            }
            else if(playerID == 4){
                addObject(allPlayers.get(i),182,768);
                Platform2 yellowStart = new Platform2();
                addObject(yellowStart,216,744);
            }
        }
        List<Integer> playersJoined = new ArrayList<Integer>();
        for(int i = 0; i < allPlayers.size(); i++){
            playersJoined.add(allPlayers.get(i).getPlayerID());
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
        
        Goal goal = new Goal(allPlayers.size(), playersJoined, round);
        addObject(goal,1175,480);
    }
}
