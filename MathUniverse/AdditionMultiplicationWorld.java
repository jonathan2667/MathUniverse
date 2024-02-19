import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.util.Arrays;
import java.util.Collections;

/**
 * AdditionMultiplicationWorld
 * 
 * World pentru semnul de plus si inmultire
 * Jocul propriu-zis apare in aceasta clasa.
 * 
 */

public class AdditionMultiplicationWorld extends World
{

    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    PlayerAdditionMultiplication player; 
    Player1AdditionMultiplication player1; 
    Player2AdditionMultiplication player2;
    Player3AdditionMultiplication player3;

    int timeLeft = 50; //durata jocului in secunde

    int score;
    int wrongAnswers;

    Date time1 = new Date();

    int initial = time1.getSeconds();
    int count = 0;

    boolean removedCrossingLine = false;
    boolean removedCrossingLine1 = false;

    boolean addedCrossingLine = false;
    boolean declaredWinner = false;

    int[] arrOrdered = { 0, 0, 0, 0};

    // vectorii in care vom retine operatiile gresite

    int firstOperand[] = new int[100];
    int secondOperand[] = new int[100];
    int thirdOperand[] = new int[100];
    int index = 0;

    boolean foundPosition = false;

    CrossingLineAdditionMultiplication crossingLine;
    CrossingLineAdditionMultiplication crossingLine1;

    int universePosition;

    String imageNames[] = {"", "", "", ""}; 
    String imageDropMovers;
    String imageDropMovers1;

    String imageCrossingLine;

    String key;
    String keyDown;

    Color colorNumberBoxes;
    Color colorEcuations;

    String hourglassName;

    String soundClap;
    
    String backMenuImage;

    /**
     * Constructor care primeste pozitia universului(semnul universului) atunci cand este creat.
     */
    public AdditionMultiplicationWorld(int universePosition)
    {    
        super(1100, 600, 1);
        setPaintOrder(WritingAdditionMultiplication.class, SolveAdditionMultiplication.class, CrossingLineAdditionMultiplication.class);

        this.universePosition = universePosition;
        prepare();
    }

    public void act() {
        if (verifyClick() && count > 50) {
            Greenfoot.playSound("backMenu.wav");
            Greenfoot.setWorld(new MyWorld());
        }
        if (count == 0) {     // daca jocul nu a inceput afisam instructiunile, pornim sunetele necesare si adaugam jocului toate elementele necesare

            OtherTextAdditionMultiplication instructions1 = new OtherTextAdditionMultiplication("CLICK THE RIGHT ANSWER OR PRESS \n THE NUMBER ASSOCIATED TO THE CORRECT \n BOX TO MOVE FORWARD", 40, Color.WHITE, new Color(0, 0, 0, 0 ), Color.BLACK);
            addObject(instructions1, 580, 260);

            OtherTextAdditionMultiplication instructions2 = new OtherTextAdditionMultiplication("REACH THE FINISH LINE BEFORE \nTHE TIME RUNS OUT!", 40, Color.LIGHT_GRAY, new Color(0, 0, 0, 0 ), Color.BLACK);
            addObject(instructions2, 580, 430);

            addObject(crossingLine, 230, 330);
            Greenfoot.delay(270);

            if (universePosition == 1)
                Greenfoot.playSound("startRace.wav");
            else
                Greenfoot.playSound("321go.wav");

            if (universePosition == 1)
                Greenfoot.delay(150);
            else
                Greenfoot.delay(250);

            removeObject(instructions1);
            removeObject(instructions2);
        }

        if (removedCrossingLine == false)
            checkRemoveBanter();
        if (removedCrossingLine1 == false && addedCrossingLine == true)
            checkRemoveBanter1();

        count++;
        checkAddBanter();
        declareWinner();

    }

