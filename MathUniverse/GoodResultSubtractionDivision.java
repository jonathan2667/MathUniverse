import greenfoot.*; 

public class GoodResultSubtractionDivision extends AnswersSubtractionDivision
{
    OperationSubtractionDivision sub;//clasa operatiilor care trebuie efectuate
    int result = sub.res;//rezultatul
    int b_or_w = 0;//black or white
    
    public GoodResultSubtractionDivision(int color){
        setImage("good.png");
        b_or_w = color;//setam culoarea
        update();//updatam actorul
    }

    void update(){
        result = sub.res;//rezultatul
        
        setImage(new GreenfootImage(120, 60));//adjustam imaginea
        GreenfootImage img = getImage();
        img.clear();
        
        if(b_or_w == 1)//pt alb
            img.setColor(Color.WHITE);
        else img.setColor(Color.BLACK);//pt negru
        
        String answer = Integer.toString(result);//raspunsul
        img.setFont(new Font("Helvetica", 60));//setam fontul
        img.drawString(answer, 10, 60);//afisam raspunsul
    }
    EasySubtractionDivision e;// level 1
    HardSubtractionDivision h;//level 3
    MediumSubtractionDivision m;//level 2
    
    public void act()
    {   
       int d = 3;//distanta
        
       if(m.click == 1)
           d= 5;//mai greu
       
       if(h.click == 1)
           d = 7;//mai greu
            
       setLocation(getX() - d, getY()); //setam locatia
           
       if (sub.time == 0){
           update();//updatam
        }
    }
}