package Model;

import java.beans.XMLDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.ControllerFruit;

public class Load {
	
//	private List<Fruit> FruitsList = new ArrayList<>();
	
	private int score;
	private int highScore;
	private int lives;
	//private  ControllerFruit Cf = new  ControllerFruit();
	public Load(int score, int highScore, int lives) {
	
		this.score = score;
		this.highScore = highScore;
		this.lives = lives;
	}
	public void setValues(int score, int highScore, int lives) {
		this.score = score;
		this.highScore = highScore;
		this.lives = lives;
		
	}
  public void loadProgress() {
		
		try {
			
		FileInputStream fis = new FileInputStream(new File("Score.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			score = (int) decoder.readObject();
			decoder.close();
			fis.close();
		
			FileInputStream fis2 = new FileInputStream(new File("High Score.xml"));
			XMLDecoder decoder2 = new XMLDecoder(fis2);
			highScore = (int) decoder2.readObject();
			decoder2.close();
			fis2.close();
		
			FileInputStream fis3 = new FileInputStream(new File("Lives.xml"));
			XMLDecoder decoder3 = new XMLDecoder(fis3);
			lives = (int) decoder3.readObject();
			decoder3.close();
			fis3.close();
			
			setValues(score, highScore, lives);
		}catch(IOException ex){}
		
}
}
