import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyWorld
 * 
 * Lumea de intrare joc.
 * Jucatorul isi va putea alege universul asociat semnului matematic.
 */
public class MyWorld extends World
{
    static GreenfootSound sound = new GreenfootSound("background_monkey.wav"); // muzica de bg
    int started = 0;
    
    public MyWorld()
    {   
        super(1100, 600, 1); 
        prepare();
        started = 1;
    }
    /**
     * Apelam functia void atasata mai jos
     */
    public void act() {
        startedMusicLoop(); 
    }
    /**
     * Functie care va fi apelata in caz in care oprim jocul
     */
    public void stopped() { 
        sound.pause();
    }
    /**
     * Functie in care ne asiguram ca vom avea sunet pe toata durata jocului
     */
    public void startedMusicLoop() { 
        sound.playLoop();
    }
    /**
     * Pregatim MyWorld
     */
    public void prepare() { 
        
        ShipPlayer mainPlayer = new ShipPlayer(); 
        addObject(mainPlayer, getWidth() / 2, getHeight() / 2 + 180);
        
        PlusUniverse plus = new PlusUniverse("plusuniverse.png", 5, 5, 1);  //cream Univesul cu plus
        addObject(plus,889,141);
    
        MultiplicationUniverse minus = new MultiplicationUniverse("multiplicationuniverse.png", 5, 5, 2); //cream Universul cu minus
        addObject(minus, 889, 450);
        
        MinusUniverse plus1 = new MinusUniverse ();  
        addObject(plus1,200,141);
        
        DivideUniverse divide = new DivideUniverse ();
        addObject(divide,200,450);
        
        Question question = new Question();
        addObject(question, getWidth() / 2, getHeight() / 2 - 10 );
        
        
        OtherTextAdditionMultiplication otherTextAdditionMultiplication = new OtherTextAdditionMultiplication("TOUCH THE QUESTION MARKS TO READ THE INSTRUCTIONS!", 30, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        OtherTextAdditionMultiplication otherTextAdditionMultiplication1 = new OtherTextAdditionMultiplication("MOVE WITH THE ARROWS KEY AND CHOOSE YOUR UNIVERSE ACCORDING TO THE MAP!", 30, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        
        addObject(otherTextAdditionMultiplication, getWidth() / 2, 30);
        addObject(otherTextAdditionMultiplication1, getWidth() / 2, 570);
    }
}
