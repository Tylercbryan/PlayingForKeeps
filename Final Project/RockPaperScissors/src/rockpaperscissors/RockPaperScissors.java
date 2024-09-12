//Written by Tyler Bryan
//for Java244 Class Final CCAC
//12/6/2023 - 12/14/2023
package rockpaperscissors;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.effect.Glow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RockPaperScissors extends Application {
   
    String opponentMove = "";
    int hpYou = 3;
    int hpThem = 3;
    Button startButton = new Button();
    HBox buttonBox = new HBox();
    VBox vBoxRight = new VBox();
    VBox vBoxLeft = new VBox();
    Label outcome = new Label("You Win");
    ImageLoader rockLeftImage = new ImageLoader();
    ImageLoader rockRightImage = new ImageLoader();
    ImageView leftHand = new ImageView();
    ImageView rightHand = new ImageView();
    ImageView watch1 = new ImageView();
    ImageView watch2 = new ImageView();
    ImageView watch3 = new ImageView();
    ImageView watch4 = new ImageView();
    ImageView watch5 = new ImageView();
    ImageView heartMe1 = new ImageView();
    ImageView heartMe2 = new ImageView();
    ImageView heartMe3 = new ImageView();
    ImageView heartThem1 = new ImageView();
    ImageView heartThem2 = new ImageView();
    ImageView heartThem3 = new ImageView();
    ImageView imageViewWon = new ImageView();
    ImageView imageViewLost = new ImageView();
    ImageView imageViewTie = new ImageView();
    int winStreak = 0;
    Glow glow = new Glow();
    

    @Override
    public void start(Stage st) throws Exception {        
        
        //Sets stage title
        st.setTitle("Rock Paper Scissors") ;

        //Starting left Hand setting images and positions
        leftHand.setImage(rockLeftImage.LeftHandImage("rock"));
        leftHand.setX(-60);
        leftHand.setY(295);
        leftHand.setFitWidth(360);
        leftHand.setPreserveRatio(true);
        
        //Right Hand setting images and positions
        rightHand.setImage(rockRightImage.RightHandImage("rock"));
        rightHand.setX(600);
        rightHand.setY(295);
        rightHand.setFitWidth(360);
        rightHand.setPreserveRatio(true);
        
        //Win Streak Watches
        //Watches on wrist
        ImageLoader watchImage1 = new ImageLoader();
        watch1.setImage(watchImage1.watchImage());
        watch1.setX(55);
        watch1.setY(354);
        watch1.setFitWidth(80);
        watch1.setPreserveRatio(true);
        watch1.setVisible(false);
        
        watch2.setImage(watchImage1.watchImage());
        watch2.setX(-8);
        watch2.setY(363);
        watch2.setFitWidth(80);
        watch2.setPreserveRatio(true);
        watch2.setVisible(false);
        
        
        //watches on floor
        ImageLoader watchImage2 = new ImageLoader();
        watch3.setImage(watchImage2.watchFloorImage());
        watch3.setX(45);
        watch3.setY(560);
        watch3.setFitWidth(60);
        watch3.setPreserveRatio(true);
        watch3.setVisible(false);
        
        watch4.setImage(watchImage2.watchFloorImage());
        watch4.setX(95);
        watch4.setY(540);
        watch4.setFitWidth(60);
        watch4.setPreserveRatio(true);
        watch4.setScaleX(-1);
        watch4.setVisible(false);
        
        watch5.setImage(watchImage2.watchFloorImage());
        watch5.setX(100);
        watch5.setY(575);
        watch5.setFitWidth(60);
        watch5.setPreserveRatio(true);
        watch5.setScaleX(-1);
        watch5.setRotate(30);
        watch5.setVisible(false);
        
        
        //Your heart counters
        ImageLoader heartImage1 = new ImageLoader();
        heartMe1.setFitWidth(40);
        heartMe1.setPreserveRatio(true);
        heartMe1.setImage(heartImage1.heartImage());
        
        heartMe2.setFitWidth(40);
        heartMe2.setPreserveRatio(true);
        heartMe2.setImage(heartImage1.heartImage());
        
        heartMe3.setFitWidth(40);
        heartMe3.setPreserveRatio(true);
        heartMe3.setImage(heartImage1.heartImage());
        
        
        //Opponents heart counters
        heartThem1.setFitWidth(40);
        heartThem1.setPreserveRatio(true);
        heartThem1.setImage(heartImage1.heartImage());
        
        heartThem2.setFitWidth(40);
        heartThem2.setPreserveRatio(true);
        heartThem2.setImage(heartImage1.heartImage());
        
        heartThem3.setFitWidth(40);
        heartThem3.setPreserveRatio(true);
        heartThem3.setImage(heartImage1.heartImage());
        
        
        //hBoxes for hearts
        HBox heartContainer1 = new HBox();
        heartContainer1.getChildren().addAll(heartMe1, heartMe2, heartMe3);
        HBox heartContainer2 = new HBox();
        heartContainer2.getChildren().addAll(heartThem1, heartThem2, heartThem3);
        
        
        //Labes for heart counters
        Label yourLives = new Label("Your Lives");
        yourLives.setStyle("-fx-text-fill: white");
        yourLives.setFont(new Font("Arial", 25));
        
        Label theirLives = new Label("Their Lives") ;
        theirLives.setStyle("-fx-text-fill: white");
        theirLives.setFont(new Font("Arial", 25));
        
        
        //Boxes for labels and counters
        vBoxLeft.getChildren().addAll(yourLives, heartContainer1);
        vBoxLeft.setTranslateX(45);
        vBoxLeft.setTranslateY(180);
        vBoxLeft.setAlignment(Pos.CENTER);
        vBoxLeft.setVisible(false);
        
        vBoxRight.getChildren().addAll(theirLives, heartContainer2);
        vBoxRight.setTranslateX(730);
        vBoxRight.setTranslateY(180);
        vBoxRight.setAlignment(Pos.CENTER);
        vBoxRight.setVisible(false);
        
        
        //Outcome image of "You Won" flashing if you win a match
        Skins wonSkin = new Skins();
        wonSkin.outcomeSkin(imageViewWon, "won");
        imageViewWon.setTranslateX(348);
        imageViewWon.setTranslateY(325);
        
        
        //Outcome image of "You Lost" flashing if you lose a match
        Skins lostSkin = new Skins();
        lostSkin.outcomeSkin(imageViewLost, "lost");
        imageViewLost.setTranslateX(340);
        imageViewLost.setTranslateY(325);


        //Outcome image of "Tie" flashing if you tie a match
        Skins tieSkin = new Skins();
        tieSkin.outcomeSkin(imageViewTie, "tie");
        imageViewTie.setTranslateX(408);
        imageViewTie.setTranslateY(325);

         
        //Buttons for Rock, Paper, Scissors
        //Calls method opponentChoice to handle image changes and win conditions
        //These actions update HP labels, update player hand image, and show outcome
        
        //Rock Button
        Button rockButton = new Button();
        ImageLoader buttonRockImage = new ImageLoader();
        ImageView ButtonRock = new ImageView(buttonRockImage.ButtonRockImage());
        ButtonRock.setFitWidth(130);
        ButtonRock.setPreserveRatio(true);
        rockButton.setGraphic(ButtonRock);
        rockButton.setBackground(null);
        Skins buttonRock = new Skins();
        buttonRock.buttonGlow(rockButton);
        rockButton.setOnAction((ActionEvent event) -> {
            leftHand.setImage(rockLeftImage.LeftHandImage("rock"));
            try {
                rightHand.setImage(opponentChoice("Rock"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
            int outcomes = checkWin("Rock", opponentMove, st);
            if(outcomes == 0){
                imageViewLost.setVisible(true);             
            }else if(outcomes == 1){
                imageViewTie.setVisible(true);           
            }else{  
                imageViewWon.setVisible(true);  
            }  
            heartRemover();
        });
        
        //Paper Button
        Button paperButton = new Button();
        ImageLoader buttonPaperImage = new ImageLoader();
        ImageView ButtonPaper = new ImageView(buttonPaperImage.ButtonPaperImage());
        ButtonPaper.setFitWidth(130);
        ButtonPaper.setPreserveRatio(true);
        paperButton.setGraphic(ButtonPaper);
        paperButton.setBackground(null);
        Skins buttonPaper = new Skins();
        buttonPaper.buttonGlow(paperButton);
        paperButton.setOnAction((ActionEvent event) -> {
            leftHand.setImage(rockLeftImage.LeftHandImage("paper"));
                        try {
                rightHand.setImage(opponentChoice("Paper"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
            int outcomes = checkWin("Paper", opponentMove, st);
            if(outcomes == 0){
                imageViewLost.setVisible(true);             
            }else if(outcomes == 1){
                imageViewTie.setVisible(true);           
            }else{  
                imageViewWon.setVisible(true);  
            }
            heartRemover();
        });
        
        //Scissors Button
        Button scissorButton = new Button();
        ImageLoader buttonScissorsImage = new ImageLoader();
        ImageView ButtonScissors = new ImageView(buttonScissorsImage.ButtonScissorsImage());
        ButtonScissors.setFitWidth(130);
        ButtonScissors.setPreserveRatio(true);
        scissorButton.setGraphic(ButtonScissors);
        scissorButton.setBackground(null);
        Skins buttonScissors = new Skins();
        buttonScissors.buttonGlow(scissorButton);
        scissorButton.setOnAction((ActionEvent event) -> {
            leftHand.setImage(rockLeftImage.LeftHandImage("scissors"));
            try {
                rightHand.setImage(opponentChoice("Scissors"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
            }
            int outcomes = checkWin("Scissors", opponentMove, st);
            if(outcomes == 0){
                imageViewLost.setVisible(true);             
            }else if(outcomes == 1){
                imageViewTie.setVisible(true);           
            }else{  
                imageViewWon.setVisible(true);  
            }
            heartRemover();
        });
        
        
        //Hbox to house user choice buttons
        buttonBox.getChildren().addAll(rockButton, paperButton, scissorButton);
        buttonBox.setTranslateX(190);
        buttonBox.setTranslateY(540);
        buttonBox.setSpacing(30);
        buttonBox.setVisible(false);
        
        
        //Start button
        //Check Skins Class for more
        Skins buttonSkinStart = new Skins();
        buttonSkinStart.buttonSkinStart(startButton);
        buttonSkinStart.buttonGlow(startButton);
        startButton.setTranslateX(383);
        startButton.setTranslateY(300);   
        startButton.setOnAction((ActionEvent event) -> {
        Media m = new Media(Paths.get("src\\Sounds\\Bell.mp3").toUri().toString());
                new MediaPlayer(m).play();
                freshStart();    
        });
       
        
        //Loading Panes
        Pane root = new Pane();
        root.getChildren().addAll(rightHand, leftHand, vBoxLeft, vBoxRight, buttonBox, imageViewWon, imageViewLost, watch1, watch2, watch3, watch4, watch5, startButton, imageViewTie);
        Scene sc = new Scene(root, 900, 630);
        
        
        //Background
        ImageLoader backgroundImage1 = new ImageLoader();
        BackgroundSize backgroundSize = new BackgroundSize(500, 500, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundImage1.backgroundImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background bg = new Background(backgroundImage);
        root.setBackground(bg);
        
        
        //scene setting
        st.setScene(sc);
        st.show();
        
        }
    
    //This method determines the opponents choice and sets the image accordingly
    public Image opponentChoice(String playerChoice) throws FileNotFoundException{
        int rand = (int)(Math.random() * 3);
        imageViewWon.setVisible(false);
        imageViewLost.setVisible(false);
        imageViewTie.setVisible(false);
        if (rand == 0) {
            opponentMove = "Rock";
            return rockRightImage.RightHandImage("rock");
            }
        else if(rand == 1){
            opponentMove = "Paper";
            return rockRightImage.RightHandImage("paper");
            }
        else{
            opponentMove = "Scissors";
            return rockRightImage.RightHandImage("scissors");
            }
       
    }

    //This method checks each players hp to see if a round has been won 
    public int checkWin(String user, String computer, Stage st){
        //setting up sound files for reactions
        Media m1 = new Media(Paths.get("src\\Sounds\\LostReaction.mp3").toUri().toString());
        Media m2 = new Media(Paths.get("src\\Sounds\\Applause.mp3").toUri().toString());
        Media m3 = new Media(Paths.get("src\\Sounds\\Gasp.mp3").toUri().toString());
                        
        if(user.equals(computer)){
            new MediaPlayer(m3).play();
            return 1;
        }else if(user.equals("Rock")){
                if(computer.equals("Scissors")){
                    new MediaPlayer(m2).play();
                    hpThem--;
                    if(hpThem == 0){
                        try {
                            victoryScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    return 2;
                }
                else if (computer.equals("Paper")){
                    new MediaPlayer(m1).play();
                    hpYou--;
                    if(hpYou == 0){
                        try {
                            losingScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return 0;
                }                
        }else if(user.equals("Scissors")){
                if(computer.equals("Paper")){
                    new MediaPlayer(m2).play();
                    hpThem--;
                    if(hpThem == 0){
                        try {
                            victoryScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return 2;
                }
                else if (computer.equals("Rock")){
                    new MediaPlayer(m1).play();
                    hpYou--;
                    if(hpYou == 0){
                        try {
                            losingScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return 0;
                }               
            }else if(user.equals("Paper")){
                if(computer.equals("Rock")){
                    new MediaPlayer(m2).play();
                    hpThem--;
                    if(hpThem == 0){
                        try {
                            victoryScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return 2;
                }
                else if (computer.equals("Scissors")){
                    new MediaPlayer(m1).play();
                    hpYou--;
                    if(hpYou == 0){
                        try {
                            losingScreen(st);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return 0;
                }
            }
        return 0;
    }
    
    
    public void victoryScreen(Stage st) throws FileNotFoundException{
        Stage winningStage = new Stage();
        winningStage.setResizable(false);
        winningStage.initModality(Modality.APPLICATION_MODAL);
        
        //disabling buttons
        startButton.setVisible(true);
        buttonBox.setVisible(false);
        vBoxLeft.setVisible(false);
        vBoxRight.setVisible(false);
            
        //Labels for congratulatory text
        Label youWon = new Label("Nice Handiwork!");
        Font fontb3 = Font.font("Arial", FontWeight.BOLD, 18);
        youWon.setFont(fontb3);
        youWon.setStyle("-fx-text-fill: white");
        Label youWon2 = new Label("You Won!");
        youWon2.setFont(fontb3);
        youWon2.setStyle("-fx-text-fill: white");
        
        //Button to close scene and reset hands
        Button closeButton = new Button("Close");
        Font fontb2 = Font.font("Arial", FontWeight.BOLD, 18);
        closeButton.setFont(fontb2);
        closeButton.setOnAction((ActionEvent event) -> {
                winningStage.close();
                leftHand.setImage(rockLeftImage.LeftHandImage("rock"));
                rightHand.setImage(rockRightImage.RightHandImage("rock"));
                addStreak();
                resetScreen();
        });
        
        //Trophy Image
        ImageLoader trophyImage = new ImageLoader();
        ImageView imageViewTrophy = new ImageView(trophyImage.TrophyImage());
        imageViewTrophy.setFitWidth(220);
        imageViewTrophy.setPreserveRatio(true);
        
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        separator.setValignment(VPos.CENTER);
        separator.setPrefHeight(25);
        separator.setVisible(false);
        
        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setValignment(VPos.CENTER);
        separator2.setPrefHeight(10);
        separator2.setVisible(false);
        
        //vBox
        VBox vBoxVictory = new VBox();
        vBoxVictory.getChildren().addAll(imageViewTrophy, youWon, separator, youWon2, separator2, closeButton);
        vBoxVictory.setTranslateX(18);
        vBoxVictory.setTranslateY(30);
        vBoxVictory.setSpacing(05);
        vBoxVictory.setAlignment(Pos.CENTER);

        //adding objects to pane
        Pane winPane = new Pane();
        winPane.getChildren().addAll(vBoxVictory);
        
        //background Image
        ImageLoader victoryBG = new ImageLoader();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(victoryBG.VictoryBGImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background bg = new Background(backgroundImage);
        winPane.setBackground(bg);
        
        //Setting the stage
        Scene winningScene =  new Scene(winPane, 240, 360);
        winningStage.setScene(winningScene);
        winningStage.initStyle(StageStyle.UNDECORATED);
        winningStage.setX(st.getX() + 338);
        winningStage.setY(st.getY() + 220);
        winningStage.show();
    }
    
    public void losingScreen(Stage st) throws FileNotFoundException{
        Stage losingStage = new Stage();
        losingStage.setResizable(false);
        losingStage.initModality(Modality.APPLICATION_MODAL);

        //disabling buttons
        startButton.setVisible(true);
        buttonBox.setVisible(false);
        vBoxLeft.setVisible(false);
        vBoxRight.setVisible(false);
        
        //Labels for losing text
        Label youLost = new Label("You Lost");
        Font fontb3 = Font.font("Arial", FontWeight.BOLD, 20);
        youLost.setFont(fontb3);
        youLost.setStyle("-fx-text-fill: white");
        
        Label youLost2 = new Label("Better Luck");
        youLost2.setFont(fontb3);
        youLost2.setStyle("-fx-text-fill: white");
        
        Label youLost3 = new Label("Next Time");
        youLost3.setFont(fontb3);
        youLost3.setStyle("-fx-text-fill: white");
        
        //Button to close scene and reset hands
        Button closeButton = new Button("Close");
        Font fontb2 = Font.font("Arial", FontWeight.BOLD, 18);
        closeButton.setFont(fontb2);
        closeButton.setOnAction((ActionEvent event) -> {
                losingStage.close();
                leftHand.setImage(rockLeftImage.LeftHandImage("rock"));
                rightHand.setImage(rockRightImage.RightHandImage("rock"));
                endStreak();
                resetScreen();   
        });
        
        //Loser Image
        ImageLoader loserHandImage = new ImageLoader();
        ImageView imageViewLoser = new ImageView(loserHandImage.LoserHandImage());
        imageViewLoser.setFitWidth(190);
        imageViewLoser.setTranslateX(25);
        imageViewLoser.setTranslateY(50);
        imageViewLoser.setPreserveRatio(true);
        
        //Separators to add spacing 
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        separator.setValignment(VPos.CENTER);
        separator.setPrefHeight(25);
        separator.setVisible(false);
        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setValignment(VPos.CENTER);
        separator2.setPrefHeight(10);
        separator2.setVisible(false);
        
        //vBox
        VBox vBoxLosing = new VBox();
        vBoxLosing.getChildren().addAll(youLost2, youLost3, separator, closeButton);
        vBoxLosing.setTranslateX(71);
        vBoxLosing.setTranslateY(220);
        vBoxLosing.setSpacing(05);
        vBoxLosing.setAlignment(Pos.CENTER);

        //adding objects to pane
        Pane losePane = new Pane();
        losePane.getChildren().addAll(vBoxLosing, imageViewLoser);
        
        //background Image
        ImageLoader victoryBG = new ImageLoader();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(victoryBG.VictoryBGImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background bg = new Background(backgroundImage);
        losePane.setBackground(bg);
        
        //Setting the stage
        Scene losingScene =  new Scene(losePane, 240, 360);
        losingStage.setScene(losingScene);
        losingStage.initStyle(StageStyle.UNDECORATED);
        losingStage.setX(st.getX() + 338);
        losingStage.setY(st.getY() + 220);
        losingStage.show();
    }
    
    //This method is called when the user loses a round
    //It resets the Win Streak Watches visible 
    public void endStreak(){
         winStreak = 0;
         watch1.setVisible(false);
         watch2.setVisible(false);
         watch3.setVisible(false);
         watch4.setVisible(false);
         watch5.setVisible(false);
        }
        
    //This method is called when the user wins a round
    //it adds a Win Streak Watch to the players hand or floor
     public void addStreak(){
        winStreak++;
        if(winStreak == 1){
           watch1.setVisible(true); 
        }else if(winStreak ==2){
           watch2.setVisible(true); 
        }else if(winStreak ==3){
            watch3.setVisible(true);
        }else if(winStreak ==4){
            watch4.setVisible(true);
        }else if(winStreak ==5){
            watch5.setVisible(true);
        }
        }
        
     //This method removes heart images as the players lose hp
    public void heartRemover(){
        //removes your hearts
        if (hpYou == 2){
            heartMe3.setVisible(false);
        }else if (hpYou == 1){
            heartMe2.setVisible(false);
        }else if (hpYou == 0){
            heartMe1.setVisible(false);
        }
        //removes opponnents hearts
        if (hpThem == 2){
            heartThem3.setVisible(false);
        }else if (hpThem == 1){
            heartThem2.setVisible(false);
        }else if (hpThem == 0){
            heartThem1.setVisible(false);
        }
    }
    
    //This method removes the flashing outcome images
    public void resetScreen(){
        imageViewWon.setVisible(false);
        imageViewLost.setVisible(false);
        imageViewTie.setVisible(false);
    }
    
    //This method resets the screen back to its original state (except for watches)
    public void freshStart(){
                hpYou = 3;
                hpThem = 3;
                startButton.setVisible(false);
                buttonBox.setVisible(true);
                vBoxLeft.setVisible(true);
                vBoxRight.setVisible(true);
                heartMe1.setVisible(true);
                heartMe2.setVisible(true);
                heartMe3.setVisible(true);
                heartThem1.setVisible(true);
                heartThem2.setVisible(true);
                heartThem3.setVisible(true);
    }
    
    // Main Method to launch the game
    public static void main(String args[])
    {
    // launch the application
    launch(args);
    }
}