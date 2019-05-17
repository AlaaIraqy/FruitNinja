package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Fruit;
import Model.GameObject;
import Model.GameObjectFactory;

public class ControllerFruit implements GameActions{
   List<GameObject> fruit  = new ArrayList<GameObject>();
    int score=0;
    int listCount=0;
	@Override
	public void createGameObject() {
		GameObjectFactory factory = new GameObjectFactory();
		GameObject fruitObject;
		fruitObject = factory.createFruit();
		fruit.add(fruitObject);
		listCount++;
		//return fruitObject;
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	
	public boolean sliceObjects(int i) {
	
			fruit.get(i).slice(); 

		if( fruit.get(i).isSliced()) {
			
		score++;
			return true;
		}
//		}else {
//			System.out.println("notSliced");
//			return false;
//		}
		//}
		return false;
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ResetGame() {
		// TODO Auto-generated method stub
		
	}
	public int getScore() {
		return  this.score;
	}
	public List<GameObject> getObjectList(){
		return fruit;
	}
	public void updateObjects() {
		createGameObject();
	}
public int getListCount() {
	return this.listCount;
}
	
}
