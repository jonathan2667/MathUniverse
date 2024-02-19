import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player1AdditionMultiplication
 * 
 * Clasa reprezenta de toti jucatorii posibili.
 */
public class Player1AdditionMultiplication extends SolveAdditionMultiplication
{
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public Player1AdditionMultiplication(String imageName) {
        setImage(imageName);
    }
    /**
     * Avansam jucatorul si efectuam miscari de rotatie asupra acestuia pentru efectul de deplasare cat mai autentica.
     */
    public void act() {
        setMovement(-15, 15);
        checkMotion(2);
    }
}
