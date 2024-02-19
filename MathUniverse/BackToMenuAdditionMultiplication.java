import greenfoot.*;  

/**
 * BackToMenuAdditionMultiplication
 * 
 * Clasa folosita in cazul in care dorim reveniera la ecranul principal.
 */
public class BackToMenuAdditionMultiplication extends WritingAdditionMultiplication
{
    /**
     * Constructor in care primim numele imaginii si scalam corespunzator parametrilor primiti.
     */
    public BackToMenuAdditionMultiplication(String imageName, int scaleX, int scaleY) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()/scaleX, getImage().getHeight()/scaleY);
    }
    public void act() {
    }
}
