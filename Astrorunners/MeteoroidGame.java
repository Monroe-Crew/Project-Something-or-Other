import greenfoot.*;
import java.util.*;
public class MeteoroidGame extends World{
    private int round;
    public static Music music;
    public MeteoroidGame(List<Integer> playersJoined, int round){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        prepare(playersJoined);
    }

    public MeteoroidGame(int round, List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1, false); 
        round++;
        this.round = round;
        altPrepare(allPlayers);
    }
    
    private void prepare(List<Integer> playersJoined){
        BlackHole blackHole = new BlackHole();
        addObject(blackHole, 640, 480);
        
        int numPlayers = playersJoined.size();

        Astronaut blueAstronaut = new Astronaut(1,2);
        Astronaut greenAstronaut = new Astronaut(2,2);
        Astronaut pinkAstronaut = new Astronaut(3,2);
        Astronaut yellowAstronaut = new Astronaut(4,2);
        
        MovingPlatform platform1 = new MovingPlatform(200, .5, 640, 480, 180);
        addObject(platform1, 490, 480);
        MovingPlatform platform2 = new MovingPlatform(200, .5, 640, 480, 270);
        addObject(platform2, 640, 330);
        MovingPlatform platform3 = new MovingPlatform(200, .5, 640, 480, 0);
        addObject(platform3, 790, 480);
        MovingPlatform platform4 = new MovingPlatform(200, .5, 640, 480, 90);
        addObject(platform4, 640, 630);
        MovingPlatform platform5 = new MovingPlatform(200, .5, 640, 480, 225);
        addObject(platform5, 490, 480);
        MovingPlatform platform6 = new MovingPlatform(200, .5, 640, 480, 315);
        addObject(platform6, 640, 330);
        MovingPlatform platform7 = new MovingPlatform(200, .5, 640, 480, 45);
        addObject(platform7, 790, 480);
        MovingPlatform platform8 = new MovingPlatform(200, .5, 640, 480, 135);
        addObject(platform8, 640, 630);
        MovingPlatform platform9 = new MovingPlatform(400, -.25, 640, 480, 180);
        addObject(platform9, 490, 480);
        MovingPlatform platform10 = new MovingPlatform(400, -.25, 640, 480, 270);
        addObject(platform10, 640, 330);
        MovingPlatform platform11 = new MovingPlatform(400, -.25, 640, 480, 0);
        addObject(platform11, 790, 480);
        MovingPlatform platform12 = new MovingPlatform(400, -.25, 640, 480, 90);
        addObject(platform12, 640, 630);
        MovingPlatform platform13 = new MovingPlatform(400, -.25, 640, 480, 210);
        addObject(platform13, 490, 480);
        MovingPlatform platform14 = new MovingPlatform(400, -.25, 640, 480, 240);
        addObject(platform14, 640, 330);
        MovingPlatform platform15 = new MovingPlatform(400, -.25, 640, 480, 300);
        addObject(platform15, 790, 480);
        MovingPlatform platform16 = new MovingPlatform(400, -.25, 640, 480, 330);
        addObject(platform16, 640, 630);
        MovingPlatform platform17 = new MovingPlatform(400, -.25, 640, 480, 30);
        addObject(platform17, 490, 480);
        MovingPlatform platform18 = new MovingPlatform(400, -.25, 640, 480, 60);
        addObject(platform18, 640, 330);
        MovingPlatform platform19 = new MovingPlatform(400, -.25, 640, 480, 120);
        addObject(platform19, 790, 480);
        MovingPlatform platform20 = new MovingPlatform(400, -.25, 640, 480, 150);
        addObject(platform20, 640, 630);
        
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
        
        Meteoroid meteoroid1 = new Meteoroid(262, -2, 640, 480, 1.5);
        addObject(meteoroid1, 0,0);
        Meteoroid meteoroid2 = new Meteoroid(437, -3, 640, 480, 1.5);
        addObject(meteoroid2, 0,0);
        Detector detect = new Detector(numPlayers, playersJoined, round);
        addObject(detect, 0, 0);
        Meteoroid meteoroid3 = new Meteoroid(550, -2, 640, 480, 1.5);
        addObject(meteoroid3, 0,0);
    }
    
    private void altPrepare(List<Astronaut> allPlayers){
        BlackHole blackHole = new BlackHole();
        addObject(blackHole, 640, 480);
        
        int numPlayers = allPlayers.size();
        
        MovingPlatform platform1 = new MovingPlatform(200, .5, 640, 480, 180);
        addObject(platform1, 490, 480);
        MovingPlatform platform2 = new MovingPlatform(200, .5, 640, 480, 270);
        addObject(platform2, 640, 330);
        MovingPlatform platform3 = new MovingPlatform(200, .5, 640, 480, 0);
        addObject(platform3, 790, 480);
        MovingPlatform platform4 = new MovingPlatform(200, .5, 640, 480, 90);
        addObject(platform4, 640, 630);
        MovingPlatform platform5 = new MovingPlatform(200, .5, 640, 480, 225);
        addObject(platform5, 490, 480);
        MovingPlatform platform6 = new MovingPlatform(200, .5, 640, 480, 315);
        addObject(platform6, 640, 330);
        MovingPlatform platform7 = new MovingPlatform(200, .5, 640, 480, 45);
        addObject(platform7, 790, 480);
        MovingPlatform platform8 = new MovingPlatform(200, .5, 640, 480, 135);
        addObject(platform8, 640, 630);
        MovingPlatform platform9 = new MovingPlatform(400, -.25, 640, 480, 180);
        addObject(platform9, 490, 480);
        MovingPlatform platform10 = new MovingPlatform(400, -.25, 640, 480, 270);
        addObject(platform10, 640, 330);
        MovingPlatform platform11 = new MovingPlatform(400, -.25, 640, 480, 0);
        addObject(platform11, 790, 480);
        MovingPlatform platform12 = new MovingPlatform(400, -.25, 640, 480, 90);
        addObject(platform12, 640, 630);
        MovingPlatform platform13 = new MovingPlatform(400, -.25, 640, 480, 210);
        addObject(platform13, 490, 480);
        MovingPlatform platform14 = new MovingPlatform(400, -.25, 640, 480, 240);
        addObject(platform14, 640, 330);
        MovingPlatform platform15 = new MovingPlatform(400, -.25, 640, 480, 300);
        addObject(platform15, 790, 480);
        MovingPlatform platform16 = new MovingPlatform(400, -.25, 640, 480, 330);
        addObject(platform16, 640, 630);
        MovingPlatform platform17 = new MovingPlatform(400, -.25, 640, 480, 30);
        addObject(platform17, 490, 480);
        MovingPlatform platform18 = new MovingPlatform(400, -.25, 640, 480, 60);
        addObject(platform18, 640, 330);
        MovingPlatform platform19 = new MovingPlatform(400, -.25, 640, 480, 120);
        addObject(platform19, 790, 480);
        MovingPlatform platform20 = new MovingPlatform(400, -.25, 640, 480, 150);
        addObject(platform20, 640, 630);
        
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
        
        Meteoroid meteoroid1 = new Meteoroid(262, -.25, 640, 480, 1.5);
        addObject(meteoroid1, 0,0);
        Meteoroid meteoroid2 = new Meteoroid(437, .5, 640, 480, 1.5);
        addObject(meteoroid2, 0,0);
        Detector detect = new Detector(numPlayers, playersJoined, round);
        addObject(detect, 0, 0);
        Meteoroid meteoroid3 = new Meteoroid(550, -2, 640, 480, 1.5);
        addObject(meteoroid3, 0,0);
    }
}
