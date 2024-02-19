import greenfoot.*;  

/**
 * OrderBoxesAdditionMultiplication
 * 
 * Indexarea casutelor folosind inheritance.
 */
public class OrderBoxesAdditionMultiplication extends WritingAdditionMultiplication
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int position;
    
    Color color;
    
    /**
     * Constructor care primeste pozitia casutei text atunci cand este creata si culoarea dorita.
     */
    public OrderBoxesAdditionMultiplication(int position, Color color) {
        this.position = position;
        this.color = color;
        GreenfootImage image = new GreenfootImage("" + position, 25, color, new Color(0, 0, 0, 0 ), Color.BLACK); 
        setImage(image);
    }
    
    public void act()
    {
        GreenfootImage image = new GreenfootImage("" + position, 25, color, new Color(0, 0, 0, 0 ), Color.BLACK); 
        setImage(image);
  }
}
