import greenfoot.*; 

/**
 * InstructionsSelectPlayerAdditionMultiplication
 * 
 * Instructiunile pentru SelectPersonAdditionMultiplicationWorld.
 */
public class InstructionsSelectPlayerAdditionMultiplication extends WritingAdditionMultiplication
{
    public InstructionsSelectPlayerAdditionMultiplication(String text) {
        GreenfootImage image = new GreenfootImage(text, 65, Color.WHITE, new Color(0, 0, 0, 0 ), Color.BLACK); 
        setImage(image);
    }
    /**
     * Vom efectua o animatie asupra textul;ui folosind functia wrapAtEdge
     */
    public void act()
    {
        wrapAtEdge(510, 600);
    }
    
    
}
