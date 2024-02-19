import greenfoot.*;  
import java.lang.Object;

/**
 * ScoreAdditionMultiplication
 * 
 * Reprezentarea grafica a scorului se va realiza de catre aceasta clasa.
 */
public class ScoreAdditionMultiplication extends SolveAdditionMultiplication
{
    /**
     * Constructor in care vom afisa scorul.
     */
    public ScoreAdditionMultiplication() {
        setImage(new GreenfootImage("SCORE: " + 0 , 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK));    
    }
    /**
     * Schimbam daca este cazul scorul.
     * Score- fiind o varibila globala care se schimba in cazul unui raspuns corect.
     */
    public void act()
    {
        setImage(new GreenfootImage("SCORE: " + ((EquationsAdditionMultiplication)getWorld().getObjects(EquationsAdditionMultiplication.class).get(0)).score, 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK));    
    }
}
