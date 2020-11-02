import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    
    public Garp() 
    {
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");        
    }
    
    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")) {
            setRotation(0);
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            move(5);
        }
        
        if(Greenfoot.isKeyDown("left")) {
            if(getImage() != imageLeft) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
        }
        
        if(Greenfoot.isKeyDown("up")) {
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            setRotation(-90);
            move(5);
        }
        
        if(Greenfoot.isKeyDown("down")) {
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            setRotation(90);
            move(5);
        }
    }    
}
