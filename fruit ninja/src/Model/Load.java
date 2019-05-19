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
	
	public ArrayList<Integer> gameData= new ArrayList<>();
	 ControllerFruit Cf = ControllerFruit.getInstance();
	public Load(ArrayList<Integer> gameData) {
	
		this.gameData = gameData;
	}

  public void loadProgress() {
	  
		try {
			
		FileInputStream fis = new FileInputStream(new File("gameData.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			gameData = (ArrayList)decoder.readObject();
			decoder.close();
			fis.close();
		    Cf.setScore(gameData.get(0));
		    Cf.setHighScore(gameData.get(1));
		    Cf.setLives(gameData.get(2));
			
				}catch(IOException ex){}
		
}
}
