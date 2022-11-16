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
    }
}
