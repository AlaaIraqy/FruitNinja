package Model;

import java.beans.XMLDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Controller.ControllerFruit;

public class Load {
	
//	private List<Fruit> FruitsList = new ArrayList<>();
	
	public ArrayList<Integer> gameData= new ArrayList<>();
	String choice;
	IGameStrategy strategy;
	ControllerFruit Cf = ControllerFruit.getInstance();
	public Load(ArrayList<Integer> gameData,String choice,IGameStrategy strategy) {
	    this.strategy = strategy;
         this.choice = choice;
		this.gameData = gameData;
	}

  public void loadProgress() {
	  
		try {
			
			FileInputStream fis;
			if(strategy instanceof Easy) {
				fis = new FileInputStream(new File("gameData.xml"));
				
			}else if(strategy instanceof Medium) {
				fis = new FileInputStream(new File("gameData2.xml"));
				
			}else if(strategy instanceof Difficult) {
				fis = new FileInputStream(new File("gameData3.xml"));
			
			}else if(strategy instanceof Arcade) {
				fis = new FileInputStream(new File("gameData4.xml"));
				
			}else {
				fis = null;
			}

		XMLDecoder decoder = new XMLDecoder(fis);
			gameData = (ArrayList)decoder.readObject();
			decoder.close();
			fis.close();
			if (choice.equalsIgnoreCase("highscore"))
				 Cf.setHighScore(gameData.get(1));
			else if(choice.equalsIgnoreCase("all")){
		    Cf.setScore(gameData.get(0));
		    Cf.setHighScore(gameData.get(1));
		    Cf.setLives(gameData.get(2));
			}
				}catch(IOException ex){}
		
}
}
