import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int diamonds = getWorld().getObjects(Diamond.class).size();
        int points = (diamonds *= -1) + 10;
        this.setImage(new GreenfootImage("" + points, 50, Color.WHITE,new Color(0, 0, 0, 0)));    
        
        if(points >= 10) {
            Greenfoot.playSound("scream.mp3");
            Greenfoot.stop();
        }
    }    
}