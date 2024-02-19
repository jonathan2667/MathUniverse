import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SubtractionWorldSubtractionDivision extends World
{
    int x = 40, y = 480;
    public static GreenfootSound music = new GreenfootSound("caracceleration.wav");
    
    public SubtractionWorldSubtractionDivision()
    {    
        super(1100, 600, 1); 
        addObject(new TextSubtractionDivision("CHOOSE THE CORRECT ANSWER USING DOWN AND UP KEYS!", 30, 300, 1), 550, 350);
        //instructiuniile
        
        addObject(new BackButtonSubtractionDivision(), 1030, 40);//home button
        
        prepare();//ne pregatim lumea
        
        music.playLoop();//adaugam sunet
        music.setVolume(30);//scadem volumul
    }
    RacingCarSubtractionDivision car1;
    RacingCar2SubtractionDivision car2;
    RacingCar3SubtractionDivision car3;
    RacingCar4SubtractionDivision car4;
    //cei 4 playeri pe care puteam sa-i alegem
    
    public static int start = 0;//cadrele trecute de la start
    
    public void act(){   
        int count_good = getObjects(GoodResultSubtractionDivision .class).size();
        //numarul de rezultate bune din lume
        
         if(start == 100 && count_good == 0){//adaugam raspunsurile
            addObject(new GoodResultSubtractionDivision (1), 1150, 410);
            addObject(new BadAnswerSubtractionDivision (1), 1150, 525);
            addObject(new TextSubtractionDivision ("Score : 0", 50, 300, 1), 450, 160);
            start = 0;//resetam pentru un joc viitor
        } 
        if(start < 101 && count_good == 0)
            start++;//nu mai incrementam pt start > 100
            
        if(start == 100 && count_good == 0)
            generate();//generam lumea, jocul a inceput!
    }
    public void generate(){
            //generam caracterele in functie de playerul ales
            
            if(car1.car1 == 1){
                car1.car1 = 2;
                addObject(new CarSubtractionDivision(), 100, 415);
                addObject(new WheelSubtractionDivision(), 36, 436);
                addObject( new WheelSubtractionDivision(), 157, 437);
            }
            if(car2.car2 == 1){
                car2.car2 = 2;
                addObject(new CarSubtractionDivision(), 100, 400);
                addObject(new WheelSubtractionDivision(), 32, 434);
                addObject( new WheelSubtractionDivision(), 163, 435);
            }
            if(car4.car4 == 1){
                car4.car4 = 2;
                addObject(new CarSubtractionDivision(), 105, 395);
                addObject(new WheelSubtractionDivision(), 40, 423);
                addObject( new WheelSubtractionDivision(), 176, 423);
            }
            if(car3.car3 == 1){
                car3.car3 = 2;
                addObject(new CarSubtractionDivision(), 98, 423);
                addObject(new WheelSubtractionDivision(), 32, 434);
                addObject( new WheelSubtractionDivision(), 163, 435);
            }
            if(start == 100){
                addObject(new OperationSubtractionDivision(1), 720, 200);
                //adaugam operatiile pe care trebuie sa le efectuam
            }
    }
    private void prepare()
    {
        setBackground("bg1.jpg");
        for(int i = 1; i <= 11; ++i)//adaugam liniile de pe drum pt a simula miscarea
            addObject(new LineSubtractionDivision(), x + 100 * (i - 1), y );
        
        addObject(new RectSubtractionDivision("RECT.png"), 550, 100);//chenarul in care vor fi afisare operatiile
    }
}