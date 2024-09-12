
package rockpaperscissors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * 
 *This Class handles most of the visuals of objects in the RockPaperScissors class
 *includes setting images, effects, mouseOnEvents, and mouseOverEvents. 
 * 
 */
public class Skins {
    Glow glow = new Glow();
    
    //Creates a glowing effect as the mouse hovers over a button
    public Button buttonGlow(Button button){
     
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            button.setEffect(glow);
             }
            });

             button.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            button.setEffect(null);
          }
        });
        glow.setLevel(0.6);
        return button;
    }

    //Skins the start button
    public Button buttonSkinStart(Button startButton){

        //Sets the image for the button
        try {
                InputStream streamStartButton = new FileInputStream("src\\Images\\BattleButtonb.jpg");
                Image imageStartButton = new Image(streamStartButton);
                ImageView ivStartButton = new ImageView(imageStartButton);
                ivStartButton.setFitWidth(110);
                ivStartButton.setPreserveRatio(true);
                startButton.setGraphic(ivStartButton);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
        ;
        //disables background to remove border
        startButton.setVisible(true);
        startButton.setBackground(null);
        
        return startButton;
    }
    
    
    //Skins the flashing outcome image on the screen 
    //Depending on the result of the match
    public ImageView outcomeSkin(ImageView imageView, String string){
        
        //Creates a blinking effect of the image
        imageView.setPreserveRatio(true);
        imageView.setVisible(false);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        
        //Sets the images to the imageView depending on which string is entered
        if (string == "won"){
            try {
                InputStream streamWon = new FileInputStream("src\\Images\\YouWon.png");
                Image imageWon = new Image(streamWon);
                imageView.setImage(imageWon);
                imageView.setFitWidth(195);
             } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
             }
        } 
        if (string == "lost"){
            try {
                InputStream streamWon = new FileInputStream("src\\Images\\YouLost.png");
                Image imageWon = new Image(streamWon);
                imageView.setImage(imageWon); 
                imageView.setFitWidth(230);
             } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (string == "tie"){
            try {
                InputStream streamWon = new FileInputStream("src\\Images\\Tie.png");
                Image imageWon = new Image(streamWon);
                imageView.setImage(imageWon);
                imageView.setFitWidth(80);
             } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
        return imageView;
    }
}


