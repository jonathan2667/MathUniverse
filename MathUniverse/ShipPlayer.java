import greenfoot.*; 

/**
 * ShipPlayer
 * 
 * Clasa pentru MyWorld
 * Vom alege universul dorit.
 */
public class ShipPlayer extends Actor
{
    int speed = 4;
    public void act() {
        moveAround();
        enterMazeGame();
    }
    /**
     * Verificam pentru fiecare univers daca l-am intins si dorim sa efectuam intrarea.
     */
    public void enterMazeGame() { 
        if (isTouching(PlusUniverse.class)) {
            Greenfoot.setWorld(new SelectPersonAdditionMultiplicationWorld(1));
        }
        if (isTouching(MultiplicationUniverse.class)) {
            Greenfoot.setWorld(new SelectPersonAdditionMultiplicationWorld(2));
        }
        if (isTouching(DivideUniverse.class)) {
            Greenfoot.setWorld(new ChooseAnimalSubtractionDivision());
        }
        if (isTouching(MinusUniverse.class)) {
            Greenfoot.setWorld(new ChooseCarSubtractionDivision());
        }
        if (isTouching(Question.class)) {
            Greenfoot.setWorld(new InstructionsWorld());
        }
    }
    /**
     * Functii basic de miscare controlate de la tastatura.
     */
    public void moveAround() {
        if (Greenfoot.isKeyDown("right")) {
            setRotation(0);
            move(speed);
        }
        if (Greenfoot.isKeyDown("left")) {
            setRotation(180);
            move(speed);
        }
        if (Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setRotation(90);
            move(speed);
        }
        
    }
}
