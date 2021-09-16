import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage) 
public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(700, 700, 1);
        prepare();
    }

    public void act() {
        while(getObjects(Food.class).size() < 10)
        {
            if(Greenfoot.getRandomNumber(100) <= 5) {
                PowerUp pwrup = new PowerUp();
                addObject
                (
                    pwrup,
                    getRandom(pwrup.getImage().getWidth(), getWidth() - pwrup.getImage().getWidth()), 
                    getRandom(pwrup.getImage().getHeight(), getHeight() - pwrup.getImage().getHeight())
                );
            }
            Food food = new Food();
            food.setRotation(Greenfoot.getRandomNumber(360));
            addObject
            (
                food,
                getRandom(food.getImage().getWidth(), getWidth() - food.getImage().getWidth()), 
                getRandom(food.getImage().getHeight(), getHeight() - food.getImage().getHeight())
            );
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int rockNum = Greenfoot.getRandomNumber(4)+1;
        Player player = new Player();
        addObject(player, 60, getHeight()/2);
        for(int i = 0; i < rockNum; i++)
        {
            Rock rock = new Rock();
            addObject(rock,
                getRandom(rock.getImage().getWidth(), getWidth() - rock.getImage().getWidth()), 
                getRandom(rock.getImage().getHeight(), getHeight() - rock.getImage().getHeight()));
        }
        Lobster lobster = new Lobster();
        lobster.setRotation(Greenfoot.getRandomNumber(360));
        addObject
        (
            lobster, 
            getRandom(lobster.getImage().getWidth(), getWidth() - lobster.getImage().getWidth()), 
            getRandom(lobster.getImage().getHeight(), getHeight() - lobster.getImage().getHeight())
        );
        for(int i = 0; i < 5; i++) 
        {
            Food food = new Food();
            food.setRotation(Greenfoot.getRandomNumber(360));
            addObject
            (
                food,
                getRandom(food.getImage().getWidth(), getWidth() - food.getImage().getWidth()), 
                getRandom(food.getImage().getHeight(), getHeight() - food.getImage().getHeight())
            );
        }
    }

    public int getRandom(int min, int max) 
    { 
        return(Greenfoot.getRandomNumber(max - min) + min);
    }
}