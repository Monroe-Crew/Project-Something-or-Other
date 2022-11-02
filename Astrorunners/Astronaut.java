import greenfoot.*;
public class Astronaut extends Actor{
    private static double velocity;
    private double x, y;
    public Astronaut(double velocity){
        this.velocity = 0;
    }
    public void addedToWorld(World world) {
        x = getX();
        y = getY();
    }
    public void act() {
        
        velocity += Constants.GRAVITY;
        y += velocity;
        setLocation((int)Math.round(x), (int)Math.round(y));
        
        
        
        //velocity = gravityAcceleration(Constants.GRAVITY, velocity);
        //gravity(velocity);
    }
    public double gravityAcceleration(double gravity, double velocity){
        return velocity + gravity;
    }
    public void gravity(double velocity){
        setLocation(getX(), getY() + (int)velocity);
    }
}
