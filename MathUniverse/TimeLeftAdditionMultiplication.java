import greenfoot.*;  
import java.util.Date;

/**
 * TimeLeftAdditionMultiplication
 * 
 * Clasa in care va fi reprezentat cronometrul cu ajuturol librariei java.util.Date;.
 */
public class TimeLeftAdditionMultiplication extends WritingAdditionMultiplication
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int timeLeft = 50;
    
    boolean stopImage = false;
    boolean playerSound = false;
    
    Date time1 = new Date();
    
    int initial = time1.getSeconds();
    
    /**
     * Constructor-setam imaginea.
     */
    public TimeLeftAdditionMultiplication() {
        setImage(new GreenfootImage(": " + timeLeft, 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK));    
    }
    public void act()
    {
        print();
    }
    /**
     * Afisam cronometrul.
     * Verificam secundele ramase, in cazul in care cronometrul ajunge la 0, emitem un sunet pentru a marca sfarsitul jocului.
     */
    void print() {
        Date newTime1 = new Date();
        
        if (newTime1.getSeconds() != initial) {
            timeLeft--;
            initial = newTime1.getSeconds();
            
            if (timeLeft < 0) {
                if (playerSound == false) {
                    playerSound = true;
                    Greenfoot.playSound("timeUP.wav");
                    setImage(new GreenfootImage(": " + 0, 40, Color.RED, new Color(0,0,0, 0 ), Color.BLACK));    
                }
                stopImage = true;
            }
        }
        if (stopImage == false)
            setImage(new GreenfootImage(": " + timeLeft, 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK));    
    }
}
