import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Squares1AdditionMultiplication
 * 
 * Clasa care va fi reprezentata ca si casuta pentru raspunsuri.
 */
public class Squares1AdditionMultiplication extends EquationsAdditionMultiplication
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    String key;
    String upImage;
    String downImage;
    
    String value;
    int position;
    
    /**
     * Constructor care primeste anumiti parametrii atunci cand este creat.
     * 
     * 1. Positia sub forma String
     * 2. Numele imaginii cand nu este apasata casuta.
     * 3. Numele imaginii cand este apasata casuta.
     * 4. Raspunsul sau valoarea casutei.
     * 5. Pozitia de indexare sub form de Int.
     * 
     * Variabile se folosesc in clasele cu grad de importanta mai ridicat.
     * Ele sunt doar initializat aici.
     */
    public Squares1AdditionMultiplication (String key, String upImage, String downImage, String value, int position) {
        this.key = key;
        this.upImage = upImage;
        this.downImage = downImage;
        this.value = value;
        this.position = position;
        
        setImage(upImage);

    }
    /**
     * Verficam anumite proprietati si apelam functii explicate in clasele din care fac parte.
     */
    public void act() {
        keyPressed(key, downImage, upImage);
        printOnSquares(value);
    }
    

}
