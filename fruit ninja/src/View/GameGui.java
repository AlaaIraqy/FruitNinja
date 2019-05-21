package View;

import Model.*;
import Controller.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameGui  {
	NewGame newgame;
    Stage stage;
    Scene scene;
    ClassicMode classicMode;
	AnimationTimer timer;
	Pane root = new Pane();
	List<ImageView> drop = new ArrayList<>();
	IGameStrategy strategy;
	double mouseX;
	double mouseY;
	int random;
	int timing=0;
	int mins = 0;
	ImageView swordiv;
	Text score;
	Label lblscore;
	Label lblmissed;
	Label lblscore2;
	Text lbltimer;
	Text BestScore;
	ImageView heartiv0;
	ImageView heartiv1;
	ImageView heartiv2;
	ImageView Score;
	ImageView time;
	Button pause;
    Button resume;
	long timeElapsed=0;
	long finish=0;
	Timeline timeline;
	boolean valid=true;
    public GameGui(Stage stage) {
    	this.stage = stage;
    }
	GameObject fruit;
	Gameoversubscene gameover = new Gameoversubscene();
	PauseSubscene pausesubs = new PauseSubscene();
	 Media intro = new Media(new File("intro (2).mp3").toURI().toString()); 
	 MediaPlayer introPlayer = new MediaPlayer(intro); 
	 Media GameOver = new Media(new File("GameOver.mp3").toURI().toString()); 
	 MediaPlayer GameOverPlayer = new MediaPlayer(GameOver); 
	 Media splatter = new Media(new File("splatter.mp3").toURI().toString()); 
	 MediaPlayer splatterPlayer = new MediaPlayer(splatter); 
	 Media boom = new Media(new File("boom.mp3").toURI().toString()); 
	 MediaPlayer boomPlayer = new MediaPlayer(boom); 
	GameActions controller = ControllerFruit.getInstance();
	long start;
	public void prepareScene()  {
	start = System.currentTimeMillis();
		score=new Text("0");
		score.setFill(Color.ORANGE);
		score.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
		score.setLayoutX(70);
		score.setLayoutY(50);
		BestScore=new Text("Best Score:");
		BestScore.setFill(Color.ORANGE);
		BestScore.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		BestScore.setLayoutX(800);
		BestScore.setLayoutY(90);
		introPlayer.play();
		Image heart = new Image("file:heart.png");
		Image scorre=new Image("file:scoree.png");
		Image timee=new Image("file:timer.png");
		 heartiv0 = new ImageView(heart);
		 heartiv1=new ImageView(heart);
		 heartiv2=new ImageView(heart);
		 Score=new ImageView(scorre);
		 time=new ImageView(timee);
		heartiv0.setLayoutX(800);
		heartiv0.setLayoutY(10);
		heartiv1.setLayoutX(860);
		heartiv1.setLayoutY(10);
		heartiv2.setLayoutX(920);
		heartiv2.setLayoutY(10);
		Score.setLayoutX(20);
		Score.setLayoutY(10);
		time.setLayoutX(20);
		time.setLayoutY(80);
		lbltimer = new Text("00:00");
		lbltimer.setFill(Color.ORANGE);
		lbltimer.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
		lbltimer.setLayoutX(70);
		lbltimer.setLayoutY(120);
		controller.setStrategy(strategy);
		String background = "-fx-background-image: url('file:background.png');";
		root.setStyle(background);
		root.getChildren().addAll(gameover,heartiv0,heartiv1,heartiv2,Score,time,BestScore);
		Image sword = new Image("sword.png");
		swordiv = new ImageView(sword);
		swordiv.setFitHeight(160);
		swordiv.setFitWidth(100);
		pause = new Button("");
		resume = new Button("");
		ImageView pauseiv = new ImageView(new Image("pause.png"));
		pauseiv.setFitHeight(40);
		pauseiv.setFitWidth(40);
		pause.setLayoutX(30);
		pause.setLayoutY(500);
		pause.setGraphic(pauseiv);
		ImageView resumeiv = new ImageView(new Image("play.png"));
		resumeiv.setFitHeight(40);
		resumeiv.setFitWidth(40);
		resume.setLayoutX(100);
		resume.setLayoutY(500);
		resume.setGraphic(resumeiv);
		timeline = new Timeline(new KeyFrame(Duration.millis(strategy.getFalling()), event -> {			
			controller.createGameObject();
			controller.getObjectList().get(controller.getListCount() - 1).setCutFlag(true);
			Image fruitimg = SwingFXUtils.toFXImage(
			controller.getObjectList().get(controller.getListCount() - 1).getBufferedImages()[0], null);
			ImageView fruitiv = new ImageView(fruitimg);
			fruitiv.setLayoutX(rand(50, 900));
			fruitiv.setLayoutY(1);
			drop.add(fruitiv);
			root.getChildren().add((Node) (drop.get(drop.size() - 1)));
    		strategy.updateSpeed();		
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

		root.getChildren().addAll(swordiv, score,lbltimer,pause,resume);

	    scene = new Scene(root, 1000, 600);

		scene.setCursor(Cursor.NONE);

		scene.setOnMouseMoved(e -> {

			mouseX = e.getX();
			mouseY = e.getY();

		});
		
		pause.setOnAction(e->{
			int i =0;
			while(i<drop.size()) {
			root.getChildren().remove(drop.get(i));
			i++;
			}		drop.clear();
			controller.getObjectList().clear();
	   	   start = System.currentTimeMillis();
			timeline.pause();
			valid=false;
		});
       resume.setOnAction(e->{
    	   timeline.play();
			timeElapsed = timeElapsed + System.currentTimeMillis() - start;
    	   valid=true;    	
       });
	}

	public int rand(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	public void gameUpdate() {
		controller.loadGame("highscore");
		BestScore.setText("Best Score:  "+String.valueOf(controller.getHighScore()));
		if(controller.getLives()!=0&&valid==true) {
	     finish = System.currentTimeMillis();
	     timeElapsed = timeElapsed + finish - start;
	     timeElapsed=(timeElapsed/1000)-(mins*60);
	     lbltimer=change(lbltimer);
		}
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
			if (controller.sliceObjects(i) == true) {
				splatterPlayer.play();
				controller.getObjectList().get(i).setCutFlag(false);
				score.setText(String.valueOf(controller.getScore()));
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
					splatterPlayer.stop();

				}
				else if (controller.getObjectList().get(i) instanceof Boom){
					boomPlayer.play();
					controller.setLives(controller.getLives());
					boomPlayer.stop();
				}
				else if (controller.getObjectList().get(i) instanceof SpecialBomb){
					boomPlayer.play();
					controller.setLives(controller.getLives());
					boomPlayer.stop();
				}
				else if(controller.getObjectList().get(i) instanceof Pineapple){
					lblscore2 = new Label("Score X 2");
					lblscore2.setFont(new Font("Arial", 100));
					lblscore2.setLayoutX(200);
					lblscore2.setLayoutY(150);
					lblscore2.setStyle("-fx-text-fill: white;");
				}
				root.getChildren().add(cutFruitiv);
				drop.get(i).setImage(cutFruit);
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
				controller.getObjectList().remove(i);
				drop.remove(i);
			}
			else if (controller.hasMovedOfScreenBoundary(i)) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				drop.remove(i);
				controller.getObjectList().remove(i);

				controller.setLives(controller.getLives());
			}
			if (strategy instanceof Arcade){
				
				if(timeElapsed==0&&mins==1){
					controller.setLives(0);
				}
			}
			if (controller.getLives() == 0) {
				root.getChildren().removeAll(heartiv2,heartiv1,heartiv0);
				introPlayer.stop();
				GameOverPlayer.play();
				gameover.moveSubscene();
				for (int k = 0; k < drop.size(); k++) {
					root.getChildren().remove(drop.get(k));
				}
				drop.clear();
				timeline.pause();
			}
			if (controller.getLives() > 0){
				if(controller.getLives()==1){
					root.getChildren().remove(heartiv1);
				}
				else if(controller.getLives()==2){
					root.getChildren().remove(heartiv0);
				}
		}
	}
		controller.saveGame();

}
	Text change(Text lbltimer) {


		if(timeElapsed == 60) {
			mins++;

		}
		lbltimer.setText((((mins/10) == 0) ? "0" : "") + mins + ":"

	 + (((timeElapsed/10) == 0) ? "0" : "") + timeElapsed ); 
		return lbltimer;
	}
	public Scene getScene() {
		return scene;
	}

	public void setClassicMode(ClassicMode classicMode) {
		this.classicMode = classicMode;
	}

	public void setStrategy(IGameStrategy strategy) {
		this.strategy = strategy;
	}
	public void setNewgame(NewGame newgame) {
		this.newgame = newgame;
	}
	
}