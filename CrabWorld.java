import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage) 
public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab();
        addObject(crab, getWidth()/2, getWidth()/2);
        for(int i=0; i<10; i++) 
        {
            int tempx = Greenfoot.getRandomNumber(getWidth()-30);
            int tempy = Greenfoot.getRandomNumber(getWidth()-34);
            while(tempx < 30)
            {
                tempx = Greenfoot.getRandomNumber(getWidth()-30);
            }

            while(tempy < 30)
            {
                tempy = Greenfoot.getRandomNumber(getWidth()-34);
            }
            Worm worm = new Worm();
            addObject(worm, tempx, tempy);
        }
    }

}