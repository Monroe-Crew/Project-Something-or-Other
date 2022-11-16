import greenfoot.*;
public class MainGame extends World{
    public MainGame(){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare();
    }
    
    private void prepare(){
        //Astronaut astronaut = new Astronaut();
        //addObject(astronaut,100,400);
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
        
        int numPlayers;
        
        PlayerScore player1Score = new PlayerScore("");
        PlayerScore player2Score = new PlayerScore("");
        PlayerScore player3Score = new PlayerScore("");
        PlayerScore player4Score = new PlayerScore("");
        
        switch(numPlayers){
            case 4:
                addObject(player4Score, 0, 0);
                addObject(player3Score, 0, 0);
            case 3:
                addObject(player3Score, 0, 0);
            default:
                addObject(player2Score, 0, 0);
                addObject(player1Score, 0, 0);
        }
    }
}
