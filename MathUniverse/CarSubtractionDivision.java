import greenfoot.*;  
import java.util.List;

public class CarSubtractionDivision extends CarsSubtractionDivision
{
    public static int cnt = 1;//laneul pe care se afla playerul
    SubtractionWorldSubtractionDivision Minus_W;//Lumea scaderilor
    OperationSubtractionDivision value;//operatiile ce trebuie efectuate
    
    public int getRandomNumber(int start,int end)//numar random
    {
           int normal = Greenfoot.getRandomNumber(end - start + 1);
           return normal + start;//rezultat
    }
    public CarSubtractionDivision(){//adjustam imagine
       setImage("good_car.png");
       GreenfootImage image = getImage();  
       image.scale(200, 120);
       setImage(image);
    }
    RacingCarSubtractionDivision car1;
    RacingCar2SubtractionDivision car2;
    RacingCar3SubtractionDivision car3;
    RacingCar4SubtractionDivision car4;
    //player 1, 2, 3 si 4
    
    public void car_3(){//am ales player 3
        if(car3.car3 == 2){
            car3.car3 = 0;//resetam
            
            //adjustam imaginea
            GreenfootImage image = new GreenfootImage("racingcar3.png");
            image.scale(240, 120);
            setImage(image);
        }
    }
    public void car_1(){//am ales player 1
        if(car1.car1 == 2){
            car1.car1 = 0;//resetam
                      
            //adjustam imaginea
            GreenfootImage image = new GreenfootImage("racingcar.png");
            image.scale(220, 90);
            setImage(image);
        }
    }
    public void car_2(){//am ales player 2
        if(car2.car2 == 2){
           car2.car2 = 0;//resetam
           GreenfootImage image = getImage();  
           image.scale(200, 120);
           setImage(image);
        }
    }
    public void car_4(){//am ales player 4
        if(car4.car4 == 2){
            car4.car4 = 0;//resetam
                      
            //adjustam imaginea
            GreenfootImage image = new GreenfootImage("3174422-middle.png");
            image.scale(220, 110);
            setImage(image);
        }
    }
    public void reset(){
        //resetam toate valoriile
        car1.car1 = 0;
        car2.car2 = 0;
        car3.car3 = 0;
        car4.car4 = 0;
        Minus_W.start = 0;
    }
    public static int touching = 1;//daca atinge raspunsul corect
    
    public static int counter = 0, score = 0, missed = 0;//rasp totale, bune, gresite
    public static String[] first = new String[11];//primul numar din ecuatie
    public static String[] second = new String[11];//al doilea numar din ecuatie
    
    public void act()
    {   
        //verificam ce player am ales
        car_3();
        car_2();
        car_1();
        car_4();
        
        if(Greenfoot.isKeyDown("down") && cnt == 1) {//mergem jos
            setLocation(getX(), getY() + 100);
            cnt = 0;
        }
        if(Greenfoot.isKeyDown("up") && cnt == 0){ //mergem sus
            setLocation(getX(), getY() - 100);
            cnt = 1;
        }
        if(isTouching(GoodResultSubtractionDivision.class) || isTouching(BadAnswerSubtractionDivision.class)){//am ales un raspuns
            GreenfootSound correct = new GreenfootSound("Correct.wav");//sunet pt corect
            GreenfootSound wrong = new GreenfootSound("Wrong.wav");//sunet pe gresit
            touching = 1;//am ales
            
            if(isTouching(GoodResultSubtractionDivision.class)){//am ales corect
                Actor position = (Actor)getWorld().getObjects(GoodResultSubtractionDivision.class).get(0);
                //position corespunde pt raspunsul corect
                
                int x = position.getX();
                int y = position.getY();
                
                getWorld().addObject(new GoodOrBadSubtractionDivision("good.png"), x, y);//ai ales corect!
                
                score++;//scorul creste
                correct.play();//al ales corect!
                correct.setVolume(40);//scadem volumul
            }
            else{
                Actor position = (Actor)getWorld().getObjects(BadAnswerSubtractionDivision.class).get(0);
                //position corespunde pt raspunsul incorect
                
                int x = position.getX();
                int y = position.getY();
                
                //ai ales gresit :(
                getWorld().addObject(new GoodOrBadSubtractionDivision("wrongans.png"), x, y);
                
                wrong.play();//ai ales gresit
                wrong.setVolume(70);//scadem volumul
                first[++missed] = value.s1;//primul numar din operatia gresita
                second[missed] = value.s2;//al doilea numar din operatia gresita
            }
            //eliminam clasele inutile
            getWorld().removeObjects(getWorld().getObjects(GoodResultSubtractionDivision.class));
            getWorld().removeObjects(getWorld().getObjects(BadAnswerSubtractionDivision.class));
            getWorld().removeObjects(getWorld().getObjects(TextSubtractionDivision.class));
            
            //alegem o banda aleatorie
            int lane = getRandomNumber(0, 1);
            
            counter++;//avem cu o operatie mai mult
            
            String s = Integer.toString(score);//pt a afisa scorul
            
            getWorld().addObject(new TextSubtractionDivision("Score : " + s, 50, 300, 1), 450, 160);
            //scorul bun
            
            if(counter == 10){//oprim jocul deoarece am avut 10 intrebari
                reset();//resetam
                Greenfoot.setWorld(new StatsWorldSubtractionDivision());//mergem sa vedem performantele
            }
            if(lane == 1){//raspunsul corect este pe prima banda
                getWorld().addObject(new GoodResultSubtractionDivision(1), 1150, 410);
                getWorld().addObject(new BadAnswerSubtractionDivision(1), 1150, 525);
            }
            else{//raspunsul corect este pe a doua banda
                getWorld().addObject(new GoodResultSubtractionDivision(1), 1150, 525);
                getWorld().addObject(new BadAnswerSubtractionDivision(1), 1150, 410);
            }
        }
        
    }
}