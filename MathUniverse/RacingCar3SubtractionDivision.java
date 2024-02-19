import greenfoot.*; 

public class RacingCar3SubtractionDivision extends CarsSubtractionDivision
{   
    public static int car3 = 0;//statusul playerului
    
    public RacingCar3SubtractionDivision(){//adjustam imaginea
        setImage("racingcar3.png");
        GreenfootImage image = getImage();  
        image.scale(340, 140);
        setImage(image);
    }
    public void act()
    {   
        if (Greenfoot.mouseClicked(this)) {// am dat click
            car3 = 1;
            Greenfoot.setWorld(new SubtractionWorldSubtractionDivision());//schimbam lumea
        }
    }
}