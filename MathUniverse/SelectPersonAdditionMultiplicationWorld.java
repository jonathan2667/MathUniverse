import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SelectPersonAdditionMultiplicationWorld
 * 
 * World Folosit Pentru A Selecta Personajul Dorit
 * Este precedat de MyWordl si urmat de AdditionMultiplicationWorld, ca si ordine de executie al programului.
 * Clas scurta care contine 4 imagini, un titlu si care permite trecere la urmatorul pas al jocului, dupa alegerea jucatorului.
 * Alegerea jucatorului se poate realiza fie cu un click(mouse) sau folosind tastele "1", "2", "3" si "4", reprezentate de un jucator diferit.
 */
public class SelectPersonAdditionMultiplicationWorld extends World
{

    /**
     * Variabile Globale pe care le vom folosi fie in World sau in clasele pentru Actors pentru a modifica anumite valori conform cerintelor jocului.
     */
    
    int numberChosen;
    int universePosition;
    
    String imageNames[] = {"", "", "", ""};
    String welcomeString = "";
    
    String backMenuImage;
    
    Color colorOrderBoxes;
    
    /**
     * Constructor care primeste pozitia universului(semnul universului) atunci cand este creat.
     */
    public SelectPersonAdditionMultiplicationWorld(int universePosition)
    {    
        super(1100, 600, 1);
        
        this.universePosition = universePosition;
        prepare();
    }
    public void act() {
        if (verifyClick()) {
            Greenfoot.playSound("backMenu.wav");
            Greenfoot.setWorld(new MyWorld());
        }
    }
    /**
     * Pregatim World folosind structura if/else pentru a diferienta universele intre ele.
     * Se atribuie anumite variabile si sunt folosite functii uzuale din Greenfoot pentru a reprezenta imaginile si instructiuniile necesare.
     */
     public void prepare() {        
        if (universePosition == 1) {
            setBackground("Webp.net-resizeimage (2).png");
            
            imageNames[0] = "fish3.png";
            imageNames[1] = "seahorse.png";
            imageNames[2] = "dolphin.png";
            imageNames[3] = "fish1.png";
            
            welcomeString = "WELCOME TO THE MARINE UNIVERSE !";
            
            colorOrderBoxes = Color.BLACK;
            
            backMenuImage = "backmenu-removebg-preview.png";
        }
        else if (universePosition == 2){
            setBackground("space.jpg");
            
            imageNames[0] = "player1.png";
            imageNames[1] = "player2.png";
            imageNames[2] = "player3.png";
            imageNames[3] = "player4.png";
            
            welcomeString = "WELCOME TO SPACE!";
            
            colorOrderBoxes = Color.WHITE;
            
            backMenuImage = "backmenu2.png";
        }
        
        CharactersAdditionMultiplication fish = new CharactersAdditionMultiplication(1, imageNames[0] );
        addObject(fish, getWidth() / 2 - 200, getHeight() / 2 - 20);
        
        CharactersAdditionMultiplication fish1 = new CharactersAdditionMultiplication(2, imageNames[1] );
        addObject(fish1, getWidth() / 2 + 200, getHeight() / 2 - 20);
                
        CharactersAdditionMultiplication fish2 = new CharactersAdditionMultiplication(3, imageNames[2] );
        addObject(fish2, getWidth() / 2 - 200, getHeight() / 2 + 160);
        
        CharactersAdditionMultiplication fish3 = new CharactersAdditionMultiplication(4, imageNames[3] );
        addObject(fish3, getWidth() / 2 + 200, getHeight() / 2 + 160);
        
         
        InstructionsSelectPlayerAdditionMultiplication instructionsSelectPlayer1 = new InstructionsSelectPlayerAdditionMultiplication("SELECT YOUR CHARACTER!");
        addObject(instructionsSelectPlayer1, getWidth() / 2, getHeight() / 4 + 30);
        
        OtherTextAdditionMultiplication instructionWelcome1 = new OtherTextAdditionMultiplication(welcomeString, 60, Color.WHITE, new Color(0, 0, 0, 0 ), Color.BLACK);
        addObject(instructionWelcome1, getWidth() / 2, getHeight() / 4  - 40);
        
        
        OrderBoxesSelectPersonAdditionMultiplication orderBoxesSelectPerson1 = new OrderBoxesSelectPersonAdditionMultiplication(1, colorOrderBoxes);
        OrderBoxesSelectPersonAdditionMultiplication orderBoxesSelectPerson2 = new OrderBoxesSelectPersonAdditionMultiplication(2, colorOrderBoxes);
        OrderBoxesSelectPersonAdditionMultiplication orderBoxesSelectPerson3 = new OrderBoxesSelectPersonAdditionMultiplication(3, colorOrderBoxes);
        OrderBoxesSelectPersonAdditionMultiplication orderBoxesSelectPerson4 = new OrderBoxesSelectPersonAdditionMultiplication(4, colorOrderBoxes);
        
        addObject(orderBoxesSelectPerson1,getWidth() / 2 - 200, getHeight() / 2  +60);
        addObject(orderBoxesSelectPerson2,getWidth() / 2 + 200, getHeight() / 2  +60);
        addObject(orderBoxesSelectPerson3,getWidth() / 2 - 200, getHeight() / 2 +240 );
        addObject(orderBoxesSelectPerson4,getWidth() / 2 + 200, getHeight() / 2 +240 );
        
    
        BackToMenuAdditionMultiplication backToMenuAdditionMultiplication = new BackToMenuAdditionMultiplication(backMenuImage, 10, 10);
        addObject(backToMenuAdditionMultiplication, 70, 560);
        
    }
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
