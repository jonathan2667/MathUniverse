import greenfoot.*; 

/**
 * CrossingLineAdditionMultiplication
 */
public class CrossingLineAdditionMultiplication extends MoversAdditionMultiplication
{
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public CrossingLineAdditionMultiplication(String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
     }
    /**
     * Adaugam miscare liniei de start folosind functia move.
     */
    public void act() {
        move(-1);
    }
}
