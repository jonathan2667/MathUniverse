import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Universes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Universes extends Actor
{
    /**
     * Act - do whatever the Universes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int horizScaleDown;
    int vertScaleDown;
    
    String imageName;
    
    int scaleX;
    int scaleY;
    
    int universePosition;
    
    boolean goFront = true;
    
    int speed = 1;
    
    public void act()
    {
        // Add your action code here.
         
    }
    public int getUniversePosition () {
        return universePosition;
    }
    public void scaleDownImage(int x, int y) {
        horizScaleDown = x;
        vertScaleDown = y;
        getImage().scale(getImage().getWidth()/horizScaleDown, getImage().getHeight()/vertScaleDown);
    }
    public void wrapAtEdge(int min, int max) {
        int x = getX();
        int y = getY();
        
        if (goFront) {
            setLocation(x + speed, y);
            if (x > max)
                goFront = false;
        }
        else {
            setLocation(x - speed, y);
            if (x < min)
                goFront = true;
        }
        
    }
    public void wrapAtEdgeVertical(int min, int max) {
        int x = getX();
        int y = getY();
        
        if (goFront) {
            setLocation(x, y + speed );
            if (y > max)
                goFront = false;
        }
        else {
            setLocation(x, y - speed);
            if (y < min)
                goFront = true;
        }
        
    }
}
