package Model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import javafx.scene.image.ImageView;
public class Apple  extends Fruit{
	Sword swrd = Sword.getInstance();
	
   public BufferedImage[] getBufferedImages() {
		BufferedImage[] arr = new BufferedImage[5];
		
		BufferedImage img = null;
for(int i=0;i<3;i++) {
		File file =  new File("apple-"+i+".png");
	try {
	
			img = ImageIO.read(file);
		} catch (IIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			
		}

		arr[i] = img;
}
		return arr;
	   
   }
     public void slice() {
//		 System.out.println("logiccy"+getYlocation());
//		 System.out.println("logiccx"+getXlocation());
//		 System.out.println(swrd.getPositionX()+"swordx");
//		 System.out.println(swrd.getPositionY()+"swordy");
    	 System.out.println("logicx-swrd"+swrd.getPositionX());
		 System.out.println("logicy-swrd"+swrd.getPositionY());
    	 
    	 if( ( (getXlocation() > swrd.getPositionX()+70 )&& (getXlocation() < swrd.getPositionX() ) )&&
    			 ( (getYlocation() > swrd.getPositionY()+70) && (getYlocation()< swrd.getPositionY() ) ) )	{
    	//	 System.out.println("logicc"+getYlocation());
    		 valid = true;
     }

}
    
}
