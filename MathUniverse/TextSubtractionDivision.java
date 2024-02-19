import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TextSubtractionDivision extends GameTextSubtractionDivision
{   
    public SubtractionWorldSubtractionDivision c;
    
    public TextSubtractionDivision(String txt, int dim, int w, int black_or_white){
        //adjustam imaginea
        setImage(new GreenfootImage(970, w));
        GreenfootImage img = getImage();
        img.clear();
        
        if(black_or_white == 1)
            img.setColor(Color.WHITE);//ai ales alb
        else if(black_or_white == 2) img.setColor(Color.BLACK);//ai ales negru
        else img.setColor(Color.LIGHT_GRAY);//ai ales gri    
        
        img.setFont(new Font("Helvetica", dim));//font nou
        img.drawString(txt, 40, 60);

        setImage(img);
    }
    public void act(){
        
        if(c.start == 100){
            getWorld().removeObjects(getWorld().getObjects(TextSubtractionDivision.class));
            //nu mai avem nevoie de text
        }
    }
}