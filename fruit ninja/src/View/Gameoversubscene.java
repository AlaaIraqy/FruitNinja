package View;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;


public class Gameoversubscene extends SubScene {
	public TranslateTransition transition= new TranslateTransition(); 
	private String backimage="file:gameover.png";
	

	public Gameoversubscene() {
		super(new AnchorPane(), 700, 700);
		prefWidth(600);
		prefHeight(400);
		BackgroundImage image=new BackgroundImage(new Image(backimage,700,700,false,true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2=(AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));
		setLayoutX(150);
		setLayoutY(-810);
		
	}
	public void moveSubscene() {
		
		

				transition =new TranslateTransition();
				transition.setDuration(Duration.seconds(2.95));
				transition.setNode(this);
				
				transition.setToY(710);
				transition.play();
				
			   

				
				
			}

}
