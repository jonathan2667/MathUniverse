import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DropMoversStarsAdditionMultiplication
 * 
 * Actor in care vom reprezenta valurile de apa in cazul universului PLUS si cometele in cazul universului de inmultire.
 * Folosim functii declarate in clasele superioara din punct de vedere al ierarhie Java
 */
public class DropMoversStarsAdditionMultiplication extends MoversAdditionMultiplication
{
    /**
     * Constructor care primeste un String cu numele imaginii atunci cand este creat.
     */ 
    public DropMoversStarsAdditionMultiplication(String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
    /**
     * Adaugam miscare lejera folosind functia move.
     * Verificam daca au ajuns la marginea ecranului folosind functii din actori cu grad de importanta mai mare.
     * Functia este explicata in MoversAdditionMultiplication
     */
    public void act()
    {
        move(-2);
        wrapAtEdge();
    }
}
