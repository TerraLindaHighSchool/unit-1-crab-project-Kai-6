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
            setLocation(getX()+3, getY());
        }

        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-3, getY());
        }
        
        if(Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-3);
        }
        
         if(Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+3);
        }
    }
    // Checks for collisions with other objects
    private void onCollision()
    {
        if(isTouching(Worm.class))
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");         
            // Winning the game
            if(getWorld().getObjects(Worm.class).size() == 0)
            {
                Greenfoot.setWorld(new WinSplash());
                Greenfoot.playSound("fanfare.wav");
                Greenfoot.stop();
            }
        }
        //losing the game
        if(isTouching(Lobster.class)) {
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }
    }
}

