import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MinusUniverse  extends Universes
 
{
    int angle = 0;
    
    public MinusUniverse() {
        setImage("subtractionuniverse.png");
        getImage().scale(getImage().getWidth()/5, getImage().getHeight()/5);
    }
    
    public void act()
    {
        wrapAtEdge(150, 200);
    }
    
}