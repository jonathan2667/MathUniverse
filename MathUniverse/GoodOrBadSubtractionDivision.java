import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GoodOrBadSubtractionDivision  extends GameTextSubtractionDivision 
{
    public GoodOrBadSubtractionDivision (String image){//modificam imaginea
       GreenfootImage img = new GreenfootImage(image);  
       img.scale(45,45);
       setImage(img);
    }
    public void act()
    {
        int speed = 1;//viteza
        int x = getX();//coordonata
            
        setLocation(getX() - speed, getY());//alegem locatia
        
        if(x < 200)//stergem actorul
            getWorld().removeObject(this);
    }
}