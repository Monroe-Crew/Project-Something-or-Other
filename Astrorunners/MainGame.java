import greenfoot.*;
public class MainGame extends World{
    public MainGame(){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare();
    }

    private void prepare(){
        // Constructs stage
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
<<<<<<< Updated upstream

        int numPlayers = 2;

        /**
         * TODO: IMPLEMENT DETERMINATION OF NO. OF PLAYERS
         */
        
        Astronaut blueAstronaut = new Astronaut();
        Astronaut greenAstronaut = new Astronaut();
        // Astronaut 3
        // Astronaut 4

        PlayerScore player1Score = new PlayerScore(" ");
        PlayerScore player2Score = new PlayerScore(" ");
        PlayerScore player3Score = new PlayerScore(" ");
        PlayerScore player4Score = new PlayerScore(" ");

        switch(numPlayers){
            case 4:
            //Instantiates score for 3rd and 4th player
            addObject(player4Score, 0, 0);
            addObject(player3Score, 0, 0);
            //Instantiates 3rd and 4th player astronauts
            //addObject(astronaut4)
            //addObject(astronaut3)
            
            case 3:
            //Instantiates score for 3rd player
            addObject(player3Score, 0, 0);
            //addObject(astronaut3)
            
            default:
            //Instantiates score for 1st and 2nd player
            addObject(player2Score, 0, 0);
            addObject(player1Score, 0, 0);
            //Instantiates 2 player astronauts
            addObject(blueAstronaut, 0, 0);
            addObject(greenAstronaut, 0, 0);
            
        }
=======
        Goal goal = new Goal();
        addObject(goal,1186,409);
>>>>>>> Stashed changes
    }
}
