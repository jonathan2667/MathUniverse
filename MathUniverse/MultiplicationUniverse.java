import greenfoot.*;  

/**
 * MultiplicationUniverse
 * 
 * Universul reprezentat de jocul in care se vor efectua inmultirile. 
 */
public class MultiplicationUniverse extends Universes
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int horizScaleDown;
    int vertScaleDown;
    
    String imageName;
    
    int scaleX;
    int scaleY;
    
    int angle = 0;
    
    int universePosition;
    
    /**
     * Constructor care primeste anumiti parametrii atunci cand este creat.
     * 
     * 1. Numele imaginii.
     * 2. Scalarea pe X
     * 3. Scalarea pe Y
     * 4. Pozitia universului ales/
     * 
     * Variabile se folosesc in  alte clase.
     * Ele sunt doar initializat aici.
     */
    public MultiplicationUniverse(String imageName, int scaleX, int scaleY, int universePosition) {
        setImage(imageName);
        this.imageName = imageName;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.universePosition = universePosition;
        scaleDownImage(scaleX, scaleY);
    }
 
    public void act() {
        wrapAtEdge(900, 970);
    }
    
}
