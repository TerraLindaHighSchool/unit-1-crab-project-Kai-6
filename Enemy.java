import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public void act()
    {
        moveEnemy();
        if(isTouching(Rock.class) || isAtEdge()) 
        {
            move(-4);
            turn(Greenfoot.getRandomNumber(200) + 60);
            return;
        }
    }

    protected void moveEnemy() 
    {
    }
}
