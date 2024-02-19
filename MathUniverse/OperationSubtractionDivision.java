import greenfoot.*; 

public class OperationSubtractionDivision extends GameTextSubtractionDivision
{

    public static int time = 0, b_or_w;// timpul, black or whire
    public static int res;//rezultatul
    
    public int min(int a, int b){//alege minumul dintre a si b
        if(a < b)
            return a;
        return b;
    }
    public OperationSubtractionDivision(int color) {    
        b_or_w = color;//selectam culoarea
        time = 0;//timpul e 0
        
        //alegem imaginea
        setImage(new GreenfootImage(700, 300));
        
        update(color);//updatam
      
    }
    public static String s1, s2;// primul numar din operatie, al doilea numar din operatie
    Dog1SubtractionDivision dog1;//player 1
    Dog2SubtractionDivision dog2;//player 2
    
    public void update(int color){
        int divide = 0;
        
        if(dog1.dog1 > 0 || dog2.dog2 > 0)//am ales jocul cu impartiri
            divide = 1;
            
        int random1 = getRandomNumber(1, 200);
        int random2 = getRandomNumber(0, random1 - 1);
        //numere random pt joc
        
        if(divide == 1)//numere mai mici pt impartire
            random2 = getRandomNumber(1, min(random1, 10));
       
        
        if(divide == 1)//adjustam random 1 pt a fi divizibil cu random 2
            random1 = (random1 / random2) * random2;
        
        //acestea sunt numerele
        s1 = Integer.toString(random1);
        s2 = Integer.toString(random2);
        
        //adjustam imaginea
        GreenfootImage img = getImage();
        img.clear();
        
        if(color == 1)
            img.setColor(Color.WHITE);//e alb
        else img.setColor(Color.BLACK);//e negru
        
        img.setFont(new Font("Helvetica", 60));//setam fontul
        
        if(divide == 0)
            img.drawString(s1 + " - " + s2 + " = ?", 4, 60);//daca avem impartire
        else img.drawString(s1 + " : " + s2 + " = ?", 4, 60);//daca avem scadere
        
        if(divide == 0)//daca e scadere
            res = random1 - random2;
        else res = random1 / random2;//daca e impartire
    }
    public int getRandomNumber(int start,int end)//random intre a si b
    {
           int normal = Greenfoot.getRandomNumber(end-start+1);
           return normal+start;
    }
    CarSubtractionDivision change;//pt a vedea daca am ales un raspuns
    
    public void act(){
        
        if(change.touching == 1 || dog1.touching == 1){//trebuie schimbate volorile
            update(b_or_w);//schimbam
            change.touching = 0;//resetam deoarece avem de facut o noua alegere
            dog1.touching = 0;
        }
    }
}