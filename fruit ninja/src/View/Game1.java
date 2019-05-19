package View;

import Model.*;
import Controller.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game1 extends Application {

	AnimationTimer timer;
	Pane root = new Pane();
	List<ImageView> drop = new ArrayList<>();
	IGameStrategy strategy = new Difficult();
//	List<GameObject> dropFruit = new ArrayList<>();
	double mouseX;
	double mouseY;
	int random;
	int timing=0;
	// int lives = 3;
	// int score = 0;
	ImageView swordiv;
	// double speed;
	// double falling;
	Label lblscore;
	Label lblmissed;
	Label lbltimer;

	// int missed = 0;
	Timeline timeline;

	GameObject fruit;
	Gameoversubscene gameover = new Gameoversubscene();

	GameActions controller = new ControllerFruit();
	long start = System.currentTimeMillis();
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//	    dropFruit = controller.getObjectList();
		controller.setStrategy(strategy);
		String background = "-fx-background-image: url('file:background.png');";
		root.setStyle(background);
		root.getChildren().add(gameover);
		Image sword = new Image("sword.png");
		swordiv = new ImageView(sword);

		swordiv.setFitHeight(160);
		swordiv.setFitWidth(100);
		lblscore = new Label("Score: 0");
		lblscore.setFont(new Font("Arial", 40));
		lblscore.setLayoutX(10);
		lblscore.setLayoutY(10);
		lblscore.setStyle("-fx-text-fill: white;-fx-background-color: linear-gradient(#E4EAA2, #ff0000);-fx-border-color:black; -fx-padding:4px;");
		lblmissed = new Label("Lives: " + controller.getLives());
		lblmissed.setFont(new Font("Arial", 40));
		lblmissed.setLayoutX(830);
		lblmissed.setLayoutY(10);
		lblmissed.setStyle("-fx-text-fill: white;-fx-background-color: linear-gradient(#E4EAA2, #ff0000);-fx-border-color:black; -fx-padding:4px;");
		 lbltimer = new Label("Time: "+timing);
		lbltimer.setFont(new Font("Arial", 40));
		lbltimer.setLayoutX(10);
		lbltimer.setLayoutY(100);
		lbltimer.setStyle("-fx-text-fill: white;-fx-background-color: linear-gradient(#E4EAA2, #0000ff);-fx-border-color:black; -fx-padding:4px;");
		// missed = 0;

		// speed = 0.2;
		// falling = 500;
		timeline = new Timeline(new KeyFrame(Duration.millis(strategy.getFalling()), event -> {
            
			controller.createGameObject();

			controller.getObjectList().get(controller.getListCount() - 1).setCutFlag(true);

			Image fruitimg = SwingFXUtils.toFXImage(
					controller.getObjectList().get(controller.getListCount() - 1).getBufferedImages()[0], null);
			ImageView fruitiv = new ImageView(fruitimg);
			fruitiv.setLayoutX(rand(50, 900));
			fruitiv.setLayoutY(1);
			drop.add(fruitiv);
			// System.out.println(controller.getObjectList().get(dropFruitCount)+"timline");

//			speed += falling / 3000;
			strategy.updateSpeed();

			root.getChildren().add((Node) (drop.get(drop.size() - 1)));
           timing++;
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
		drop.clear();

		root.getChildren().addAll(swordiv, lblscore, lblmissed,lbltimer);

		Scene scene = new Scene(root, 1000, 600);

		scene.setCursor(Cursor.NONE);

		scene.setOnMouseMoved(e -> {

			mouseX = e.getX();
			mouseY = e.getY();

		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public int rand(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	public void gameUpdate() {
	
		long finish=0;
	
		if(controller.getLives()!=0) {
	     finish = System.currentTimeMillis();
		}
	     long timeElapsed = finish - start;
		lbltimer.setText("Time: "+String.valueOf(timeElapsed/1000.0));
		swordiv.setLayoutX(mouseX);
		swordiv.setLayoutY(mouseY);
		Sword swrd = Sword.getInstance();
		swrd.setPositionX(mouseX);
		swrd.setPositionY(mouseY);

		for (int i = 0; i < drop.size(); i++) {
			controller.getObjectList().get(i).setXlocation(drop.get(i).getLayoutX());
			controller.getObjectList().get(i).setYlocation(drop.get(i).getLayoutY());
			((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY() + strategy.getSpeed()
					+ ((ImageView) drop.get(i)).getLayoutY() / 150);
			controller.setLives(controller.getLives());
			if (controller.getLives() > 0){
				lblmissed.setText("Lives: " + String.valueOf(controller.getLives()));
			}
			if (controller.sliceObjects(i) == true) {
				controller.getObjectList().get(i).setCutFlag(false);
				lblscore.setText("Score: " + String.valueOf(controller.getScore()));
				Image cutFruit = SwingFXUtils.toFXImage(controller.getObjectList().get(i).getBufferedImages()[1], null);
				Image cutFruit1 = SwingFXUtils.toFXImage(controller.getObjectList().get(i).getBufferedImages()[2],null);
				ImageView cutFruitiv = new ImageView(cutFruit1);
				cutFruitiv.setLayoutX(drop.get(i).getLayoutX() + 50);
				cutFruitiv.setLayoutY(drop.get(i).getLayoutY());
				if (controller.getObjectList().get(i) instanceof SpecialFruit) {
					Image effect = SwingFXUtils.toFXImage(controller.getObjectList().get(i).getBufferedImages()[3],null);
					ImageView effectiv = new ImageView(effect);
					effectiv.setLayoutX(drop.get(i).getLayoutX());
					effectiv.setLayoutY(drop.get(i).getLayoutY()-30);
					effectiv.setFitHeight(drop.get(i).getFitHeight() + 120);
					effectiv.setFitWidth(drop.get(i).getFitWidth()+120);
					root.getChildren().add(effectiv);
					TranslateTransition objeffect = new TranslateTransition();
					objeffect.setDuration(Duration.seconds(5));
					objeffect.setNode(effectiv);
					objeffect.setToY(1000);
					objeffect.play();
				}
				else if (controller.getObjectList().get(i) instanceof Boom){
					controller.setLives(controller.getLives());
					if (controller.getLives() >= 0){
						lblmissed.setText("Lives: " + String.valueOf(controller.getLives()));
					}

				}
				root.getChildren().add(cutFruitiv);
//				System.out.println("AFTER SLICE "+ i + "__" + controller.getObjectList().get(i));
				drop.get(i).setImage(cutFruit);
				// System.out.println(controller.getObjectList().get(i)+"gameupdate");
				TranslateTransition obj = new TranslateTransition();
				obj.setDuration(Duration.seconds(5));
				obj.setNode(drop.get(i));
				obj.setToY(1000);
				obj.play();
				TranslateTransition obj2 = new TranslateTransition();
				obj2.setDuration(Duration.seconds(5));
				obj2.setNode(cutFruitiv);
				obj2.setToY(1000);
				obj2.play();

				// root.getChildren().remove(drop.get(i));

				controller.getObjectList().remove(i);
				// root.getChildren().add(drop.get(i));

				drop.remove(i);

				// missed--;

			}

			// if missed remove
			else if (controller.hasMovedOfScreenBoundary(i)) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				drop.remove(i);
				controller.getObjectList().remove(i);
				controller.setLives(controller.getLives());
			}
			if (controller.getLives() == 0) {
				gameover.moveSubscene();
				lblmissed.setText("Lives: " + String.valueOf(controller.getLives()));
				for (int k = 0; k < drop.size(); k++) {
					root.getChildren().remove(drop.get(k));
				}
				drop.clear();
				timeline.pause();
			}
	}

}
}