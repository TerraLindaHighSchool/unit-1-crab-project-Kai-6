import greenfoot.*;

/**
 * This class defines a crab, and controls said crab.
 * @author Kai Schneider
 * @version 8/26/2021
 */
public class Crab extends Actor
{
    // This method repeats the following actions
    public void act( )
    {
        move(5);
        turnAtEdge();
        checkKeyPress();
        onCollision();
    }

    // Moves the Crab

    // Turns the Crab at the edge
    private void turnAtEdge() 
    {
        if(isAtEdge()) 
        {
            turn(50);
        }
    }
    // Checks for user key presses so user can turn the Crab
    private  void checkKeyPress() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            turn(4);
        }

        if(Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }
    }
    // Checks for collisions with other objects
    private void onCollision()
    {

    }
}

