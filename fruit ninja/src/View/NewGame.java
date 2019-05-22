package View;
import Model.Arcade;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
public class NewGame {
	Scene scene;
	Stage stage;
	MainMenu mainmenu;
	ClassicMode arcadeGame;
	MediaPlayer intro;
	GameGui gamegui;
	public NewGame(Stage stage) {
		this.stage=stage;
	}
	
	
	public void PrepareScene() {
		fxxxbutton bt1 = new fxxxbutton("Classic");
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
			arcadeGame.setIntro(intro);
			arcadeGame.PrepareScene();
			stage.setScene(arcadeGame.getScene());
		});
		
		
		fxxxbutton bt2 = new fxxxbutton("Arcade");
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
			gamegui.setStrategy(new Arcade());
        	gamegui.prepareScene();
        	stage.setScene(gamegui.getScene());
        	intro.stop();
			
		});
        
        fxxxbutton bt3 = new fxxxbutton("Back");
		//bt3.setShape(new Circle(1.5));
		//bt3.setMinSize(100,100);
		 //bt3.setStyle("-fx-background-color: Purple");
		 
		  TranslateTransition translate = new TranslateTransition();  
		  translate.setByX(400);
		  translate.setByY(350);
		  translate.setDuration(Duration.seconds(1.5));
		  translate.setNode(bt3); 
		
		  translate.play();  
		  
		 
		 
        bt3.setOnAction(m->{
			stage.setScene(mainmenu.getScene());
		});
		
		
        
       Pane root = new Pane();  
       String background="-fx-background-image: url('file:backgroundMain.png');";
       root.setStyle(background);
        root.getChildren().addAll(bt2,bt1,bt3);  
           	 scene=new Scene(root,1000,600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void SetMainMenu(MainMenu mainmenu) {
		this.mainmenu=mainmenu;
	}
	
	public void SetArcadeGame(ClassicMode arcadeGame) {
		this.arcadeGame=arcadeGame;
	}


	public void setIntro(MediaPlayer intro) {
		this.intro = intro;
	}
	public void setGameGui(GameGui gamegui) {
		this.gamegui = gamegui;
	}
	
}
