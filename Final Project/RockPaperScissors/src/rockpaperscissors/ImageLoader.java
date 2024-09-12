
package rockpaperscissors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *This Class handles loading Images for RockPaperScissors class.
 * 
 */
public class ImageLoader {
    
    Image image = null;
    
    //Images for Right hand.
    //Takes in a string that describes the hand position
    //Then returns the corresponding image
    public Image LeftHandImage(String string){
        try{
            if(string == "rock"){
                InputStream streamImage = new FileInputStream("src\\Images\\Rock.png");
                image = new Image(streamImage);
            }else if (string == "paper"){
                InputStream streamImage = new FileInputStream("src\\Images\\Paper.png");
                image = new Image(streamImage);
            }else if(string == "scissors"){
            InputStream streamImage = new FileInputStream("src\\Images\\Scissors.png");
            image = new Image(streamImage); }
            
        }catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;
    }
    
    //Images for Right hand.
    //Takes in a string that describes the hand position
    //Then returns the corresponding image
    public Image RightHandImage(String string){
        try{
            if(string == "rock"){
                InputStream streamImage = new FileInputStream("src\\Images\\RockRight.png");
                image = new Image(streamImage);
            }else if (string == "paper"){
                InputStream streamImage = new FileInputStream("src\\Images\\PaperRight.png");
                image = new Image(streamImage);
            }else if(string == "scissors"){
            InputStream streamImage = new FileInputStream("src\\Images\\ScissorsRight.png");
            image = new Image(streamImage); }
            
        }catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;
    }
    
    //Background Image
    public Image backgroundImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\BoxingRing.jpg");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;
    }
       
    //Heart image for players life counters
    public Image heartImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\Heart.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;       
    }
    
    //Win Streak Watches that appears on the arm
    public Image watchImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\Watch.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;        
    }
    
    //Win Streak Watches that appear on the floor
    public Image watchFloorImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\WatchFloor.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;       
    }
    
    //Image to be placed on the "Rock" button
     public Image ButtonRockImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\ButtonRock.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;          
    }
     
     //Image to be placed on the "Paper" button
      public Image ButtonPaperImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\ButtonPaper.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;         
    }
      
      //Image to be placed on the "Scissors" button
      public Image ButtonScissorsImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\ButtonScissors.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;         
    }
      
      //Image of a trophy used on the win screen
      public Image TrophyImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\trophy.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;         
    }
      
      //Background image used on victory and losing screens.
      public Image VictoryBGImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\VictoryBG.jpg");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;         
    }
      
      //Image of "loser" hand used on losing screen
      public Image LoserHandImage(){
        try{
        InputStream streamImage = new FileInputStream("src\\Images\\LoserHand.png");
        image = new Image(streamImage);
        } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;         
    }
}
