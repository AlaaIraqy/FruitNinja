package Controller;

import java.util.List;

import Model.GameObject;
import Model.IGameStrategy;

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
public void loadGame(String choice);
/*
*resets the game to its initial state
*/
public void ResetGame();
public int getScore();
public List<GameObject> getObjectList();
public void updateObjects();
public int getListCount();
public void setListCount(int i);
public void setLives(int i);
public int getLives();
public boolean hasMovedOfScreenBoundary(int i);
public void setStrategy(IGameStrategy strategy);
public void setScore(int newscore);
public int getHighScore();
public void setHighScore(int highScore);

}
