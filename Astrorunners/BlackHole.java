import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class BlackHole extends Actor{
    private ParticleEffect effect;
    
    public BlackHole(){
    this.effect = new ParticleEffect(80,new Color(148, 3, 252,255));
    }
    
    public void addedToWorld(World world){
    getWorld().setPaintOrder(BlackHole.class, Particle.class);
    getWorld().addObject(effect,getX(),getY());
    }
    
    public void act() 
    {
        effect.generateParticles(100);
    }    
}
