import greenfoot.*;  

/**
 * PlusUniverse
 * 
 * Universul reprezentat de jocul in care se vor efectua adunarile. 
 */
public class PlusUniverse extends Universes
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int horizScaleDown;
    int vertScaleDown;
    
    String imageName;
    
    int scaleX;
    int scaleY;
    
    int count = 0;
    int rand = Greenfoot.getRandomNumber(200);
    
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
    public PlusUniverse(String imageName, int scaleX, int scaleY, int universePosition) {
        setImage(imageName);
        this.imageName = imageName;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.universePosition = universePosition;
        scaleDownImage(scaleX, scaleY);
    }
    
    public void act() {
       wrapAtEdge(910, 950);
       
       if (count % rand == 0) {
           wrapAtEdgeVertical(50, 250);
           rand = Greenfoot.getRandomNumber(500) + 1;
        }
    }
  
}
