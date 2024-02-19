import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EquationsAdditionMultiplication
 * 
 * Clasa care contine majoritatea algoritmilor pentru desfasurarea jocului.
 * In mode specific reprezinta spatiul unde se va scrie ecuatia.
 * Alogirtmii vor fi descrisi inaintea fiecarui functii prin comentarii text.
 */
public class EquationsAdditionMultiplication extends SolveAdditionMultiplication

{
    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int count = 0;

    String key;
    String upImage;
    String downImage;

    boolean answeredGood = false;

    int value;
    int position;
    int answer;
    int score = 0;
    
    int index = 0;
    int number1;
    int number2;

    int positionGoodAnswer = 0;
    int newPosition = 0;
    int[] randomNumbers;
    int randSound = Greenfoot.getRandomNumber(500) + 100;
    
    
    /**
     * Constructor care afiseaza imaginea necesara reprezentarii grafice a ecuatiei.
     */ 
    public EquationsAdditionMultiplication() {
        setImage(new GreenfootImage("                  ", 60, Color.WHITE,  new Color(0, 0, 0, 0) , Color.WHITE)); 
    }
    /**
     * Verificam daca nu trebuie sa fie gata jocul.
     * Adica daca am gasit un jucator care a castigat jocul.
     */
    public void act()
    {
        if (((AdditionMultiplicationWorld)getWorld()).declaredWinner == false) {
            if (count == 0) 
                printOnBoard();
            if (count - newPosition > 20)
                answeredGood = false;
            findIfTouched();
        }
        
        waterSoundSwimming();
        count++;
    }
    /**
     * Functie in care vom afla local daca asupra unui anumit actor(casuta de raspuns) este realizata operatia de click.
     */
    public boolean verifyClick1() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares1AdditionMultiplication) {
                return true;
            }
        } 
        return false;
    }
    /**
     * Functie in care vom afla local daca asupra unui anumit actor(casuta de raspuns) este realizata operatia de click.
     */
    public boolean verifyClick2() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares2AdditionMultiplication) {
                return true;
            }
        } 
        return false;
    }
    /**
     * Functie in care vom afla local daca asupra unui anumit actor(casuta de raspuns) este realizata operatia de click.
     */
    public boolean verifyClick3() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares3AdditionMultiplication) {
                return true;
            }
        } 
        return false;
    }
    /**
     * Functie in care vom afla local daca asupra unui anumit actor(casuta de raspuns) este realizata operatia de click.
     */
    public boolean verifyClick4() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares4AdditionMultiplication) {
                return true;
            }
        } 
        return false;
    }
    /**
     * Adaugam anumite sunete de bg pentru a dinamiza jocul si a crea o senzatie cat mai aproape de realitate.
     * Suntele sunt adaugate la interval Random de timp.
     */
    public void waterSoundSwimming() {
        if (count % randSound == 0) {
            if ( ((AdditionMultiplicationWorld) getWorld()).universePosition == 1)
                Greenfoot.playSound("water5 _adjustedvolume.wav");
            else
                Greenfoot.playSound("cometsound.wav");
            randSound = Greenfoot.getRandomNumber(800) + 100;
        }

    }
    /**
     * showAnswer()
     * 
     * Vom afisa doar raspunsul, iar celalte casute vor fi goale, in cazul in care jucatorul greseste.
     * Se vor folosi varibile din alte clase si apelarea lor va fi facuta in mod corespunzator.
     */
    public void showAnswer() {
        ((AdditionMultiplicationWorld)getWorld()).firstOperand[((AdditionMultiplicationWorld)getWorld()).index] = number1;
        ((AdditionMultiplicationWorld)getWorld()).secondOperand[((AdditionMultiplicationWorld)getWorld()).index] = number2;
        ((AdditionMultiplicationWorld)getWorld()).thirdOperand[((AdditionMultiplicationWorld)getWorld()).index] = answer;
        ((AdditionMultiplicationWorld)getWorld()).index++;
        
        
        if (positionGoodAnswer == 1) {
            getWorld().showText("", 820, 540);
            getWorld().showText("", 930, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
        }
        else if (positionGoodAnswer == 2)  {
            getWorld().showText("", 710, 540);
            getWorld().showText("", 930, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
        }
        else if (positionGoodAnswer == 3) {    
            getWorld().showText("", 710, 540);
            getWorld().showText("", 820, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
        }

        else if (positionGoodAnswer == 4) {
            getWorld().showText("", 710, 540);
            getWorld().showText("", 820, 540);
            getWorld().showText("", 930, 540);

            Greenfoot.delay(60);
        }
    }
    /**
     * Generam numerele, dupa universul ales.
     * Trebuie sa fim atenti sa nu avem aceasi nr de 2 ori.
     * Vom transmite rezultatul sub forma unui vector care va retine nr finale.
     */
    public int[] generateNumbers(int sum) {
        int min = sum / 10 * 10;
        int max = min + 10;

        int n1 = Greenfoot.getRandomNumber(max - min + 1) + min;
        
        int n2 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n2 == n1)
            n2 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int n3 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n3 == n2 || n3 == n1)
            n3 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int n4 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n4 == n3 || n4 == n2 || n4 == n1)
            n4 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int[] arr = new int[4];
        arr[0] = n1;
        arr[1] = n2;
        arr[2] = n3;
        arr[3] = n4;

        boolean answerAlreadyThere = false;

        for (int i = 0; i < 4; i++)
            if (arr[i] == sum) {
                positionGoodAnswer = i + 1;
                answerAlreadyThere = true;
            }

        if (!answerAlreadyThere) {
            int newRandom = Greenfoot.getRandomNumber(3);
            positionGoodAnswer = newRandom + 1;
            arr[newRandom] = sum;
        }

        return arr;
    }
    /**
     * Afisam numerele si ecuatia corespunzatoare.
     */
    public void printOnBoard() {
        if ( ((AdditionMultiplicationWorld) getWorld()).universePosition == 1) {
            number1 = Greenfoot.getRandomNumber(100);
            number2 = Greenfoot.getRandomNumber(100);
            
            int temp;
    
            if (number2 > number1) {
                temp = number1;
                number1 = number2;
                number2 = temp;
            }
            
            answer = number1 + number2;
            setImage(new GreenfootImage("   " + number1 + " + " + number2 + " :   ", 60, Color.WHITE, ((AdditionMultiplicationWorld) getWorld()).colorEcuations , Color.BLACK)); 
        }
        
        else {
            number1 = Greenfoot.getRandomNumber(13);
            number2 = Greenfoot.getRandomNumber(13);
            
            answer = number1 * number2;
            setImage(new GreenfootImage("   " + number1 + " * " + number2 + " :   ", 60, Color.WHITE, ((AdditionMultiplicationWorld) getWorld()).colorEcuations , Color.BLACK)); 
        }
        
        int sum = answer;
        randomNumbers = generateNumbers(sum);
        
        Squares1AdditionMultiplication squares1 = new Squares1AdditionMultiplication("" + 1, ((AdditionMultiplicationWorld) getWorld()).key, ((AdditionMultiplicationWorld) getWorld()).keyDown,""+ randomNumbers[0], 1);
        getWorld().addObject(squares1, 710, 540);

        Squares2AdditionMultiplication squares2 = new Squares2AdditionMultiplication("" + 2, ((AdditionMultiplicationWorld) getWorld()).key, ((AdditionMultiplicationWorld) getWorld()).keyDown,""+ randomNumbers[1], 2);
        getWorld().addObject(squares2, 820, 540);

        Squares3AdditionMultiplication squares3 = new Squares3AdditionMultiplication("" + 3, ((AdditionMultiplicationWorld) getWorld()).key, ((AdditionMultiplicationWorld) getWorld()).keyDown,""+ randomNumbers[2], 3);
        getWorld().addObject(squares3, 930, 540);

        Squares4AdditionMultiplication squares4 = new Squares4AdditionMultiplication("" + 4,((AdditionMultiplicationWorld) getWorld()).key, ((AdditionMultiplicationWorld) getWorld()).keyDown,""+ randomNumbers[3], 4);
        getWorld().addObject(squares4, 1040, 540);
    }
    /**
     * In cazul unui raspuns corect vom adauga un sunet pe bg pentru a evidentia auditiv corectitudinea raspunsului.
     */
    public void goodAnswerSound() {
        if ( ((AdditionMultiplicationWorld)getWorld()).universePosition == 1 )
            Greenfoot.playSound("corect.wav");
        else 
            Greenfoot.playSound("correct2.wav");
    }
    /**
     * In cazul unui raspuns incorect vom adauga un sunet pe bg pentru a evidentia auditiv incorectitudinea raspunsului.
     */

    public void wrongAnswerSound() {
        if ( ((AdditionMultiplicationWorld)getWorld()).universePosition == 1 )
            Greenfoot.playSound("wrong2.wav");
        else
            Greenfoot.playSound("wrong2.wav");
    }
    /**
     * Funcia este apelata in cazul unui raspuns corect.
     * Pentru evidentierea vizuala se va anvansa actorul jucatorului in fata cu ajutorul unor structuri if/else.
     */
    public void advanceRightPlayer() {
        int positionPlayer = CharactersAdditionMultiplication.selectedPerson(); 
        
        if (positionPlayer == 1) {
            Actor fish = (Actor)getWorld().getObjects(PlayerAdditionMultiplication.class).get(0);
            ((PlayerAdditionMultiplication)getWorld().getObjects(PlayerAdditionMultiplication.class).get(0)).setLocation(fish.getX() + 20, fish.getY());
        }
        if (positionPlayer == 2) {
            Actor fish1 = (Actor)getWorld().getObjects(Player1AdditionMultiplication.class).get(0);
            ((Player1AdditionMultiplication)getWorld().getObjects(Player1AdditionMultiplication.class).get(0)).setLocation(fish1.getX() + 20, fish1.getY());
        }
        if (positionPlayer == 3) {
            Actor fish2 = (Actor)getWorld().getObjects(Player2AdditionMultiplication.class).get(0);
            ((Player2AdditionMultiplication)getWorld().getObjects(Player2AdditionMultiplication.class).get(0)).setLocation(fish2.getX() + 20, fish2.getY());
        }
        if (positionPlayer == 4) {
            Actor fish3 = (Actor)getWorld().getObjects(Player3AdditionMultiplication.class).get(0);
            ((Player3AdditionMultiplication)getWorld().getObjects(Player3AdditionMultiplication.class).get(0)).setLocation(fish3.getX() + 20, fish3.getY());
        }
    }
    /**
     * Funcia este apelata in cazul unui raspuns incorect.
     * Pentru evidentierea vizuala se va muta actorul jucatorului in spate cu ajutorul unor structuri if/else.
     */
    public void moveBackPlayer() {
        int positionPlayer = CharactersAdditionMultiplication.selectedPerson(); 
        
        if (positionPlayer == 1) {
            Actor fish = (Actor)getWorld().getObjects(PlayerAdditionMultiplication.class).get(0);
            ((PlayerAdditionMultiplication)getWorld().getObjects(PlayerAdditionMultiplication.class).get(0)).setLocation(fish.getX() - 10, fish.getY());
        }
        if (positionPlayer == 2) {
            Actor fish1 = (Actor)getWorld().getObjects(Player1AdditionMultiplication.class).get(0);
            ((Player1AdditionMultiplication)getWorld().getObjects(Player1AdditionMultiplication.class).get(0)).setLocation(fish1.getX() - 10, fish1.getY());
        }        
        if (positionPlayer == 3) {
            Actor fish2 = (Actor)getWorld().getObjects(Player2AdditionMultiplication.class).get(0);
            ((Player2AdditionMultiplication)getWorld().getObjects(Player2AdditionMultiplication.class).get(0)).setLocation(fish2.getX() - 10, fish2.getY());
        }
        if (positionPlayer == 4) {
            Actor fish3 = (Actor)getWorld().getObjects(Player3AdditionMultiplication.class).get(0);
            ((Player3AdditionMultiplication)getWorld().getObjects(Player3AdditionMultiplication.class).get(0)).setLocation(fish3.getX() - 10, fish3.getY());
        }
    }
    /**
     * findIfTouched()
     * 
     * Vom verfica daca s-a apasat cu click pe box corecta sau prelua de la tastatura comanda aleasa si validarea acesteia.
     * In caz afirmativ, apelam functiile necesare pentru validarea rezultatului ales.
     * Folosim structuri if/else. Se putea evita folosirea acestor structuri folosind proprietati ale inheritence pentru clasele in cauza.
     */
    public void findIfTouched() {
        if (((Squares1AdditionMultiplication)getWorld().getObjects(Squares1AdditionMultiplication.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 1;
        else if (((Squares2AdditionMultiplication)getWorld().getObjects(Squares2AdditionMultiplication.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 2;
        else if (((Squares3AdditionMultiplication)getWorld().getObjects(Squares3AdditionMultiplication.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 3;
        else if (((Squares4AdditionMultiplication)getWorld().getObjects(Squares4AdditionMultiplication.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 4;

        if (Greenfoot.isKeyDown("1") || verifyClick1() ) {
            if (positionGoodAnswer == 1) {
                score++;
                ((AdditionMultiplicationWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();      
                    ((AdditionMultiplicationWorld)getWorld()).wrongAnswers++;
                }
            }
        }

        else if (Greenfoot.isKeyDown("2") || verifyClick2()) {
            if (positionGoodAnswer == 2) {
                score++;
                ((AdditionMultiplicationWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();   
                    ((AdditionMultiplicationWorld)getWorld()).wrongAnswers++;
                }
            }

        }
        else if (Greenfoot.isKeyDown("3") || verifyClick3()) {
            if (positionGoodAnswer == 3) { 
                score++;
                ((AdditionMultiplicationWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard(); 
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();       
                    ((AdditionMultiplicationWorld)getWorld()).wrongAnswers++;
                }
            }
        }
        else if (Greenfoot.isKeyDown("4") || verifyClick4()) {
            if (positionGoodAnswer == 4) {
                score++;
                ((AdditionMultiplicationWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();          
                    ((AdditionMultiplicationWorld)getWorld()).wrongAnswers++;
                }
            }
        }
    }
}
