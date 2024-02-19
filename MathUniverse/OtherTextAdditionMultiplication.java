import greenfoot.*; 

/**
 * OtherTextAdditionMultiplication
 * 
 * Clasa universala pentru orice fel de text care nu necesita particularitati speciale precum animatii.
 * 
 */
public class OtherTextAdditionMultiplication extends WritingAdditionMultiplication
{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    String text;
    
    int size;
    
    Color color1;
    Color color2;
    Color color3;
    
    /**
     * Constructor care primeste:
     * 
     * 1. Textul dorit sa se afiseze
     * 2. Marimea textului
     * 3. Culori pentru font, outline, si bg.
     */
    public OtherTextAdditionMultiplication(String text, int size,  Color color1, Color color2, Color color3) {
        this.text = text;
        this.size = size;
        
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        
        GreenfootImage image = new GreenfootImage( text, size, color1, color2, color3); 
        setImage(image);
    }
    public void act()
    {
        GreenfootImage image = new GreenfootImage( text, size, color1, color2, color3); 
        setImage(image);
    }
}
