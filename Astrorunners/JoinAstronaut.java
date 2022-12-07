import greenfoot.*;
import java.util.*;
public class JoinAstronaut extends Actor{
    private boolean joined = false;
    private boolean playerOneJoined = false;
    private boolean playerTwoJoined = false;
    private boolean playerThreeJoined = false;
    private boolean playerFourJoined = false;
    private int playerID;
    public JoinAstronaut(int playerID){
        this.playerID = playerID;
    }
    public void act(){
        List<Start_Button> startbuttons = getObjectsInRange(2000, Start_Button.class);
        if(Greenfoot.isKeyDown("1") && !playerOneJoined  && playerID == 1){
            joined = true;
            playerOneJoined = true;
            setImage("Blue Astronaut.png");
            startbuttons.get(0).playersJoined.add(this.playerID);
            System.out.println("Player One Joined");
        }
        else if(Greenfoot.isKeyDown("2") && !playerTwoJoined && playerID == 2){
            joined = true;
            playerTwoJoined = true;
            setImage("Blue Astronaut.png");
            startbuttons.get(0).playersJoined.add(this.playerID);
            System.out.println("Player Two Joined");
        }
        else if(Greenfoot.isKeyDown("3") && !playerThreeJoined && playerID == 3){
            joined = true;
            playerThreeJoined = true;
            setImage("Blue Astronaut.png");
            startbuttons.get(0).playersJoined.add(this.playerID);
            System.out.println("Player Three Joined");
        }
        else if(Greenfoot.isKeyDown("4") && !playerFourJoined && playerID == 4){
            joined = true;
            playerFourJoined = true;
            setImage("Blue Astronaut.png");
            startbuttons.get(0).playersJoined.add(this.playerID);
            System.out.println("Player Four Joined");
        }
    }
}