    /**
     * Functia care va fi apelata doar atunci cand este gata jocul pentru a realiza clasamentul folosing pozitia jucatorilor.
     * Functia contine un algoritm scurt care se bazeaza pe sortarea coordonatelor X a tuturor jucatorilor si va fi folosita in WinnersaAdditionMultiplicationWord
     */
    public void findOutPositionsPlayers() {
        int fish1_X = player.getX();
        int fish2_X = player1.getX();
        int fish3_X = player2.getX();
        int fish4_X = player3.getX();

        int[] arr = {fish1_X, fish2_X, fish3_X, fish4_X};
        int[] arrSort= {fish1_X, fish2_X, fish3_X, fish4_X};

        for (int i = 0; i < 4; i++) // sortare descrescatoare
            arrSort[i] = -1 * arrSort[i];

        Arrays.sort(arrSort);

        for (int i = 0; i < 4; i++)
            arrSort[i] = -1 * arrSort[i];

        for (int i = 0; i < 4; i++) {
            boolean found = false;
            for (int j = 0; j < 4; j++) {
                if (!found) {
                    if (arrSort[i] == arr[j]) {
                        arrOrdered[i] = j;
                        arr[j] = 0;
                        found = true;
                    } 
                }
            }
        }
    }
    /**
     * Functia care este apelata in continu in act in AdditionMultiplicationWorld care apeleaza functia findOutPositionsPlayers, functie explicata mai sus.
     * Aceasta functioneaza atunci cand am gasit un castigator, adica un jucator a atins linia finalului.
     */
    public void findOutPositions() {
        if (declaredWinner == true && foundPosition == false) {
            foundPosition = true;
            findOutPositionsPlayers();
        }
    }
    /**
     * Functia care verifica si emite sunetele multimii in cazul finalului de joc
     * Functia se bazeaza in mare parte pe niste variabile globare predefinite atunci cand se alege universul.
     * Functia necesita structuri if/else si verifica pentru fiecare actor in parte si actioneaza in caz afirmativ.
     */
    public void declareWinner() {
        count++;
        if (count > 1000) { // evitam atingerea primei linii de start
            if (!declaredWinner) {
                if (player.touching() ) {
                    Greenfoot.playSound(soundClap);
                    declaredWinner = true;

                    WinnerAdditionMultiplication winner  = new WinnerAdditionMultiplication();
                    addObject(winner, player.getX(), player.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( player1.touching()  ) {
                    Greenfoot.playSound(soundClap);
                    declaredWinner = true;

                    WinnerAdditionMultiplication winner  = new WinnerAdditionMultiplication();
                    addObject(winner, player1.getX(), player1.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( player2.touching()  ) {
                    Greenfoot.playSound(soundClap);
                    declaredWinner = true;

                    WinnerAdditionMultiplication winner  = new WinnerAdditionMultiplication();
                    addObject(winner, player2.getX(), player2.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( player3.touching() ) {
                    Greenfoot.playSound(soundClap);
                    declaredWinner = true;

                    WinnerAdditionMultiplication winner  = new WinnerAdditionMultiplication();
                    addObject(winner, player3.getX(), player3.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
            }
        }
    }  
    /**
     * Adaugam linia de start folosing librarii din Java pentru a verifica repere temporale pentru a se evita repetitii la nivel de joc.
     */
    public void checkAddBanter() {
        Date newTime1 = new Date();

        if (newTime1.getSeconds() != initial) {
            timeLeft--;
            initial = newTime1.getSeconds();

            if (timeLeft < 8 && !addedCrossingLine) {
                addObject(crossingLine1, getWidth(), 330);
                addedCrossingLine = true;
            }
        }
    }
    /**
     * Stergem linia de start folosing functii predefinite de Greefoot.
     */
    public void checkRemoveBanter() {
        if (crossingLine.getX() < 1) {
            removeObject(crossingLine);
            removedCrossingLine = true;
        }            
    }
    /**
     * Stergem linia de final si intram in WinnersAdditionMultiplicationWorld, World in care va apare clasamentul.
     * De asemenea, vom transmite anumiti parametrii care urmeaza sa fie folositi in alcatuirea clasamentelor, precum :
     * 
     * 1. Operatiile gresite ale jucatorului.
     * 2. Daca World este Addition sau Multiplication pentru a diferienta actorii
     * 3. Scorul jucatorului.
     * 4. Numarul de greseli facute.
     * 5. Vector cu clasamentul real a tuturor jucatorilor.
     * 
     */
    public void checkRemoveBanter1() {
        if (crossingLine1 != null) {
            if (crossingLine1.getX() < 1) {
                removeObject(crossingLine1);
                removedCrossingLine1 = true;

                Greenfoot.delay(60);

                Greenfoot.setWorld(new WinnersAdditionMultiplicationWorld(universePosition, arrOrdered,score, wrongAnswers, firstOperand, secondOperand, thirdOperand, index));
            }
        }            
    }
    /**
     * Functie in care vom pregati toate conditiile necesare pentru desfasurarea jocului in AdditionMultiplicationWorld
     * Vor exista diferente pe care le vom defini cu ajutorul universului ales de jucator, fie cel al adunarii sau al inmultirii.
     * Initializam crespunzator in vectorul imageNames, numele imaginilor actorilor pe care le vom transmite mai departe si alte diferente de imagini sau text.
     * De asemenea si suntele se vor initializa si stabili in aceasta functie.
     */
    private void prepare()
    {

        if (universePosition == 1) {
            setBackground("Webp.net-resizeimage (2).png");
        
            imageNames[0] = "fish3.png";
            imageNames[1] = "seahorse.png";
            imageNames[2] = "dolphin.png";
            imageNames[3] = "fish1.png";

            imageDropMovers = "drop-removebg-preview.png";
            imageDropMovers1 = "drop-removebg-preview.png";

            DropMoversStarsAdditionMultiplication dropMovers10 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
            addObject(dropMovers10,740,219);

            DropMoversStarsAdditionMultiplication dropMovers6 = new DropMoversStarsAdditionMultiplication(imageDropMovers1);
            addObject(dropMovers6,348,513);

            DropMoversStarsAdditionMultiplication dropMovers3 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
            addObject(dropMovers3,168,164);

            DropMoversStarsAdditionMultiplication dropMovers4 = new DropMoversStarsAdditionMultiplication(imageDropMovers1);
            addObject(dropMovers4,87,361);

            imageCrossingLine = "crossingline.png";

            key = "white-key.jpeg";
            keyDown =  "white-key-down.jpeg";

            colorNumberBoxes = Color.BLACK;
            colorEcuations = new Color(8,156,228 );

            hourglassName = "hourglass-removebg-preview.png";

            soundClap = "clap.wav";
            
            backMenuImage = "backmenu-removebg-preview.png";
        }

        else {
            setBackground("space.jpg");

            imageNames[0] = "player1.png";
            imageNames[1] = "player2.png";
            imageNames[2] = "player3.png";
            imageNames[3] = "player4.png";

            imageDropMovers = "comet.png";
            imageDropMovers1 = "star.png";

            imageCrossingLine = "crossinglineblack.png";

            key = "black-key.png";
            keyDown = "black-key-down.png";

            colorNumberBoxes = Color.WHITE;
            colorEcuations = new Color(68,80,87,255);

            hourglassName = "hourglassgrey.png";

            soundClap = "congratz.wav";
            
            backMenuImage = "backmenu2.png";
        }

        crossingLine = new CrossingLineAdditionMultiplication(imageCrossingLine);
        crossingLine1 = new CrossingLineAdditionMultiplication(imageCrossingLine);

        
        player = new PlayerAdditionMultiplication( imageNames[0]);
        player1 = new Player1AdditionMultiplication( imageNames[1]);
        player2 = new Player2AdditionMultiplication( imageNames[2]);
        player3 = new Player3AdditionMultiplication( imageNames[3]);

        addObject(player,156,487);
        addObject(player1,155,362);
        addObject(player2,154,245);
        addObject(player3,151,144);
        
        
        DropMoversStarsAdditionMultiplication dropMovers = new DropMoversStarsAdditionMultiplication(imageDropMovers1);
        addObject(dropMovers,334,117);
        DropMoversStarsAdditionMultiplication dropMovers2 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
        addObject(dropMovers2,707,71);
        DropMoversStarsAdditionMultiplication dropMovers5 = new DropMoversStarsAdditionMultiplication(imageDropMovers1);
        addObject(dropMovers5,167,539);
        DropMoversStarsAdditionMultiplication dropMovers7 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
        addObject(dropMovers7,604,572);
        DropMoversStarsAdditionMultiplication dropMovers8 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
        addObject(dropMovers8,24,241);
        DropMoversStarsAdditionMultiplication dropMovers9 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
        addObject(dropMovers9,985,362);
        DropMoversStarsAdditionMultiplication dropMovers11 = new DropMoversStarsAdditionMultiplication(imageDropMovers1);
        addObject(dropMovers11,785,349);
        DropMoversStarsAdditionMultiplication dropMovers12 = new DropMoversStarsAdditionMultiplication(imageDropMovers);
        addObject(dropMovers12,500,270);


        ScoreAdditionMultiplication score = new ScoreAdditionMultiplication();
        addObject(score, 100, 80);

        
        TimeLeftAdditionMultiplication timeLeft = new TimeLeftAdditionMultiplication();
        addObject(timeLeft, 1000, 80);

        
        TimerAdditionMultiplication timer = new TimerAdditionMultiplication(hourglassName);
        addObject(timer,950,82);

        
        EquationsAdditionMultiplication equations = new EquationsAdditionMultiplication();
        addObject(equations, 880, 450);

        
        Squares1AdditionMultiplication squares1 = new Squares1AdditionMultiplication("" + 1, key, keyDown , ""+0, 1);
        addObject(squares1, 710, 540);
        Squares2AdditionMultiplication squares2 = new Squares2AdditionMultiplication("" + 2, key, keyDown, ""+ 0, 2);
        addObject(squares2, 820, 540);
        Squares3AdditionMultiplication squares3 = new Squares3AdditionMultiplication("" + 3, key, keyDown,""+ 0, 3);
        addObject(squares3, 930, 540);
        Squares4AdditionMultiplication squares4 = new Squares4AdditionMultiplication("" + 4, key, keyDown, ""+0, 4);
        addObject(squares4, 1040, 540);
    
        BackToMenuAdditionMultiplication backToMenuAdditionMultiplication = new BackToMenuAdditionMultiplication(backMenuImage, 10, 10);
        addObject(backToMenuAdditionMultiplication, 70, 560);
        
        for (int i = 0; i < 4; i++) {
            OrderBoxesAdditionMultiplication orderBoxes = new OrderBoxesAdditionMultiplication( i + 1, colorNumberBoxes);
            addObject(orderBoxes,710 + i * 110,585);
        }
    }
    /**
     * Functie interna in care verificam daca se apasa pe butonul de revenire la ecranul principal.
     */
    public boolean verifyClick() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof BackToMenuAdditionMultiplication) {
                Greenfoot.playSound("click.wav");
                return true;
            }
        } 
        return false;
    }
}
