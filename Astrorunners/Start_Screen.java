import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game_Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_Screen extends World
{

    /**
     * Constructor for objects of class Game_Select.
     * 
     */
    public Start_Screen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start_Button start_Button = new Start_Button();
        addObject(start_Button,608,595);
    }
}
