package Model;

import java.util.Random;

public class GameObjectFactory {
      public GameObject createFruit() {
    	  int i;
    	  Random rand  = new Random();
    	  i = rand.nextInt(6);
    	  if(i==0) {
    		  return new Apple();}
    	  else if(i==1) {
    		   return new Banana();
    	   }
    	  else if(i==2) {
    		   return new Basaha();
    	   } 
    	  else if(i==3) {
    		   return new Peach();
    	   } 
    	  else if(i==4) {
    		   return new Sandia();
    	   } 
    	  else if(i==5) {
    		   return new Boom();
    	   } 
    	  else {
    		  return null;
    	  }
    	  }
      }

