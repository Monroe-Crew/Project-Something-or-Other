import greenfoot.*;
import java.util.*;
public class Detector extends Actor{
    private int players;
    private List<Integer> playersJoined;
    private List<Astronaut> allPlayers;
    private int round;
    public Detector(int players, List<Integer> playersJoined, int round){
        this.players = players;
        this.playersJoined = playersJoined;
        this.round = round;
        System.out.println(round);
    }
    
    public void addedToWorld(World world){
        this.allPlayers = getObjectsInRange(2000, Astronaut.class);
    }
    
    public void act() {
        List<Astronaut> alivePlayers = getObjectsInRange(2000, Astronaut.class);
        if(alivePlayers.size() == 1){
            if(round == 6){
                alivePlayers.get(0).setWins(alivePlayers.get(0).getWins() + 1);
                Greenfoot.setWorld(new EndScreen(allPlayers));
            }
            else{
                alivePlayers.get(0).setWins(alivePlayers.get(0).getWins() + 1);
                Greenfoot.setWorld(new Round_End(allPlayers, alivePlayers.get(0).getPlayerID(), this.round));
            }
        }
    }
}