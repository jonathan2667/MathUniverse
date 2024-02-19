import greenfoot.*;

/**
 * PlayerAdditionMultiplication
 * 
 * Clasa reprezenta de toti jucatorii posibili.
 */
public class PlayerAdditionMultiplication extends SolveAdditionMultiplication
{

    public int distance = 0;
    
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public PlayerAdditionMultiplication(String imageName) {
        setImage(imageName);
    }
    /**
     * Avansam jucatorul si efectuam miscari de rotatie asupra acestuia pentru efectul de deplasare cat mai autentica.
     */
    public void act() {
        setMovement(-30, 30);
        checkMotion(1);
    }   
}
