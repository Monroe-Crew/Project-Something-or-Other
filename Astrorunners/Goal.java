import greenfoot.*;
import java.util.*;
public class Goal extends Platforms{
    private int players;
    private List<Integer> playersJoined;
    private List<Astronaut> allPlayers;
    private int round;
    public Goal(int players, List<Integer> playersJoined, int round){
        this.players = players;
        this.playersJoined = playersJoined;
        this.round = round;
        System.out.println(round);
    }
    
    public void addedToWorld(World world){
        this.allPlayers = getObjectsInRange(2000, Astronaut.class);
    }
    
    public void act() {
        removeTouching(Astronaut.class);
        List<Astronaut> alivePlayers = getObjectsInRange(2000, Astronaut.class);
        if(alivePlayers.size() < players){
            int winner = checkWinner(alivePlayers, playersJoined);
            System.out.println(winner);
            for(int i = 0; i < allPlayers.size(); i++){
                if(winner == allPlayers.get(i).getPlayerID() && round == 6){
                    allPlayers.get(i).setWins(allPlayers.get(i).getWins() + 1);
                    Greenfoot.setWorld(new EndScreen(allPlayers));
                }
                else if(winner == allPlayers.get(i).getPlayerID()){
                    allPlayers.get(i).setWins(allPlayers.get(i).getWins() + 1);
                    Greenfoot.setWorld(new Round_End(allPlayers, winner, this.round));
                }
            }
        }
    }

    public int checkWinner(List<Astronaut> alivePlayers, List<Integer> playersJoined){
        boolean detected = false;
        for(int i = 0; i < playersJoined.size(); i++){
            for(int k = 0; k < alivePlayers.size(); k++){
                if(playersJoined.get(i) == alivePlayers.get(k).getPlayerID()){
                    detected = true;
                }
            }
            if(!detected){
                return playersJoined.get(i);
            }
            detected = false;
        }
        return 0;
    }
}
