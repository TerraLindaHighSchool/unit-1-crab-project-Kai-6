import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if the food is on a rock, roll off the rock.
        if(isTouching(Rock.class)) 
        {
            move(1);
            if(isAtEdge()) 
            {
                setRotation(Greenfoot.getRandomNumber(360));
            }
        }
    }
}
