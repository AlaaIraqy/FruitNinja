package application;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Game1 extends Application {
	
	AnimationTimer timer;
	Pane root = new Pane();
	List<ImageView> drop = new ArrayList<>();
	double mouseX;
	double mouseY;
	
	ImageView swordiv;
	double speed;
	double falling;
	Label lblMissed;
	int missed;

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String background ="-fx-background-image: url('file:background.png');";
		root.setStyle(background);
	
		
		 Image sword = new Image("sword.png");
		 swordiv = new ImageView(sword);
		 
		
		
		swordiv.setFitHeight(160);
		swordiv.setFitWidth(100);
		
		
		
		lblMissed = new Label("Missed: 0");
		lblMissed.setLayoutX(10);
		lblMissed.setLayoutY(10);
		missed = 0;
		
		speed = 1;
		falling = 500;
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
			 Image apple = new Image("apple.png");
			 ImageView appleiv = new ImageView(apple);
			 appleiv.setLayoutX(rand(0,1000));
				appleiv.setLayoutY(1);
			// appleiv.setFitHeight(150);
			 //appleiv.setFitWidth(120);	
			speed += falling / 3000;
			drop.add(appleiv);
			root.getChildren().add((Node) (drop.get(drop.size() -1)));
        })); 
		
		timeline.setCycleCount(1000);
		timeline.play();
		
		
		
		timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				gameUpdate();
				
			}
			
		};
		timer.start();	
		
		//cont = swordiv;
	
		root.getChildren().addAll( swordiv ,lblMissed);
		
		Scene scene = new Scene(root, 1000, 600);
		scene.setCursor(Cursor.NONE);
		
		scene.setOnMouseMoved(e -> {
			
			mouseX = e.getX();
			mouseY = e.getY();
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/*public ImageView circle() {
		Circle circle = new Circle();
		circle.setLayoutX(rand(0, 1000));
		circle.setLayoutY(1);
		circle.setRadius(20);
		circle.setFill(Color.BLUE);
		return circle;
	}*/
	
	public Rectangle rectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setLayoutX(200);
		rectangle.setLayoutY(550);
		rectangle.setHeight(50);
		rectangle.setWidth(70);
		rectangle.setFill(Color.GREEN);
		return rectangle;
		
	}
	
	public int rand(int min, int max) {
		return (int)(Math.random() * max + min);
	}
	public void gameUpdate(){
		
		swordiv.setLayoutX(mouseX);
		swordiv.setLayoutY(mouseY);
		
		for(int i = 0; i < drop.size(); i++) {
			((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY() + speed + ((ImageView) drop.get(i)).getLayoutY() / 150 );
			//if get droped into square
			if((((ImageView) drop.get(i)).getLayoutX() > swordiv.getLayoutX() && ((ImageView) drop.get(i)).getLayoutX() < swordiv.getLayoutX() + 70) &&
					((ImageView) drop.get(i)).getLayoutY() > swordiv.getLayoutY() && ((ImageView) drop.get(i)).getLayoutY() < swordiv.getLayoutY() + 70)	{
				//root.getChildren().remove(((ImageView) drop.get(i)));
				//drop.remove(i);
				Image cut = new Image("apple-1.png");
		        drop.get(i).setImage(cut); 
			}
				
			//if missed remove
			else if(((ImageView) drop.get(i)).getLayoutY() >= 590) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				drop.remove(i);
				missed += 1;
				lblMissed.setText("Missed: " + String.valueOf(missed));
			}
		}
	}

}