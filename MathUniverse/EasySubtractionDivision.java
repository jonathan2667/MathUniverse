import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EasySubtractionDivision extends ModeSubtractionDivision 
{   
    public EasySubtractionDivision (){
        GreenfootImage image = getImage();  
       image.scale(180, 50);
       setImage(image);
    }
    public static int click = 1;//am ales levelul
    
    HardSubtractionDivision  h;//level 3
    MediumSubtractionDivision  m;//level 2
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){//1 pt selectat 0 pt neselectat
            click = 1;
            h.click = 0;
            m.click = 0;
        }
        if(click == 1){//am dat click
            GreenfootImage image = new GreenfootImage("easy_clicked.png");
            image.scale(180, 50);
            setImage(image);
        }
        else{//am selectat altceva
            GreenfootImage image = new GreenfootImage("easy.png");
            image.scale(180, 50);
            setImage(image);
        }
    }
}