import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Enemy
{
    int waitTime = 0;
    int moveTime = 0;
    int turnTime = 0;
    boolean turnP = false;
    protected void addedToWorld(World Crabworld) {
        while(isTouching(Rock.class) || !getObjectsInRange(200, Player.class).isEmpty()) {
            setLocation
            (
                getWorldOfType(CrabWorld.class).getRandom(getImage().getWidth(), getWorld().getWidth() - getImage().getWidth()), 
                getWorldOfType(CrabWorld.class).getRandom(getImage().getHeight(), getWorld().getHeight() - getImage().getHeight())
            );
        }
    }

    protected void moveEnemy() 
    {
        super.moveEnemy();
        //if wait time isn't zero, do nothing.
        if(waitTime > 0) 
        {
            waitTime -= 1;
            return;
        }
        //if turn time isn't zero, turn.
        if(turnTime > 0) 
        {
            if (turnP) 
            {
                turn(2);
            } else 
            {
                turn(-2);
            }
            turnTime-=1;
            return;
        }
        //if move time isn't zero, move.
        if(moveTime > 0) 
        {
            move(2);
            moveTime -= 1;
            return;
        }
        //chance the lobster will move, and a chance it will turn if it did not move.
        //if the lobster doesn't move or turn it waits in place for a random amount of cycles.
        if (Greenfoot.getRandomNumber(100) <= 75) 
        {
            moveTime = Greenfoot.getRandomNumber(100);
            return;
        } 
        else 
        if (Greenfoot.getRandomNumber(100) <= 50) 
        {
            turnTime = Greenfoot.getRandomNumber(90);
            if(Greenfoot.getRandomNumber(100) >= 50) 
            {
                turnP = false;
            } 
            else 
            {
                turnP = true;
            }
            return;
        } 
        else 
        {
            waitTime = Greenfoot.getRandomNumber(100);
            return;
        }

    }
}
