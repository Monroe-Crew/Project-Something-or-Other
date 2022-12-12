import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class EndScreen extends World{
    private List<Astronaut> allPlayers;
    public static Music music;
    public EndScreen(List<Astronaut> allPlayers){    
        super(Constants.WIDTH, Constants.HEIGHT, 1);
        this.allPlayers = allPlayers;
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
        addObject(gameWinnerScore, 640, 480);
        setBackground("Main Background.png");
    }
}
