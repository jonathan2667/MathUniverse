import greenfoot.*;  
import java.util.Date;

/**
 * SolveAdditionMultiplication
 * 
 * Clasa folosita pentru organizarea mai eficienta a claselor.
 * De asemenea, se realizeaza algortimul de efect-raspuns atunci cand este atinsa casuta corespunzatoare.
 */
public class SolveAdditionMultiplication extends MoversAdditionMultiplication
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int ok = 0;
    int declaredWinner = 0; 
    int counter = 0;
    
    boolean isPressed;
    
    public void act()   {
    }
    /**
     * Functie care va afisa anumite valori folosite de subclasele acestui actor.
     */
    public void printOnSquares(String value) {      
        getWorld().showText(value, getX(), getY());
    }
    /**
     * Algortimul de efect-raspuns atunci cand este atinsa casuta corespunzatoare.
     */
    public void keyPressed(String key, String downImage, String upImage) {
        if (Greenfoot.isKeyDown(key) && !isPressed) {
            setImage(downImage);
            isPressed = true;
        }
        if (!Greenfoot.isKeyDown(key) && isPressed) {
            setImage(upImage);
            isPressed = false;
        }
    }

    
}
