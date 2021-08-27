import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Lobster is the crab's enemy
 * 
 * @author Kai Schneider
 * @version 8/26/2021
 */
public class Lobster extends Actor
{
    //makes the lobster do stuff
    public void act()
    {
        //moves lobster
        move(3);
        turnAtEdge();
    }
    
    //turns the lobster at edge
    private void turnAtEdge() 
    {
        if(isAtEdge())
        {
            turn(Greenfoot.getRandomNumber(50));
        }
    }
}
