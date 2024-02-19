import greenfoot.*;  

/**
 * TimerAdditionMultiplication
 */
public class TimerAdditionMultiplication extends WritingAdditionMultiplication
{
    /**
     * Constructor care primeste imaginea caracteristica cronometrului.
     */
    public TimerAdditionMultiplication(String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);
    }
    public void act()
    {
    }
}
