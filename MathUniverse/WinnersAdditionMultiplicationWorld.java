import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WinnersAdditionMultiplicationWorld
 * 
 * World in care va apare in mod explicit clasamentul.
 * Precedat de AdditionMultiplicationWorld si urmat de MyWorld
 * Clasa contine putini algoritmi, elementele de grafica regasindu-se mult mai abundent.
 */
public class WinnersAdditionMultiplicationWorld extends World
{

    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int[] arrOrdered;
    
    int firstOperand[];
    int secondOperand[];
    int thirdOperand[];
    
    int firstOperandNew[] = new int[100];
    int secondOperandNew[] = new int[100];
    int thirdOperandNew[] = new int[100];
    int k = 0;
    
    int count = 0;
    int accuracy = 0;
    
    int index;
    int score;
    int wrongAnswers;
    
    int universePosition;
    
    String imageNames[] = {"", "", "", ""};
    String backMenuImage;
    
    Color colorWriting;
    
    /**
     * Constructor care primeste anumiti parametrii atunci cand este creat.
     * 
     * 1. Operatiile gresite ale jucatorului.
     * 2. Daca World este Addition sau Multiplication pentru a diferienta actorii
     * 3. Scorul jucatorului.
     * 4. Numarul de greseli facute.
     * 5. Vector cu clasamentul real a tuturor jucatorilor.
     */
    public WinnersAdditionMultiplicationWorld(int universePosition, int[] arrOrdered, int score, int wrongAnswers, int firstOperand[], int secondOperand[], int thirdOperand[], int index)
    {    
        super(1100, 600, 1);
        
        this.arrOrdered = arrOrdered;
        this.score = score;
        this.wrongAnswers = wrongAnswers;
        this.index = index;
        
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.thirdOperand = thirdOperand;
        
        this.universePosition = universePosition;
        
        prepare();
    }
    /**
     * Functia in care daca nu este realizata nicio actiune sau se doreste revenirea, se va reveni automat la ecranul principal-MyWorld dupa un anumit interval de timp.
     */
    public void act() {
        count++;
        if (verifyClick() || count > 2000) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    /**
     * Functie in care vom avea un algoritm care va verifica sa nu avem aceasi operatii gresite de mai multe ori. 
     * S-au folosit 3 vectori pentru reprezentarea ecuatiilor, dar se puteau folosi la fel de bine niste structuri de date mai eficiente si inteligente.
     */
    public void verifyIdenticalOperand() {
        for (int i = 1; i < index; i++) {
            if (firstOperand[i] == firstOperand[i - 1] && secondOperand[i] == secondOperand[i - 1] && thirdOperand[i] == thirdOperand[i - 1])
                ;
            else {
                firstOperandNew[k] = firstOperand[i - 1];
                secondOperandNew[k] = secondOperand[i - 1];
                thirdOperandNew[k] = thirdOperand[i - 1];
                k++;
            }
        }
        
    }
    /**
     * Functie in care vom pregati toate conditiile necesare pentru afisarea clasamentului final.
     * Vor exista diferente pe care le vom defini cu ajutorul universului ales de jucator, fie cel al adunarii sau al inmultirii.
     * Initializam crespunzator in vectorul imageNames, numele imaginilor actorilor pe care le vom afisa mai departe si alte diferente la nivel de imagini sau text.
     * Imaginile pentru fiecare trofeu se vor crea in aceasta functie.
     * Scorul si accuratetea jucatorului va fi de asemenea calculata in aceste randuri. 
     */
    public void prepare() {
        if (universePosition == 1) {
            setBackground("Webp.net-resizeimage (2).png");
            
            imageNames[0] = "fish3.png";
            imageNames[1] = "seahorse.png";
            imageNames[2] = "dolphin.png";
            imageNames[3] = "fish1.png";
            
            backMenuImage = "backmenu-removebg-preview.png";
            
            colorWriting = Color.BLACK;
        }
        
        else {
            setBackground("space.jpg");
            
            imageNames[0] = "player1.png";
            imageNames[1] = "player2.png";
            imageNames[2] = "player3.png";
            imageNames[3] = "player4.png";
            
            backMenuImage = "backmenu2.png";
            
            colorWriting = Color.LIGHT_GRAY;
        }
        
        WinnersTrophiesAdditionMultiplication winnersTrophies = new WinnersTrophiesAdditionMultiplication();
        addObject(winnersTrophies, 350, getHeight() / 2 + 30);
        
        
        int xValues[] = {150, 350, 550, 150};
        int yValues[] = {200, 200, 200, 520};
        
        for (int i = 0; i < 4; i++) {
            CharacterWinnersAdditionMultiplication characterWinnersAdditionWorld = new CharacterWinnersAdditionMultiplication(i + 1, imageNames[arrOrdered[i]]);
            addObject(characterWinnersAdditionWorld, xValues[i], yValues[i]);   
        }
      
        verifyIdenticalOperand();
        
        if (k > 8)
            k = 8;
            
        int prev = 250;
        for (int i = 0;  i < k; i++) {
            OtherTextAdditionMultiplication equationText = new OtherTextAdditionMultiplication( firstOperandNew[i] + " + " + secondOperandNew[i] + " = " + thirdOperandNew[i], 30, colorWriting, new Color(0, 0, 0, 0 ), Color.BLACK);
            addObject(equationText, 870, prev + 40 * i);  
        }
        
        if (score > 0)
            accuracy = 100 * (score - wrongAnswers) / score;
        if (accuracy < 0)
            accuracy = 0;
        
        if (k > 0) {
            OtherTextAdditionMultiplication otherTextMissedQuestions = new OtherTextAdditionMultiplication("MISSED QUESTIONS : ", 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
            addObject(otherTextMissedQuestions, 870, 200);
        }
        else if (score > 0) {
            OtherTextAdditionMultiplication otherTextMissedQuestions = new OtherTextAdditionMultiplication("CONGRATULATIONS!\nNO MISTAKES! \n\n\nTRY AGAIN!", 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
            addObject(otherTextMissedQuestions, 850, 320);
        }
        
        OtherTextAdditionMultiplication otherText1 = new OtherTextAdditionMultiplication("1st:", 60, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
        OtherTextAdditionMultiplication otherText2 = new OtherTextAdditionMultiplication("2nd:", 60, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
        OtherTextAdditionMultiplication otherText3 = new OtherTextAdditionMultiplication("3rd:", 60, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
        OtherTextAdditionMultiplication otherText4 = new OtherTextAdditionMultiplication("4th:", 60, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
        
        addObject(otherText1, 150, 140);
        addObject(otherText2, 350, 140);
        addObject(otherText3, 550, 140);
        addObject(otherText4, 150, 440);
        
        
        OtherTextAdditionMultiplication otherTextAccuracy = new OtherTextAdditionMultiplication("ACCURACY :  " + accuracy + " %", 40, Color.WHITE, new Color(0,0,0, 0 ), Color.BLACK);
        addObject(otherTextAccuracy, 840, 140);
        
        
        InstructionsSelectPlayerAdditionMultiplication instructionsSelectPlayer1 = new InstructionsSelectPlayerAdditionMultiplication("RESULTS");
        addObject(instructionsSelectPlayer1, getWidth() / 2, 80);
        
        
        WinntersTrophies4thPlaceAdditionMultiplication winntersTrophies4thPlace = new WinntersTrophies4thPlaceAdditionMultiplication();
        addObject(winntersTrophies4thPlace, 280, 520);
        
        
        BackToMenuAdditionMultiplication backToMenuAdditionWorld = new BackToMenuAdditionMultiplication(backMenuImage, 4, 4);
        addObject(backToMenuAdditionWorld, getWidth() / 2, 520);
        
        
        
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
