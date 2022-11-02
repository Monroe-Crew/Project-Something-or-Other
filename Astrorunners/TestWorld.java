import greenfoot.*;
public class TestWorld extends World{
    public TestWorld(){    
        super(Constants.WIDTH, Constants.HEIGHT, 1); 
        prepare();
    }
    
    private void prepare(){
        TestWorldStage testWorldStage = new TestWorldStage();
        addObject(testWorldStage,640,750);
        Astronaut astronaut = new Astronaut(0);
        addObject(astronaut,720,359);
    }
}
