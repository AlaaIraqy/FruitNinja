package View;
import java.awt.Color;
import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainMenu {
	Scene scene;
	Stage stage;
	Instruction instruction;
	NewGame newGame;
	LoadGui loadgui;
	Media intro = new Media(new File("intro (2).mp3").toURI().toString()); 
	 MediaPlayer introPlayer = new MediaPlayer(intro); 
	public MediaPlayer getIntroPlayer() {
		return introPlayer;
	}

	public void setIntroPlayer(MediaPlayer introPlayer) {
		this.introPlayer = introPlayer;
	}

	public MainMenu(Stage stage) {
		this.stage=stage;
	}
	public void PrepareScene() {
		introPlayer.play();
		fxxxbutton bt1 = new fxxxbutton("New Game");
		//bt1.setShape(new Circle(1.5));
		//bt1.setMinSize(100,100);
		//bt1.setStyle("-fx-background-color: Yellow");
		 TranslateTransition translate3 = new TranslateTransition();  
	      translate3.setByX(400);
		  translate3.setByY(180);
		  translate3.setDuration(Duration.seconds(1.5));
		  translate3.setNode(bt1); 
		  translate3.play();
		
		bt1.setOnAction(m->{
		    newGame.setIntro(introPlayer);
		    newGame.PrepareScene();
			stage.setScene(newGame.getScene());
	
		});
		
		
		fxxxbutton bt2 = new fxxxbutton("Load Game");
		//bt2.setShape(new Circle(1.5));
		//bt2.setMinSize(100,100);
	    //bt2.setStyle("-fx-background-color: Blue");
	    TranslateTransition translate2 = new TranslateTransition();  
	      translate2.setByX(400);
		  translate2.setByY(270);
		  translate2.setDuration(Duration.seconds(1.5));
		  translate2.setNode(bt2); 
		  translate2.play();
	    
        bt2.setOnAction(m->{
            loadgui.setIntro(introPlayer);
			loadgui.PrepareScene();
			
			stage.setScene(loadgui.getScene());
		});
		
		fxxxbutton bt3 = new fxxxbutton("Exit");
		//bt3.setShape(new Circle(1.5));
		//bt3.setMinSize(100,100);
		 //bt3.setStyle("-fx-background-color: Purple");
		 
		  TranslateTransition translate = new TranslateTransition();  
		  translate.setByX(400);
		  translate.setByY(420);
		  translate.setDuration(Duration.seconds(1.5));
		  translate.setNode(bt3); 
		
		  translate.play();  
		  
		 
		 
        bt3.setOnAction(m->{
			stage.close();
		});
        fxxxbutton bt4 = new fxxxbutton("Instruction");
        TranslateTransition translate4 = new TranslateTransition();  
		  translate4.setByX(400);
		  translate4.setByY(350);
		  translate4.setDuration(Duration.seconds(1.5));
		  translate4.setNode(bt4); 
		
		  translate4.play();  
		  bt4.setOnAction(m->{
			  instruction.PrepareScene();
			  stage.setScene(instruction.getScene());
			});
       Pane root = new Pane();  
       String background="-fx-background-image: url('file:backgroundMain.png');";
       root.setStyle(background);
        root.getChildren().addAll(bt3,bt2,bt1,bt4);  
           	 scene=new Scene(root,1000,600);
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	public void setNewGame(NewGame newGame) {
		this.newGame=newGame;
	}

	public void setLoadgui(LoadGui loadgui) {
		this.loadgui = loadgui;
	}
	public void setInstruction(Instruction instruction){
		this.instruction=instruction;
	}

}
