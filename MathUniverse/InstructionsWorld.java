import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsWorld extends World
{

    /**
     * Constructor for objects of class InstructionsWorld.
     * 
     */
    public InstructionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
        prepare();
    }
    
    void prepare() {
        InstructionsSelectPlayerAdditionMultiplication instructionsSelectPlayerAdditionMultiplication = new InstructionsSelectPlayerAdditionMultiplication("WELCOME IN THE MATH UNIVERSE!");
        addObject(instructionsSelectPlayerAdditionMultiplication, getWidth() / 2, 300);
        
        
        OtherTextAdditionMultiplication otherTextAdditionMultiplication1 = new OtherTextAdditionMultiplication("TAKE A LOOK AT THE MAP OF THE UNIVERSE!", 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK );
        addObject(otherTextAdditionMultiplication1, getWidth() / 2, 350);
        
        
        Arrows arrows1 = new Arrows("arr1.png");
        Arrows arrows2 = new Arrows("arr2.png");
        Arrows arrows3 = new Arrows("arr3.png");
        Arrows arrows4 = new Arrows("arr4.png");
        
        addObject(arrows1, 800, 200);
        addObject(arrows2, 300, 200);
        addObject(arrows3, 300, 440);
        addObject(arrows4, 750, 480);
        
        Sign sign1 = new Sign("sign1.png");
        Sign sign2 = new Sign("sign2.png");
        Sign sign3 = new Sign("sign4.png");
        Sign sign4 = new Sign("sign3.png");
        
        addObject(sign1, 950, 100);
        addObject(sign2, 150, 100);
        addObject(sign3, 150, 540);
        addObject(sign4, 950, 540);
        
        addObject(new BackButtonSubtractionDivision(), 570, 200);
    }

}
