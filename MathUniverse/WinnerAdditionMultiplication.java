import greenfoot.*;  

/**
 * WinnerAdditionMultiplication
 * 
 * Reprezentarea grafica a castigatorului in AdditionMultiplicationWorld.
 */
public class WinnerAdditionMultiplication extends SolveAdditionMultiplication
{
    /**
     * Constructor in care vom afisa castigatorul.
     */
    public WinnerAdditionMultiplication() {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6);
    }
    /**
     * Castigatorul este reprezentat de un trofeu atunci cand trece linia de final.
     * Adaugam o miscare lejera si lenta.
     */
    public void act()
    {  
        setLocation(getX() + 1/3, getY());
    }
}
