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
	private  ControllerFruit Cf = new  ControllerFruit();
	public Load(int score, int highScore, int lives) {
	
		this.score = score;
		this.highScore = highScore;
		this.lives = lives;
	}
  public void loadProgress() {
		  
		try {
			
		FileInputStream fis = new FileInputStream(new File("./Score.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			score = (int) decoder.readObject();
			Cf.setScore(score);
			decoder.close();
			fis.close();
		
			
		}catch(IOException ex){}
}
}
