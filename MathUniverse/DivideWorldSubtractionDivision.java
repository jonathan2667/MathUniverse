import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DivideWorldSubtractionDivision extends World
{
    public static GreenfootSound crowd = new GreenfootSound("crowd.wav");
    //sunet ambiental
    
    public DivideWorldSubtractionDivision()
    {    
        super(1100, 600, 1); 
        setBackground("stadium.jpg");
        addObject(new CloudSubtractionDivision(), 50, 80);
        addObject(new CloudSubtractionDivision(), 200, 120);
        addObject(new CloudSubtractionDivision(), 400, 100);
        addObject(new CloudSubtractionDivision(), 700, 110);
        addObject(new CloudSubtractionDivision(), 940, 80);
        //adaugam nori care se misca pentru a simula trecea timpului si miscarea playerului
        
        addObject(new BackButtonSubtractionDivision(), 1030, 40);//home button
        
        addObject(new TextSubtractionDivision("CHOOSE THE CORRECT ANSWER USING DOWN AND UP KEYS!", 30, 300, 2), 550, 545);
        //explicam ideea jocului
        
        addObject(new RectSubtractionDivision("rect2.png"), 540, 95);
        //adaugam fereastra in care vom plasa operatiile
    }
    Dog1SubtractionDivision dog1;//primul caracter
    Dog2SubtractionDivision dog2;//al doilea caracter
    
    public static int start = 0;//de cat timp a inceput
    
    public void act(){
         int count_good = getObjects(GoodResultSubtractionDivision .class).size();
         //numarul de elemente din clasa rezultatului corect
        
        if(start == 100 && count_good == 0){//incepem jocul dupa 100 de cadre
            crowd.playLoop();//sunetul de fundal
            crowd.setVolume(30);//micsoram volumul
            addObject(new GoodResultSubtractionDivision(0), 1150, 525);//adaugam raspunsul corect
            addObject(new BadAnswerSubtractionDivision(0), 1150, 430);//adaugam raspunsul gresit
            addObject(new TextSubtractionDivision("Score : 0", 50, 300, 2), 450, 160);//scorul
            start = 0;//reinitializam
        } 
        if(start < 101 && count_good == 0)
            start++;
        //incrementam doar daca sunt mai putin de 100 de cadre, in caz contrar nu are rost
            
        if(start == 100 && count_good == 0){//jocul a inceput!
            generate();//generam unele parti din lume
            removeObjects(getObjects(TextSubtractionDivision.class));//eliminam instructiunile   
        }
    }
    public void generate(){
        if(dog1.dog1 == 1){//verificam daca am dat click pe playerul 1
            addObject(new Dog1SubtractionDivision(), 100, 435);//adaugam playerul
            dog1.dog1 = 2;
            //notam cu 2 variabila insemnand ca am dat click pe player si l-am si generat
        }
        if(dog2.dog2 == 1){//verificam daca am dat click pe playerul 2
            addObject(new Dog1SubtractionDivision(), 100, 415);//adaugam playerul
            dog2.dog2 = 2;
            dog1.dog1 = 2;
            //notam cu 2 variabila insemnand ca am dat click pe player si l-am si generat
        }
        if(start == 100){
            addObject(new OperationSubtractionDivision(0), 730, 200);
            //adaugam operatiile pe care va trebui sa le rezolvam
        }
    }
}