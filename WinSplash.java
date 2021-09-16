import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinSplash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinSplash extends World
{

    /**
     * Constructor for objects of class WinSplash.
     * 
     */
    public WinSplash()
    {    
        // Create a new world with 560x560 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        GreenfootImage image = new GreenfootImage("YOU WIN!!!", 120, Color.YELLOW, null);
        getBackground().drawImage(image, 300-image.getWidth()/2, 200-image.getHeight()/2);
    }
}
