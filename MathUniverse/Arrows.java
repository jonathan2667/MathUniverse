import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrows here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrows extends QuestionsWorld
{
    /**
     * Act - do whatever the Arrows wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Arrows(String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()/3, getImage().getHeight()/3);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
