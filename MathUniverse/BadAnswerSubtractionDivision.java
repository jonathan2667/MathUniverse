import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BadAnswerSubtractionDivision extends AnswersSubtractionDivision
{
    OperationSubtractionDivision sub;//clasa operatiilor care trebuie efectuate
    int result = sub.res;//rezultatul
    int b_or_w;// black or white(culoarea textului)
    
    public BadAnswerSubtractionDivision(int color){
        b_or_w = color;//selectam culoarea
        update();//update la actor
    }
    int max(int a, int b){//functie pt maximul dintre a si b
        if(a > b)
            return a;
        return b;
    }
    public int getRandomNumber(int start,int end)//genereaza numar random intre start si end
    {
           int normal = Greenfoot.getRandomNumber(end - start + 1);//random
           return normal + start;//rezultat
    }
    public static int bad = 0;
    
    void update(){//update pt fiecare operatie
        result = sub.res;//rezultatul
        int random = getRandomNumber(max(0, result - 10), result + 15);
       
        //generam raspunsul gresit
        
        if(random == sub.res)
            random++;//in cazul in care raspunsul corect si cel incorect sunt identice
        
        setImage(new GreenfootImage(120, 60));//setam imaginea
        GreenfootImage img = getImage();
        img.clear(); 
        
        if(b_or_w == 1)//pt alb
            img.setColor(Color.WHITE);
        else img.setColor(Color.BLACK);//pt negru
        
        String number = Integer.toString(random);//pt a afisa
        
        img.setFont(new Font("Helvetica", 60));//setam fontul
        img.drawString(number, 10, 60);//afisam
    }
    EasySubtractionDivision e;//clasa pt buton de lv usor
    HardSubtractionDivision h;//clasa pt buton de lv mediu
    MediumSubtractionDivision m;//clasa pt buton de lv greu
    
    public void act()
    {   
       int d = 3;//distanta de miscare
       
       if(m.click == 1)
           d = 5;//devine mai greu
       if(h.click == 1)
           d = 7;//devine si mai greu
           
       setLocation(getX() - d, getY());//setam pozitia noua a actorului
       
       if(sub.res != result)
           update();//pt a schimba rezultatul
       
    }
}