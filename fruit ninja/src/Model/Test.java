package Model;

import Controller.ControllerFruit;

public class Test {
public static void main(String args[]) {
    ControllerFruit cont = ControllerFruit.getInstance();	
   //cont.setScore(100);
    //cont.setHighScore(1000);
    cont.saveGame();
      cont.loadGame();
   System.out.println(cont.getHighScore()+"   "+cont.getScore()+"   "+cont.getLives());
}
}
