import greenfoot.*;;
public class Start_Screen extends World{
    public Start_Screen(){    
        super(1280, 720, 1); 
        prepare();
    }
    private void prepare()
    {
        Start_Button startButton = new Start_Button();
        addObject(startButton,608,595);
        JoinAstronaut joinAstro1 = new JoinAstronaut(1);
        addObject(joinAstro1, 200, 480);
        JoinAstronaut joinAstro2 = new JoinAstronaut(2);
        addObject(joinAstro2, 400, 480);
        JoinAstronaut joinAstro3 = new JoinAstronaut(3);
        addObject(joinAstro3, 880, 480);
        JoinAstronaut joinAstro4 = new JoinAstronaut(4);
        addObject(joinAstro4, 1080, 480);
    }
}
