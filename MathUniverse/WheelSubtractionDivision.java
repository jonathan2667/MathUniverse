import greenfoot.*;  

public class WheelSubtractionDivision extends CarsSubtractionDivision
{
    public WheelSubtractionDivision(){//adjustam dimensiunile
        setImage("wheel.png");
        GreenfootImage image = getImage();  
        image.scale(42, 42);
        setImage(image);
    }
    int cnt = 0, moves = 1;
    
    public void move(){
        if(Greenfoot.isKeyDown("down") && moves == 1) {//schimbam banda
            setLocation(getX(), getY() + 100);
            moves = 0;
        }
        if(Greenfoot.isKeyDown("up") && moves == 0){ //schimbam banda
            setLocation(getX(), getY() - 100);
            moves = 1;
        }
    }
    
    public void act()
    {   
        
        cnt = cnt % 360;//gradele de rotire
        setRotation(cnt);//rotim
        cnt = cnt + 7;//adaugam pt a roti mai mult
        move();//in cazul in care trebuie sa le mutam pe alta banda
        
    }
}