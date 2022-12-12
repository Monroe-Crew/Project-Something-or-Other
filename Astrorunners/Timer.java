import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Timer extends Actor{
    int frame = 0;
    int seconds;
    int minutes;
    GreenfootImage image;
    private List<Astronaut> allPlayers;
    private int round;
    Random rand = new Random();
    
    public Timer(int m, int s, List<Astronaut> allPlayers, int round) {
        seconds=s;
        minutes=m;
        updateImage();
        this.allPlayers = allPlayers;
        this.round = round;
        System.out.println(round);
    }

    public void updateImage() {
        image = new GreenfootImage(200,100);
        image.setColor(new Color(0,0,0));
        image.setFont(new Font("Arial", true, false, 50));
        String s = minutes+":";
        if(seconds<10){
            s += "0"+seconds;
        }
        else{
            s+=seconds;
        }
        if(seconds==-1){
            seconds=59;
            minutes--;
            s = minutes+":";
            s+=seconds;
        }
        if(minutes==-1){
            switch(rand.nextInt(3)){
                case 2:
                    for(int i = 0; i < allPlayers.size(); i++){
                        allPlayers.get(i).setGameID(2);
                    }
                    Greenfoot.setWorld(new MeteoroidGame(round, allPlayers));
                    break;
                case 1:
                    for(int i = 0; i < allPlayers.size(); i++){
                        allPlayers.get(i).setGameID(2);
                    }
                    Greenfoot.setWorld(new CometGame(round, allPlayers));
                    break;
                default:
                    for(int i = 0; i < allPlayers.size(); i++){
                        allPlayers.get(i).setGameID(2);
                    }
                    Greenfoot.setWorld(new MainGame(round, allPlayers));
            }
        }
        image.drawString(s, 5, 100);
        setImage(image);
    }

    public void act(){
        frame++;
        if(frame % 60 == 0) {
            seconds--;
            updateImage();
        }
    }    
}