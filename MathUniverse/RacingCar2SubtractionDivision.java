import greenfoot.*; 

public class RacingCar2SubtractionDivision extends CarsSubtractionDivision
{
    public static int car2 = 0;//statusul playerului
    
     public RacingCar2SubtractionDivision(){//adjustam imaginea
        setImage("car.png");
        GreenfootImage image = getImage();  
        image.scale(300, 120);
        setImage(image);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            car2 = 1;//am ales
            Greenfoot.setWorld(new SubtractionWorldSubtractionDivision());//incepem jocul
        }
    }
}