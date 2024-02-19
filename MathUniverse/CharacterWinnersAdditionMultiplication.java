import greenfoot.*; 

/**
 * CharacterWinnersAdditionMultiplication
 * 
 * Actor folosit in mod exclusiv de WinnersAdditionMultiplicationWorld
 * Folosind procedee de inheretance cream aceasta clasa pentru toti cei 4 jucatori.
 * De asemenea, vom aplica o miscare usoara si lejera asupra actorilor folosind functii Greenfoot
 */
public class CharacterWinnersAdditionMultiplication extends Actor
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int position;
    int count;
    int degrees;
    
    boolean down = false;
    
    /**
     * Constructor care primeste anumiti parametrii atunci cand este creat.
     * 
     * 1. Positia universului
     * 2. Numele imaginii pe care o reprezinta actorul.
     */
    public CharacterWinnersAdditionMultiplication(int position, String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()*13/10, getImage().getHeight()*13/10);
        this.position = position;
        
    }
    public void act()
    {
        count++;
        if (count % 3 == 0)
            setMovement(-10, 10);
    }
    /**
     * Functie in care este descris un algoritm care efectuaza miscarea actorilor pentru toti cei 4.
     * Miscarea este incet realizata folosindu-se proprietati si functii Greenfoot.
     */
    public void setMovement(int start, int stop) {
        if (degrees == stop) {
            down = true;
        }
        if (degrees == start) {
            down = false;
        }
        if (down) {
            degrees--;
        }
        else {
            degrees++;
        }
        setRotation(degrees);
    }
}