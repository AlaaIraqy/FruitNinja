package Controller;

import java.util.List;

import Model.GameObject;

public interface GameActions {

	/*
	*@return created game object
	*/
	public void createGameObject();
	/*
	* update moving objects locations
	* 
	* */
 public void updateObjectsLocations(); 
  /*
* it is used to slice fruits located in your swiping region
This method can take your swiping region as parameters (they
depend on how you calculate it).
*/
public boolean sliceObjects(int i);
/*
*saves the current state of the game
*/
public void saveGame();
/*
*loads the last saved state of the game
*/
public void loadGame();
/*
*resets the game to its initial state
*/
public void ResetGame();
public int getScore();
public List<GameObject> getObjectList();
public void updateObjects();
public int getListCount();
}
