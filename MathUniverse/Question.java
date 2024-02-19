import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Universes
{
    
    int angle = 0;
    
    public Question() {
        setImage("questions.png");
        getImage().scale(getImage().getWidth()/3, getImage().getHeight()/3);
    }
    
    public void act()
    {
        if (angle > 360) {
            angle = 0;
            getPointOnCircle(angle, 70);
        }
        else{
            angle+=1;
            getPointOnCircle(angle, 70);
        }
    }
   
     public void getPointOnCircle(float degress, float radius) {
        int x = Math.round(getWorld().getWidth() / 2);
        int y = Math.round(getWorld().getHeight() / 2);
    
        double rads = Math.toRadians(degress - 90); 

        int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
        int yPosy = Math.round((float) (y + Math.sin(rads) * radius));
    
        setLocation(xPosy, yPosy);
    }
}
