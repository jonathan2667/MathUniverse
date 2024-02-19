import greenfoot.*; 

public class DivideUniverse extends Universes
{
    int angle = 0;
    
    public DivideUniverse() {
        setImage("divisionuniverse.png");
        getImage().scale(getImage().getWidth()/5, getImage().getHeight()/5);
    }
    
    public void act()
    {
        wrapAtEdgeVertical(400, 500);
    }
    
}