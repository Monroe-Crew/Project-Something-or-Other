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
        Astronaut astronaut = new Astronaut();
        addObject(astronaut,83,374);
        Platform1 platform1 = new Platform1();
        addObject(platform1,186,379);
        Platform1 platform12 = new Platform1();
        addObject(platform12,666,191);
        Platform1 platform13 = new Platform1();
        addObject(platform13,956,390);
        Platform1 platform14 = new Platform1();
        addObject(platform14,668,546);
    }
}
