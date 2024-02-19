import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player2AdditionMultiplication
 * 
 * Clasa reprezenta de toti jucatorii posibili.
 */
public class Player2AdditionMultiplication extends SolveAdditionMultiplication
{
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public Player2AdditionMultiplication(String imageName) {
        setImage(imageName);
    }
    /**
     * Avansam jucatorul si efectuam miscari de rotatie asupra acestuia pentru efectul de deplasare cat mai autentica.
     */
    public void act() {
        setMovement(-60, 30);   
        checkMotion(3);
        
    }
    

    
}
