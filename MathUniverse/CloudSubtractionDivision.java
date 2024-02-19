import greenfoot.*; 

public class CloudSubtractionDivision extends OtherSubtractionDivision
{   
    //pt a infrumuseta jocul si pt a simula miscarea
    
    int time = 1;//timpul
    public CloudSubtractionDivision() {
        setImage("cloud.png");
    }
    public void act()
    {
       time++;//adaugam la timp
       
       if(time == 6){//pt a nu misca norii prea rapid, le schimbam pozitia doar cand time = 6
           setLocation(getX() - 1, getY());//schimbam pozitia
           time = 0;//reseta,
           
            int w = getWorld().getWidth();//latimea
            int h = getWorld().getHeight();//lungimea
            int x = getX();//x curent
            int y = getY();//y curent
            int a = 1;//limita
            
           if (x < a || x > w - a - 1) setLocation(w - x - 1, y);
           if (y < a || y > h - a - 1) setLocation(x, w - y - 1);
           //atinge margine deci schimbam pozitia
       }
    }
}