import greenfoot.*;
public class TestWorld extends World{
    public TestWorld(){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare();
    }

    private void prepare(){
        //Astronaut astronaut = new Astronaut();
        //addObject(astronaut,100,400);
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
        blackHole.setLocation(649,394);
        Astronaut astronaut = new Astronaut(1);
        addObject(astronaut,625,163);
        Platform1 platform1 = new Platform1();
        addObject(platform1,646,259);

        // instantiates playerScore actor
        
        PlayerScore player1 = new PlayerScore("Score " + );
        PlayerScore player2 = new PlayerScore("Score " + );
        PlayerScore player3 = new PlayerScore("Score " + );
        PlayerScore player4 = new PlayerScore("Score " + );
        
        int numPlayers;
        
        // TODO: Determine number of players
        
        // Instantiates player score at the top of the screen
        switch(numPlayers){
            case 4:
                addObject(player4, 0, 0);
                addObject(player3, 0, 0);
            case 3:
                addObject(player3, 0, 0);
            default:
                addObject(player2, 0, 0);
                addObject(player1, 0, 0);
        }

        
    }
}
