import greenfoot.*;  

public class ChooseCarSubtractionDivision extends World
{
    MyWorld First_World;
    
    public ChooseCarSubtractionDivision()
    {    
        super(1100, 600, 1); 
        setBackground("loading.png");
        prepare();//pregatim lumea
    }    
    void prepare(){
        addObject(new ChooseSubtractionDivision("CHOOSE YOUR CAR!"), 600, 230);//alege playerul
        addObject(new RacingCarSubtractionDivision(), 200, 300);//player 1
        addObject(new RacingCar2SubtractionDivision(), 600, 300);//player 2
        addObject(new RacingCar3SubtractionDivision(), 200, 500);//player 3
        addObject(new RacingCar4SubtractionDivision(), 600, 490);//player 4
        addObject(new EasySubtractionDivision(), 920, 320);//buton pt level 1
        addObject(new MediumSubtractionDivision(), 920, 400);//buton pt level 2
        addObject(new HardSubtractionDivision(), 920, 480);//buton pt level 3
        
        addObject(new BackButtonSubtractionDivision(), 90, 60);
        
        addObject(new TextSubtractionDivision("WELCOME TO THE CAR UNIVERSE!", 41, 300, 1), 650, 150);
        //bine ati venit!
    }
}