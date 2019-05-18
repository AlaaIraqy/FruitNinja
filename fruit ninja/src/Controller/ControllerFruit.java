package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Model.Basaha;
import Model.GameObject;
import Model.GameObjectFactory;
import Model.IGameStrategy;
import Model.SpecialFruit;

public class ControllerFruit implements GameActions{
   List<GameObject> fruit  = new ArrayList<GameObject>();
   SpecialFruit Special;
   IGameStrategy strategy;
    int score=0;
    int listCount=0;
    int lives = 3;
    int j;
    Random rand=new Random();
    boolean valid;
	@Override
	public void createGameObject() {
		GameObjectFactory factory = new GameObjectFactory();
		GameObject fruitObject;
		j=rand.nextInt(10);
		if(j!=0){
			
			fruitObject = factory.createFruit();
			fruit.add(fruitObject);
			listCount=fruit.size();
		}
		else{
			fruitObject = factory.createFruit();
			Special= new SpecialFruit(fruitObject);
			fruit.add(Special);
			listCount=fruit.size();
		}
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}
	public boolean sliceObjects(int i) {
	
			fruit.get(i).slice(); 

		if( fruit.get(i).isSliced()) {
			if(fruit.get(i) instanceof SpecialFruit) {
				score = score+1;
		        strategy.setSpeed(0.01);
			}
			
		score++;
			return true;
		}

		
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
	public boolean hasMovedOfScreenBoundary(int i) {
		valid=fruit.get(i).hasMovedOffScreen();
		if(valid==true) {
			lives--;
		}
		return valid;
	}
public int getListCount() {
	return this.listCount;
}
public void setListCount(int listCount) {
	this.listCount = listCount;
}

public int getLives() {
	return this.lives;
}
public void setLives(int lives) {
	this.lives = lives;
}
public void setStrategy(IGameStrategy strategy){
	this.strategy = strategy;
}
}
