import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpawnPosition extends Actor
{
    // TODO: decide what we want to do with spawn positions
    
    public int playerNum;
    
    // constructs SpawnPosition
    public SpawnPosition(int playerNum){
        this.playerNum = playerNum;
        
        switch(playerNum){
            case 1: // blue
                // sets image of player spawn
            break;
            
            case 2: // green
                // sets image of player spawn
            break;
            
            case 3: // pink
                // sets image of player spawn
            break;
            
            default: // yellow
                // sets image of player spawn
        }
    }    
}
