import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HardSubtractionDivision extends ModeSubtractionDivision 
{
    public HardSubtractionDivision (){
        GreenfootImage image = getImage();  
       image.scale(180, 50);
       setImage(image);
    }
    public static int click = 0;//am ales sau nu levelul
    EasySubtractionDivision  e;//level 1
    MediumSubtractionDivision  m;//level 2
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){//0 pt neselectat, 1 pt selectat
            e.click = 0;
            m.click = 0;
            click = 1;
        }
        if(click == 1){//am ales
            GreenfootImage image = new GreenfootImage("hard_clicked.png");
            image.scale(180, 50);
            setImage(image);
        }
        else{//am ales alt level
            GreenfootImage image = new GreenfootImage("hard.png");
            image.scale(180, 50);
            setImage(image);
        }
    }
}