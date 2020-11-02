import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
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
            if(Greenfoot.getRandomNumber(100) < 50) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            else {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        else {
            random = Greenfoot.getRandomNumber(100);
            if(random < 2) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            if(random > 98) {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
    }
    
    public boolean atWorldEdge() {
        int x, i , y , wx, wy;
        
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
}
