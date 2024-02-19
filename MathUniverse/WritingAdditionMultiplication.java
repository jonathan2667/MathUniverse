import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Writing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WritingAdditionMultiplication extends Actor

{
    boolean goFront = true;
    int speed = 1;
    
    public void act() {
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
}
