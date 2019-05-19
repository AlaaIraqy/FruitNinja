package Model;

import java.util.Random;

public class GameObjectFactory {
      public GameObject createFruit() {
    	  int i;
    	  Random rand1 = new Random();
    	  int j = rand1.nextInt(30);
    	  Random rand  = new Random();
    	  if(j==1) {
    		  return new Boom();
    	  }else {
    	  i = rand.nextInt(5);
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
    
    	  }
    	  return null;
      }
    
      }

