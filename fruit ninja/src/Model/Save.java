package Model;



import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save  {
	
	private ArrayList<Integer> gameData = new ArrayList<>();
	IGameStrategy strategy;
	
	public Save( ArrayList<Integer> gameData,IGameStrategy strategy ) {
		
		this.gameData =  gameData;
	   this.strategy = strategy;
	}

      
	public void saveProgress() {
		
		if(gameData.get(0)>gameData.get(1))
		{   int temp = gameData.get(0);
			gameData.add(1, temp);
		
		}
	try {
		
		FileOutputStream fos;
		if(strategy instanceof Easy) {
			fos = new FileOutputStream(new File("gameData.xml"));
		}else if(strategy instanceof Medium) {
			fos = new FileOutputStream(new File("gameData2.xml"));
		}else if(strategy instanceof Difficult) {
			fos = new FileOutputStream(new File("gameData3.xml"));
		}else if(strategy instanceof Arcade) {
			fos = new FileOutputStream(new File("gameData4.xml"));
		}else {
			fos = null;
		}
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(gameData);
		encoder.close();
		fos.close();
		
	
		
	} catch (IOException ex) {
	};
	
	
}

		
}
