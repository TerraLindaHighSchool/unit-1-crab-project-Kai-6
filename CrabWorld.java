import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage) 
public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(50, 50, 12);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player, 2, getHeight()/2);
        for(int i = 0; i < Greenfoot.getRandomNumber(2); i++)
        {
            
        }
        for(int i = 0; i<5; i++) 
        {
            Food food = new Food();
            addObject(food, 4, 4);
        }
    }

}