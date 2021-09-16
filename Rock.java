import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    protected void addedToWorld(World Crabworld) {
        while(isTouching(Rock.class) || isTouching(Player.class)) {
            setLocation
            (
                getWorldOfType(CrabWorld.class).getRandom(getImage().getWidth(), getWorld().getWidth() - getImage().getWidth()), 
                getWorldOfType(CrabWorld.class).getRandom(getImage().getHeight(), getWorld().getHeight() - getImage().getHeight())
            );
        }
    }

    public void act()
    {
    }
}
