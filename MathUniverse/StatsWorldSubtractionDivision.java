import greenfoot.*;  

public class StatsWorldSubtractionDivision extends World
{
    CarSubtractionDivision minus_player;//clasa in care se afla playerul din jocul cu masini
    SubtractionWorldSubtractionDivision Minus;//lumea scaderilor
    DivideWorldSubtractionDivision Divide;//lumea impartirilor
    Dog1SubtractionDivision dog1;//clasa in care se afla playerul din jocul cu caini
    
    public StatsWorldSubtractionDivision() 
    {   
        super(1100, 600, 1); 
        Divide.crowd.stop(); //oprim sunetele
        Minus.music.stop();//oprim suntele
          
        if(minus_player.counter > 0){// in cazul in care am terminat jocul cu scaderi
            stats_for_subtraction();
            setBackground(new GreenfootImage("final_background.jpg"));
        }
        else{// in cazul in care am terminat jocul cu impartiri
            stats_for_dogs();
            setBackground(new GreenfootImage("stats2.jpg"));
        }
    }
    public void stats_for_dogs(){
        float percentage = ((float)dog1.score / dog1.counter) * 100;//procentul de reusita
        int missed = dog1.counter - dog1.score;//intrebari gresite
        int int_percentage = (int)percentage;//tranformam in int
        String s = Integer.toString(int_percentage);//pentru afisare
        String s2 = Integer.toString(missed);
    
        addObject(new ChooseSubtractionDivision ("RESULTS"), 723, 200);//rezultatele
        addObject(new TextSubtractionDivision ("ACCURACY: " + s + " %", 40, 300, 1), 500, 300);//acuratetea
        addObject(new TextSubtractionDivision ("NUMBER OF MISSED QUESTIONS: " + s2, 30, 300, 1), 500, 350);//numar de intrebari gresite
        
        if(dog1.missed > 0)//afisam doar in cazul in care exista intrebari gresite
            addObject(new TextSubtractionDivision ("SOME MISSED QUESTIONS: ", 30, 300, 1), 500, 400);
            
        addObject(new BackButtonSubtractionDivision (), 1000, 80);//butonul de return
        int x = 500, y = 450;
        
        /*coordonate pentru a adauga intreabarile gresite 
         * de jucator cu raspunsurile corecte
        */
        int l = 4;
        
        if(dog1.missed < l)//afisam doar maxim 4 din ele pentru a nu incarca inutil imaginea
            l = dog1.missed;
            
        for(int i = 1; i <= l; ++i){
            int a = Integer.parseInt(dog1.first[i]);//transformam in int pt a afla raspunsul  
            int b = Integer.parseInt(dog1.second[i]); 
            String ans = Integer.toString(a / b);
            String operation = dog1.first[i] + " : " + dog1.second[i] + " = " + ans;
            //unim stringurile pentru a se afisa mai frumos rezultatele
            addObject(new TextSubtractionDivision(operation, 30, 300, 3), x, y);//afisam raspunsurile
            y += 50;
        }
        dog1.counter = dog1.score = dog1.missed = 0; 
        dog1.cnt = 1;//resetam variabilele pt un joc nou   
    }
    public void stats_for_subtraction(){
        float percentage = ((float)minus_player.score / minus_player.counter) * 100;//procentaj
        int missed = minus_player.counter - minus_player.score;//raspunsuri gresite
        int int_percentage = (int)percentage;//transformam in int
        String s = Integer.toString(int_percentage);//int to string pt afisare
        String s2 = Integer.toString(missed);
        
        addObject(new ChooseSubtractionDivision ("RESULTS"), 723, 200);//rezultate
        addObject(new TextSubtractionDivision ("ACCURACY: " + s + " %", 40, 300, 1), 500, 300);//acuratete
        addObject(new TextSubtractionDivision ("NUMBER OF MISSED QUESTIONS: " + s2, 30, 300, 1), 500, 350);
        //intrebari gresite
        
        if(minus_player.missed > 0)//verificam daca s-au gresit intrebari
            addObject(new TextSubtractionDivision ("SOME MISSED QUESTIONS: ", 30, 300, 1), 500, 400);
        
        addObject(new BackButtonSubtractionDivision (), 1000, 80);
        int x = 500, y = 450;//coordonate pt a afisa raspunsurile
        
        int l = 4;
        
        if(minus_player.missed < l)
            l = minus_player.missed;
            
        for(int i = 1; i <= l; ++i){
            int a = Integer.parseInt(minus_player.first[i]);  //string to int pt a afla raspunsul
            int b = Integer.parseInt(minus_player.second[i]); 
            String ans = Integer.toString(a - b);
            String operation = minus_player.first[i] + " - " + minus_player.second[i] + " = " + ans;
            
            addObject(new TextSubtractionDivision (operation, 30, 300, 3), x, y);//afisam raspunsurile
            y += 50;//afisam pe un rand nou
        }
        CarSubtractionDivision.counter = CarSubtractionDivision.score = CarSubtractionDivision.missed = 0;
        CarSubtractionDivision.cnt = 1;//resetam variabilele pt un joc nou
    }
}