import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
        movingAndTurning();
        collectingDiamonds();
        foundbomb();
    }

    protected void movingAndTurning() {
        if(Greenfoot.isKeyDown("right")) {
            setRotation(0);
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            setRotation(0);
            move(5);
            if(foundRock()) {
                move(-5);
            }
        }
        
        if(Greenfoot.isKeyDown("left")) {
            if(getImage() != imageLeft) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
            if(foundRock()) {
                move(5);
            }
        }
        
        if(Greenfoot.isKeyDown("up")) {
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            setRotation(-90);
            move(5);
            if(foundRock()) {
                move(-5);
            }
        }
        
        if(Greenfoot.isKeyDown("down")) {
            if(getImage() != imageRight) {
                setImage(imageRight);
            }
            setRotation(90);
            move(5);
            if(foundRock()) {
                move(-5);
            }
        }
    }    
    
    protected void collectingDiamonds() {
        Actor diamond;
        diamond = getOneObjectAtOffset(0, 0, Diamond.class);
        
        if(this.isTouching(Diamond.class)) {
            getWorld().removeObject(diamond);
        }
    }
    
    protected boolean foundRock() {
        Actor rock;
        rock = getOneObjectAtOffset(0,0, Rock.class);
        if(rock != null) {
            return true;
        }
        return false;
    }
    
    protected void foundbomb() {
        Actor bomb;
        
        bomb = getOneObjectAtOffset(0,0, Bomb.class);
        if(bomb != null) {
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}