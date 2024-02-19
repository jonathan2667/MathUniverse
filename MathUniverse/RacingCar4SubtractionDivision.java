import greenfoot.*;  

public class RacingCar4SubtractionDivision extends CarsSubtractionDivision
{   
    public static int car4 = 0;//statusul playerului
    
     public RacingCar4SubtractionDivision(){//adjustam imaginea
        setImage("3174422-middle.png");
        GreenfootImage image = getImage();  
        image.scale(300, 125);
        setImage(image);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && car4 == 0) {//am dat click
            car4 = 1;
            Greenfoot.setWorld(new SubtractionWorldSubtractionDivision());//schimbam lumea
            
        }
    }
}