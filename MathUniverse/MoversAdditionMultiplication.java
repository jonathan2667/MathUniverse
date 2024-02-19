import greenfoot.*; 
import java.util.Date;

/**
 * MoversAdditionMultiplication
 * 
 * Clasa in care vom regrupa toti actorii asupra carora vom efectua anumite miscari.
 * Functiile atasate se vor folosi de catre toti sub-actorii.
 */
public class MoversAdditionMultiplication extends Actor
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int degrees = 0;
    
    boolean down = false;
    boolean goFront =true;
    
    int speed = 3;
 
    public void act() {
    }
    /**
     * Verificam daca am atins linia de final.
     */
    public boolean touching()
    {
        return isTouching(CrossingLineAdditionMultiplication.class);
    }
    /**
     * Introducem miscari aleatorii pentru diversitatea jocului si pentru a crea efectul de competivitate.
     */
    public void checkMotion(int fishNumber) {
        Date time = new Date();
        
        int speedAhead = Greenfoot.getRandomNumber(4);
        int speedBackwards = Greenfoot.getRandomNumber(4);
        
        if (getX() > 800) 
            speedAhead = 2;
            
        if (time.getSeconds() % 16 == 0 && fishNumber == 1) {
            motionAhead(speedAhead);
        } 
        if (time.getSeconds() % 14 == 0  && fishNumber == 2) {
            motionAhead(speedAhead);
        } 
        if (time.getSeconds() % 15 == 0  && fishNumber == 3) {
            motionAhead(speedAhead);
        } 
        if ( time.getSeconds() % 16 == 0  && fishNumber == 4) {
            motionAhead(3);
        } 
        
        if (time.getSeconds() % 18 == 0 && fishNumber == 1) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() %  15 == 0 && fishNumber == 2) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() % 17 == 0 && fishNumber == 3) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() % 14 == 0 && fishNumber == 4) {
            motionBackwards(speedBackwards);
        } 
    }
    /**
     * Crestem viteza, accelerand putin jucatorul chemat.
     */    
    public void motionAhead(int speed1) {
        int x = getX();
        int y = getY();

        setLocation(x + speed1, y);
    }
    /**
     * Descrestem viteza jucatorului chemat.
     */ 
    public void motionBackwards(int speed1) {
        int x = getX();
        int y = getY();

        setLocation(x - speed1, y);
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
    /**
     * In cazul in care anumiti actori depasesc sau se afla la marginea ferestrei.
     * Ii reasezam la locul lor cu ajutorul unor instructiuni.
     */
    public void wrapAtEdge() {
        int x = getX();
        int y = getY();
        int worldWidth = getWorld().getWidth() - 1;
        int worldHeight = getWorld().getHeight() - 1;
        if (x >= worldWidth) {
            setLocation(1, y);            
        }
        if (x <=  0) {
            setLocation(worldWidth - 1, y);            
        }
        if (y >= worldHeight) {
            setLocation(x, 1);            
        }
        if (y <=  0) {
            setLocation(x, worldWidth - 1);            
        }
    }
    /**
     * In cazul in care anumiti actori depasesc sau se afla la marginea ferestrei.
     * Ii reasezam la locul lor cu ajutorul unor instructiuni, functie apelata doar de anumiti actori specifici care nu permite depasirea intervalului delimitat de parametrii.
     */
    public void wrapAtE1dgeSpecific(int min, int max) {
        int x = getX();
        int y = getY();
        
        if (goFront) {
            setLocation(x + speed, y);
            if (x > max)
                goFront = false;
        }
        else {
            setLocation(x - speed, y);
            if (x < min)
                goFront = true;
        }
        
    }
}

