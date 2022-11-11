import greenfoot.*;
public class TestWorld extends World{
    public TestWorld(){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare();
    }
    
    private void prepare(){
        //Astronaut astronaut = new Astronaut();
        //addObject(astronaut,100,400);
        BlackHole blackHole = new BlackHole();
        addObject(blackHole,602,411);
        blackHole.setLocation(649,394);
        Astronaut astronaut = new Astronaut(1);
        addObject(astronaut,625,163);
        Platform1 platform1 = new Platform1();
        addObject(platform1,646,259);
    }
}
