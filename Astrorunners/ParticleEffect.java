import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParticleEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParticleEffect extends Actor
{
    private Color color;
    private int radius;
    private int frame = 0;
    public ParticleEffect(int radius, Color color){
        this.color = color;
        this.radius = radius;
        getImage().setTransparency(0);
    }

    public void generateParticles(int amount){
        frame++;
        if(frame > 60 / amount){
            Particle particle = new Particle(radius,1,5,5,color, getX(), getY());
            getWorld().addObject(particle, getX(), getY());
            frame = 0;
        }
    }
}
