import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RacingCarSubtractionDivision extends CarsSubtractionDivision
{
    public static int car1 = 0;//pt a verifica statusul actorului
    
    public RacingCarSubtractionDivision(){//adjustam imaginea
        setImage("racingcar.png");
        GreenfootImage image = getImage();  
        image.scale(300, 120);
        setImage(image);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && car1 == 0) {//daca am dat click
            car1 = 1;//am ales
            Greenfoot.setWorld(new SubtractionWorldSubtractionDivision());//lume noua
        }
    }
}