import greenfoot.*;  

public class BackButtonSubtractionDivision extends GameTextSubtractionDivision
{
    public BackButtonSubtractionDivision(){//adjustam imaginea
        setImage("back_button.png");
        GreenfootImage image = getImage(); 
        image.scale(120, 60);
        setImage(image);
    }
    Dog1SubtractionDivision dog1;//player din lumea impartirilor
    CarSubtractionDivision car1; // player din lumea scaderilor
    DivideWorldSubtractionDivision divide_w;//lumea impartirilor
    SubtractionWorldSubtractionDivision minus_w;//lumea scaderilor
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){ //resetam lumea
            dog1.dog1 = 0;//nu e ales
            dog1.cnt = 1;//e pe prima banda
            car1.cnt = 1;//e pe prima banda
            
            divide_w.crowd.stop();//oprim muzica
            minus_w.music.stop();//oprim sunetul
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld(new MyWorld());
        }
    }
}