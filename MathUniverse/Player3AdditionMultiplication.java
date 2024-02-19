import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player3AdditionMultiplication
 * 
 * Clasa reprezenta de toti jucatorii posibili.
 */
public class Player3AdditionMultiplication extends SolveAdditionMultiplication
{
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public Player3AdditionMultiplication(String imageName) {
        setImage(imageName);
    }
    /**
     * Avansam jucatorul si efectuam miscari de rotatie asupra acestuia pentru efectul de deplasare cat mai autentica.
     */
    public void act() {
        setMovement(-10, 10);
        checkMotion(4);
        
    }
}
