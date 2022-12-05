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
                this.setImage("BlueSpawn.png");
            break;
            
            case 2: // green
                this.setImage("GreenSpawn.png");
            break;
            
            case 3: // pink
                this.setImage("PinkSpawn.png");
            break;
            
            default: // yellow
                this.setImage("YellowSpawn.png");
        }
    }    
}
