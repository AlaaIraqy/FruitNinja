package View;
import Model.Difficult;
import Model.Easy;
import Model.Medium;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClassicMode {
	Scene scene;
	Stage stage;
	GameGui gamegui;
	NewGame newGame;
	MediaPlayer intro;
	public ClassicMode(Stage stage) {
		this.stage=stage;
	}
	
	public void PrepareScene() {
		fxxxbutton bt1 = new fxxxbutton("Easy");
		//bt1.setShape(new Circle(1.5));
	//	bt1.setMinSize(100,100);
		//bt1.setStyle("-fx-background-color: Yellow");
		
		 TranslateTransition translate3 = new TranslateTransition();  
	      translate3.setByX(600);
		  translate3.setByY(150);
		  translate3.setDuration(Duration.seconds(1.5));
		  translate3.setNode(bt1); 
		  translate3.play();
		
		bt1.setOnAction(m->{
			intro.stop();
	          gamegui.setStrategy(new Easy());
	          gamegui.prepareScene();
	          stage.setScene(gamegui.getScene());
		});
		
		
		fxxxbutton bt2 = new fxxxbutton("Normal");
		//bt2.setShape(new Circle(1.5));
		//bt2.setMinSize(100,100);
	    //bt2.setStyle("-fx-background-color: Blue");
	    TranslateTransition translate2 = new TranslateTransition();  
	      translate2.setByX(400);
		  translate2.setByY(250);
		  translate2.setDuration(Duration.seconds(1.5));
		  translate2.setNode(bt2); 
		  translate2.play();
	    
        bt2.setOnAction(m->{
        	intro.stop();
        	gamegui.setStrategy(new Medium());
        	  gamegui.prepareScene();
        	  stage.setScene(gamegui.getScene());
		});
        
        fxxxbutton bt3 = new fxxxbutton("Hard");
		//bt3.setShape(new Circle(1.5));
		//bt3.setMinSize(100,100);
		// bt3.setStyle("-fx-background-color: Purple");
		 
		  TranslateTransition translate = new TranslateTransition();  
		  translate.setByX(200);
		  translate.setByY(400);
		  translate.setDuration(Duration.seconds(1.5));
		  translate.setNode(bt3); 
		
		  translate.play();  
		  
		 
		 
        bt3.setOnAction(m->{
        	intro.stop();
        	  gamegui.setStrategy(new Difficult());
        	  gamegui.prepareScene();
        	  stage.setScene(gamegui.getScene());
		});
        
        fxxxbutton bt4 = new fxxxbutton("Back");
    // 		bt4.setShape(new Circle(1.5));
     	//	bt4.setMinSize(100,100);
     		// bt4.setStyle("-fx-background-color: Purple");
     		 
     		  TranslateTransition translate4 = new TranslateTransition();  
     		  translate4.setByY(500);
     		  translate4.setDuration(Duration.seconds(1.5));
     		  translate4.setNode(bt4); 
     		
     		  translate4.play();  
     		  
     		 
     		 
             bt4.setOnAction(m->{
            	 intro.stop();
            	 stage.setScene(newGame.getScene());
     			
     		});
		
		
        
       Pane root = new Pane();  
        root.getChildren().addAll(bt4,bt3,bt2,bt1);  
        String background="-fx-background-image: url('file:backgroundMain.png');";
        root.setStyle(background);
           	 scene=new Scene(root,1000,600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void SetNewGame(NewGame newGame) {
		this.newGame=newGame;
	}

	public void setGamegui(GameGui gamegui) {
		this.gamegui = gamegui;
		
	}
	public void setIntro(MediaPlayer intro) {
		this.intro=intro;
	}
}
