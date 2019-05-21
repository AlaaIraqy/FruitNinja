package View;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
  
public class Instruction {
	MainMenu mainmenu;
	Stage stage;
    public Scene scene;
    Group root;
	public Instruction(Stage stage) {
		this.stage=stage;
	}
	
	public void PrepareScene() {
		root=new Group();
		Image image=new Image("file:ins.png");
		ImageView imagee=new ImageView(image);
		fxxxbutton bt4 = new fxxxbutton("Back");
		  TranslateTransition translate4 = new TranslateTransition(); 
		  translate4.setByX(780);
		  translate4.setByY(500);
		  translate4.setDuration(Duration.seconds(1.5));
		  translate4.setNode(bt4); 
		  translate4.play();  
		  bt4.setOnAction(m->{
         	 stage.setScene(mainmenu.getScene());
			});
		root.getChildren().addAll(imagee,bt4);
		scene=new Scene(root,1000,600);
		
}
	
	Scene getScene() {
		return scene;
	}

	void setScene(Scene scene) {
		this.scene = scene;
	}
	public void setMainmenu(MainMenu mainmenu) {
		this.mainmenu = mainmenu;
	}
	}
