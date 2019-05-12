package Controller;

import Model.GameObject;
import Model.GameObjectFactory;

public class ControllerFruit implements GameActions{

	@Override
	public GameObject createGameObject() {
		GameObjectFactory factory = new GameObjectFactory();
		return factory.createFruit();
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sliceObjects() {
		// TODO Auto-generated method stub
		
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
	

}
