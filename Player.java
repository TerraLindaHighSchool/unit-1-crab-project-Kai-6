import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    boolean shielded = false;
    boolean godmode = false;
    int shieldTime = 0;
    public int score = 0;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //show score as text at the top of the screen
        getWorld().showText("Score: " + score, getWorld().getWidth() / 2, 20);
        //collision with rocks
        if(isTouching(Rock.class)) 
        {
            move(-3);
        }
        eat();
        keyPressed();
    }

    private void eat() 
    {
        //touch food, add score and play a sound effect
        if(isTouching(Food.class)) 
        {
            Greenfoot.playSound("slurp.wav");
            removeTouching(Food.class);
            score += 1;
        }
        //checking if you are in Godmode or if you have a shield, and if so, then lobsters can't hurt you
        if(!shielded && !godmode) 
        {
            //lose state.
            if(isTouching(Lobster.class)) 
            {
                Greenfoot.playSound("Explosion.wav");
                setImage("explosion.png");
                Greenfoot.stop();
            }
        } 
        else 
        {
            if(shieldTime <= 0 && !godmode) {
                setImage("turtle.png");
                Greenfoot.playSound("PowerDown.wav");
                shielded = false;
            }
            if(!godmode) {
                getWorld().showText("Shield Left: " + shieldTime, getWorld().getWidth() / 2, 40);
                shieldTime -= 1;
            } else {
                getWorld().showText("Shield Left: GODMODE", getWorld().getWidth() / 2, 40);
            }
        }
        //touching powerups gives you 600 cycles of invincibility
        if(isTouching(PowerUp.class)) 
        {
            removeTouching(PowerUp.class);
            Greenfoot.playSound("PowerUp.wav");
            setImage("turtleShielded.png");
            shieldTime += 600;
            shielded = true;
        }
        //every 5 score, a new lobster spawns
        if((score % 5) == 0 && getWorld().getObjects(Lobster.class).size() < Math.round(score / 5 + 3)) 
        {
            Lobster lobster = new Lobster();
            lobster.setRotation(Greenfoot.getRandomNumber(360));
            getWorld().addObject
            (
                lobster, 
                getWorldOfType(CrabWorld.class).getRandom(lobster.getImage().getWidth(), getWorld().getWidth() - lobster.getImage().getWidth()), 
                getWorldOfType(CrabWorld.class).getRandom(lobster.getImage().getHeight(), getWorld().getHeight() - lobster.getImage().getHeight())
            );
        }
        //win state
        if(score == 50) {
            WinSplash win = new WinSplash();
            Greenfoot.setWorld(win);
        }
    }

    private void keyPressed() 
    {
        if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w"))
        {
            setRotation(315);
            move(3);
        } 
        else if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w"))
        {
            setRotation(225);
            move(3);
        }
        else if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")) 
        {
            setRotation(45);
            move(3);
        }
        else if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")) 
        {
            setRotation(135);
            move(3);
        }
        else if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) 
        {
            setRotation(270);
            move(3);
        }
        else if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) 
        {
            setRotation(90);
            move(3);
        }
        else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) 
        {
            setRotation(180);
            move(3);
        }
        else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) 
        {
            setRotation(0);
            move(3);
        }
        if(Greenfoot.isKeyDown("g") && Greenfoot.isKeyDown("o") && Greenfoot.isKeyDown("d")) 
        {
            godmode = true;
                Greenfoot.playSound("PowerUp.wav");
                setImage("GodTurtle.png");
        }
        if(Greenfoot.isKeyDown("l")) 
        {
            Greenfoot.playSound("PowerDown.wav");
            setImage("turtle.png");
            godmode = false;
        }
    }
}
