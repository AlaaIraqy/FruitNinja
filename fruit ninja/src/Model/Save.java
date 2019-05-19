package Model;



import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save  {
	
	private ArrayList<Integer> gameData = new ArrayList<>();
	
	
	public Save( ArrayList<Integer> gameData ) {
		
		this.gameData =  gameData;
	}

      
	public void saveProgress() {
		
		if(gameData.get(0)>gameData.get(1))
		{   int temp = gameData.get(0);
			gameData.add(1, temp);
			
		}
	try {
		
		FileOutputStream fos = new FileOutputStream(new File("gameData.xml"));
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(gameData);
		encoder.close();
		fos.close();
		
	
		
	} catch (IOException ex) {
	};
	
	
}

		
}
