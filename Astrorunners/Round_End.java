import greenfoot.*;
import java.util.*;
public class Round_End extends World
{
    private List<Astronaut> allPlayers;
    private int winner;
    private int round;
    public Round_End(List<Astronaut> allPlayers, int winner, int round){    
        super(1280, 960, 1);
        this.winner = winner;
        this.allPlayers = allPlayers;
        this.round = round;
        System.out.println("Round End: " + round);
        if(round == 6){
            System.out.println("Should Set World");
            Greenfoot.setWorld(new EndScreen(allPlayers));
            System.out.println("Didn't");
        }
        prepare();
    }

    public void prepare(){
        PlayerScore winner = new PlayerScore("The Round Winner is: Player " + this.winner, 50);
        addObject(winner, 640, 100);
        Timer timer = new Timer(0,10,allPlayers,this.round);
        addObject(timer,0,0);
        for(int i = 0; i < allPlayers.size(); i++){
            int playerID = allPlayers.get(i).getPlayerID();
            int wins = allPlayers.get(i).getWins();
            if(playerID == 1){
                PlayerScore playerOneScore = new PlayerScore("Player 1's Score is " + wins, 20);
                addObject(playerOneScore, 640, 350);
            }
            else if(playerID == 2){
                PlayerScore playerTwoScore = new PlayerScore("Player 2's Score is " + wins, 20);
                addObject(playerTwoScore, 640, 500);
            }
            else if(playerID == 3){
                PlayerScore playerThreeScore = new PlayerScore("Player 3's Score is " + wins, 20);
                addObject(playerThreeScore, 640, 650);
            }
            else if(playerID == 4){
                PlayerScore playerFourScore = new PlayerScore("Player 4's Score is " + wins, 20);
                addObject(playerFourScore, 640, 800);
            }
        }
    }
}
