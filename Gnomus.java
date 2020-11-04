import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    public Gnomus() {
        setRotation();
    }
    
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int random;
        
        move(5);
        if(atWorldEdge()) {
            move(-5);
            setRotation();
        }
        foundGarp();
        foundActor();
    }
    
    protected void setRotation() {
        if(Greenfoot.getRandomNumber(100) < 50) {
            setRotation(getRotation() + Greenfoot.getRandomNumber(180));
        }
        else {
            setRotation(getRotation() - Greenfoot.getRandomNumber(180));
        }
    }
    
    public boolean atWorldEdge() {
        int x, y, i, wx, wy;
        
        x = getX();
        y = getY();
        i = getImage().getWidth() / 2;
        wx = getWorld().getWidth() - i;
        wy = getWorld().getHeight() - i;
        if(x <= i || y <= i || x >= wx || y >= wy) {
            return true;    
        }
        return false;
    }
    
    protected void foundActor() {
        Actor actor;
        actor = getOneObjectAtOffset(0, 0, Actor.class);
        if(actor != null) {
            turn(90);
        }
    }
    
    protected void foundGarp() {
        Actor garp;
        garp = getOneObjectAtOffset(1, 1, Garp.class);
        if(garp != null) {
            Greenfoot.playSound("scream.mp3");
            getWorld().removeObject(garp);
            Greenfoot.stop();
        }
    }
}
