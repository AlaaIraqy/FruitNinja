package Controller;

import Model.Fruit;
import Model.GameObject;
import Model.GameObjectFactory;

public class ControllerFruit implements GameActions{
    GameObject fruit;
    int score=0;
   
	@Override
	public GameObject createGameObject() {
		GameObjectFactory factory = new GameObjectFactory();
		fruit=factory.createFruit();
		return fruit;
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sliceObjects() {
		fruit.slice(); 
		if( fruit.isSliced()) {
		score++;
			return true;
		}else {
			return false;
		}
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

}
