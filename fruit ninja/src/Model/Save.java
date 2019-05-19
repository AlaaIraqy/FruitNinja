package Model;



import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save  {
	
	private int score;
	private int highScore;
	private int lives;
	
	
	public Save(int score, int highScore, int lives) {
		
		this.score = score;
		this.highScore = highScore;
		this.lives = lives;
	}


	public void saveProgress() {
		if(score>highScore)
		{
			highScore=score;
		}
	try {
		
		FileOutputStream fos = new FileOutputStream(new File("./Score.xml"));
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(score);
		encoder.close();
		fos.close();
		
		FileOutputStream fos2 = new FileOutputStream(new File("./High Score.xml"));
		XMLEncoder encoder2 = new XMLEncoder(fos2);
		encoder2.writeObject(highScore);
		encoder2.close();
		fos2.close();
		
		
		FileOutputStream fos3 = new FileOutputStream(new File("./Lives.xml"));
		XMLEncoder encoder3 = new XMLEncoder(fos3);
		encoder3.writeObject(lives);
		encoder3.close();
		fos3.close();
		
	} catch (IOException ex) {
	};
	
	
}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getHighScore() {
		return highScore;
	}


	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}


	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}
	
	
	
}
