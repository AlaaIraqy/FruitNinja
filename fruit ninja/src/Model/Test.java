package Model;

import Controller.ControllerFruit;

public class Test {
public static void main(String args[]) {
    ControllerFruit cont = new ControllerFruit();	
    cont.loadGame();
   System.out.println(cont.getHighScore()+"   "+cont.getScore()+"   "+cont.getLives());
}
}
