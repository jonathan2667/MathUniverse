import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class ChooseAnimalSubtractionDivision extends World
{
    public ChooseAnimalSubtractionDivision()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
        
        setBackground("hill.jpg");
        
        addObject(new ChooseSubtractionDivision("CHOOSE YOUR PLAYER!"), 600, 230);//alege caracterul
        addObject(new EasySubtractionDivision(), 920, 320);//buton pt primul level
        addObject(new MediumSubtractionDivision(), 920, 400);//buton pt al doilea level
        addObject(new HardSubtractionDivision(), 920, 480);//buton pt al treilea level
        addObject(new TextSubtractionDivision ("WELCOME TO THE ANIMAL UNIVERSE!", 41, 300, 1), 630, 150);
        //bine ati venit!!
        
        addObject(new BackButtonSubtractionDivision(),  90, 75);
        addObject(new Dog1SubtractionDivision(), 200, 400);//player 1
        addObject(new Dog2SubtractionDivision(), 600, 400);//player 2
    }
    
    public void act(){
        
    }
}