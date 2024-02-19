 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CharacterWinnersAdditionMultiplication
 * 
 * Folosit de SelectPersonAdditionMultiplicationWorld si de EquationsAdditionMultiplication
 * Folosind procedeul de inheritance se va crea actorul care va fi ales de jucator.
*/
public class CharactersAdditionMultiplication extends Actor
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int position;
    int degrees;
    int count;
    
    boolean down = false;
    
    static int postionNew;
    
    /**
     * Constructor care primeste anumiti parametrii atunci cand este creat.
     * 
     * Indexarea corecta a actorului si imaginea corecta folosindu-se anumite proprietati de "Inheritance" particulare limbajului Java.
     */
    public CharactersAdditionMultiplication(int position, String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        this.position = position;
    }
    /**
     * Functia act in care apelam functia pentru miscare si verificam daca am ales actorul.
     * In caz afirmativ, retinem informatia despre indexare, pornim muzica si schimbam lumea catre urmatoarea.
     */
    public void act() {
        count++;
        
        if (count % 3 == 0)
            setMovement(-10, 10);
            
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("" + position)) {
            postionNew = position;
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld(new AdditionMultiplicationWorld(((SelectPersonAdditionMultiplicationWorld)getWorld()).universePosition));
        }
    }
    /**
     * Functie statica care va fi apelata de alti actori pentru informatii despre indexare.
     */
    public static int selectedPerson() {
        return postionNew;
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
