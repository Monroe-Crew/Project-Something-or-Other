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
        
        MovingPlatform platform1 = new MovingPlatform(175, .5, 640, 480, 180);
        addObject(platform1, 490, 480);
        MovingPlatform platform2 = new MovingPlatform(175, .5, 640, 480, 270);
        addObject(platform2, 640, 330);
        MovingPlatform platform3 = new MovingPlatform(175, .5, 640, 480, 0);
        addObject(platform3, 790, 480);
        MovingPlatform platform4 = new MovingPlatform(175, .5, 640, 480, 90);
        addObject(platform4, 640, 630);
        MovingPlatform platform5 = new MovingPlatform(175, .5, 640, 480, 225);
        addObject(platform5, 490, 480);
        MovingPlatform platform6 = new MovingPlatform(175, .5, 640, 480, 315);
        addObject(platform6, 640, 330);
        MovingPlatform platform7 = new MovingPlatform(175, .5, 640, 480, 45);
        addObject(platform7, 790, 480);
        MovingPlatform platform8 = new MovingPlatform(175, .5, 640, 480, 135);
        addObject(platform8, 640, 630);
        MovingPlatform platform9 = new MovingPlatform(350, -.25, 640, 480, 180);
        addObject(platform9, 490, 480);
        MovingPlatform platform10 = new MovingPlatform(350, -.25, 640, 480, 270);
        addObject(platform10, 640, 330);
        MovingPlatform platform11 = new MovingPlatform(350, -.25, 640, 480, 0);
        addObject(platform11, 790, 480);
        MovingPlatform platform12 = new MovingPlatform(350, -.25, 640, 480, 90);
        addObject(platform12, 640, 630);
        MovingPlatform platform13 = new MovingPlatform(350, -.25, 640, 480, 210);
        addObject(platform13, 490, 480);
        MovingPlatform platform14 = new MovingPlatform(350, -.25, 640, 480, 240);
        addObject(platform14, 640, 330);
        MovingPlatform platform15 = new MovingPlatform(350, -.25, 640, 480, 300);
        addObject(platform15, 790, 480);
        MovingPlatform platform16 = new MovingPlatform(350, -.25, 640, 480, 330);
        addObject(platform16, 640, 630);
        MovingPlatform platform17 = new MovingPlatform(350, -.25, 640, 480, 30);
        addObject(platform17, 490, 480);
        MovingPlatform platform18 = new MovingPlatform(350, -.25, 640, 480, 60);
        addObject(platform18, 640, 330);
        MovingPlatform platform19 = new MovingPlatform(350, -.25, 640, 480, 120);
        addObject(platform19, 790, 480);
        MovingPlatform platform20 = new MovingPlatform(350, -.25, 640, 480, 150);
        addObject(platform20, 640, 630);
        
        switch(numPlayers){
            case 4: // Pink, Yellow
            addObject(yellowAstronaut,640,680);

            case 3: // Pink
            addObject(pinkAstronaut,840,480);

            default: // Blue Green
            addObject(blueAstronaut,440,480);
            addObject(greenAstronaut,640,280);
        }
        
        Meteoroid meteoroid1 = new Meteoroid(262, -.25, 640, 480, 1.5);
        addObject(meteoroid1, 0,0);
        Meteoroid meteoroid2 = new Meteoroid(437, .5, 640, 480, 1.5);
        addObject(meteoroid2, 0,0);
    }
    
    private void altPrepare(List<Astronaut> allPlayers){
        
    }
}
