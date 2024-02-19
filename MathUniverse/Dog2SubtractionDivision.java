import greenfoot.*; 

public class Dog2SubtractionDivision extends DogsSubtractionDivision
{
    public Dog2SubtractionDivision(){//adjustam imaginea
        setImage("dog2.gif");
       GreenfootImage image = getImage();  
       image.scale(400, 420);
       setImage(image);
    }
    public static int dog2;//am ales sau nu caracterul
    
    public void act()
    {
         if (Greenfoot.mouseClicked(this) && dog2 == 0) {//am dat click
            Greenfoot.setWorld(new DivideWorldSubtractionDivision ());//setam lumea
            dog2 = 1;//am ales player 2
        }
    }
}