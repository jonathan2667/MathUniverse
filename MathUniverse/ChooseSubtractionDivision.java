import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ChooseSubtractionDivision extends GameTextSubtractionDivision 
{
    //text miscator
    
    public ChooseSubtractionDivision(String text){
        //adjustam imaginea
        setImage(new GreenfootImage(800, 300));
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.WHITE);
        
        img.setFont(new Font("Helvetica", 60));//setam fontul
        img.drawString(text, 4, 60);//alegem textul   
    }
    int move = 1, distance = 0, t = 0;//directia miscarii, distanta, timpul
    
    public void act()
    {   
        t++;//a mai trecut un cadru
        
        if(move == 1 && t % 2 == 0){ //mergem in sus
            setLocation(getX(), getY() + 1);
            distance++;//am mai facut un pas
            t = 0;//timpul e 0
        }
        else if(move == 0 && t % 2 == 0){//mergem in sus
            setLocation(getX(), getY() - 1);
            distance++;//am mai facut un pas
            t = 0;//timpul e 0
        }       
        if(distance == 10 && move == 0){//schimbam directia
            move = 1;//mergem invers
            distance = 0;//distanta e 0
        }
        else if(distance == 10 && move == 1){
            move = 0;//mergem invers
            distance = 0;//distanta e 0
        }
    }
}