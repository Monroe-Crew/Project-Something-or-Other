import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class EndScreen extends World{
    private List<Astronaut> allPlayers;
    public static Music music;
    List<Integer> playersJoined = new ArrayList<Integer>();
    public EndScreen(List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1);
        this.allPlayers = allPlayers;
        for(int i = 0; i < allPlayers.size(); i++){
            playersJoined.add(allPlayers.get(i).getPlayerID());
        }
        prepare();
    }

    public void prepare(){
        music.stopAllMusic(); 
        setBackground("EndScreen.png");
        Astronaut gameWinner = allPlayers.get(0);
        for(int i = 1; i < allPlayers.size(); i++){
            if(gameWinner.getWins() < allPlayers.get(i).getWins()){
                gameWinner = allPlayers.get(i);
            }
        }
        int gameWinnerPlayerID = gameWinner.getPlayerID();
        PlayerScore gameWinnerScore = new PlayerScore("Your Game Winner is: Player " + gameWinnerPlayerID, 50);
        addObject(gameWinnerScore, 640, 380);
        PlayerScore gameWinnerScore1 = new PlayerScore("Player 1 Press Start To Play Again!", 50);
        addObject(gameWinnerScore1, 640, 580);
        setBackground("Main Background.png");
    }

    public void act(){
        if(Greenfoot.isKeyDown("1")){
            Greenfoot.setWorld(new Controls(playersJoined));
        }
    }
}
