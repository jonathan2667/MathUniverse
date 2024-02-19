import greenfoot.*; 

public class Dog1SubtractionDivision extends DogsSubtractionDivision
{
    public Dog1SubtractionDivision(){//adjustam imaginea
        setImage("dog.gif");
       GreenfootImage image = getImage();  
       image.scale(400, 420);
       setImage(image);
    }
    
    public static int dog1 = 0, touching = 0, score = 0;
    public static int cnt = 1, counter = 0;
    
    GifImage myGif = new GifImage("dog.gif");//in cazul in care am ales player 1
    GifImage myGif2 = new GifImage("dog2.gif");//in cazul in care am ales player 2
    
    Dog2SubtractionDivision dog2;//player 2
    
    DivideWorldSubtractionDivision div_w;//lumea impartirilor
    public static int change = 0;//nu am schimbat lumea
    int lane;//banda pe care se afla
    
    public int getRandomNumber(int start,int end)//numar random intre start si end
    {
           int normal = Greenfoot.getRandomNumber(end-start+1);//random
           return normal + start;//rezultat
    }
    public void reset(){//resetam
        dog1 = 0;
        dog2.dog2 = 0;
        gif = 1;
    }    
    public void touch(){//am ales raspunsul
        //eliminam clasele inutile
        getWorld().removeObjects(getWorld().getObjects(GoodResultSubtractionDivision.class));
        getWorld().removeObjects(getWorld().getObjects(BadAnswerSubtractionDivision.class));
        getWorld().removeObjects(getWorld().getObjects(TextSubtractionDivision.class));
    
        //am ales rezultatul bun
        if(isTouching((GoodResultSubtractionDivision.class)))
            score++;
        
        //alegem random o banda
        lane = getRandomNumber(0, 1);
        
        //am mai efectuat o operatie
        counter++;
        
        //pt a schimba imaginea trecem in string
        String s = Integer.toString(score);
        
        //adjustam scorul
        getWorld().addObject(new TextSubtractionDivision("Score : " + s, 50, 300, 2), 450, 160);
                
        if(counter == 10){//jocul s-a terminat
            reset();//resetam
            div_w.start = 0;//resetam
            change = 1;//am schimbat lumea
            Greenfoot.setWorld(new StatsWorldSubtractionDivision());//intram in lumea rezultatelor
        }
        
        if(lane == 1){//rezultatul gresit se afla pe prima banda
            getWorld().addObject(new GoodResultSubtractionDivision(0), 1150, 430);
            getWorld().addObject(new BadAnswerSubtractionDivision(0), 1150, 525);
        }
        else{//rezultatul gresit se afla pe a doua banda
            getWorld().addObject(new GoodResultSubtractionDivision(0), 1150, 525);
            getWorld().addObject(new BadAnswerSubtractionDivision(0), 1150, 430);
        }
        touching = 1;//am ales un raspuns
    }
    public static String[] first = new String[11];//primul numar din operatie
    public static String[] second = new String[11];//al doilea numar din operatie
    public static int missed = 0;//raspunsuri gresite
    OperationSubtractionDivision value;//clasa operatiilor ce trebuie efectuate
    
    public void check(){
        GreenfootSound correct = new GreenfootSound("Correct.wav");//sunet pt raspuns corect
        GreenfootSound wrong = new GreenfootSound("Wrong.wav");//sunet pt raspuns gresit
        
        if(isTouching(GoodResultSubtractionDivision.class) && lane == cnt){//verificam daca suntem pe banda buna
            int x = getX() + 130;
            int y = getY();
            getWorld().addObject(new GoodOrBadSubtractionDivision("good.png"), x, y);//ai ales bine!
                    
            score++;//bravo! adaugam la scor
            correct.play();//raspuns corect
            correct.setVolume(40);//scadem volumul
            }
            else{

                int x = getX() + 130;
                int y = getY();
                getWorld().addObject(new GoodOrBadSubtractionDivision("wrongans.png"), x, y);//ai ales gresit:(
                    
                wrong.play();//raspuns gresit
                wrong.setVolume(70);//scadem volumul
                first[++missed] = value.s1;//primul numar din ecuatie
                second[missed] = value.s2;//al doilea numar din ecuatie
            }    
    }
    int gif = 1;//cainele alearga!(afisam giful)
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && dog1 == 0) {//am dat click
            dog1 = 1;//am ales player 1
            Greenfoot.setWorld(new DivideWorldSubtractionDivision());//lume noua
        }
        if(dog1 >= 1){//daca am ales playerul
            if(dog2.dog2 == 2){//am ales player 2
                dog2.dog2 = 0;//resetam
                gif = 2;//alegem giful cu numarul 2
            }
            if(gif == 1)
                setImage(myGif.getCurrentImage());//player 1 alearga
            else setImage(myGif2.getCurrentImage());//player 2 alearga
            
            GreenfootImage image = getImage(); //adjustam imaginea
            image.scale(300, 220);
            
            if(Greenfoot.isKeyDown("down") && cnt == 1) {//mergem pe banda de jos
                setLocation(getX(), getY() + 100);
                cnt = 0;
            }
            if(Greenfoot.isKeyDown("up") && cnt == 0){ //mergem pe banda de sus
                setLocation(getX(), getY() - 100);
                cnt = 1;
            }
            if(isTouching((GoodResultSubtractionDivision.class)) || isTouching(BadAnswerSubtractionDivision.class)){
                //am ales un rezultat
                check();//verificam
                touch();//efectuam schimbarile
            }
        }
        if(dog1 == 0){//refacem imaginea pt o noua alegere
           GreenfootImage image = getImage();  
           image.scale(400, 420);
           setImage(image);
        }
    }
}