package Model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
public class Apple  extends Fruit{
//	Sword swrd = Sword.getInstance();
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
//     public void slice() {
//    	 
//    	 if( ( (getXlocation() > swrd.getPositionX()-80 )&& (getXlocation() < swrd.getPositionX()+100 ) )&&
//    			 ( (getYlocation() > swrd.getPositionY()-80) && (getYlocation()< swrd.getPositionY()+100 ) ) )	{
//    	//	 System.out.println("logicc"+getYlocation());
//    		 valid = true;
//     }
//
//}
    
}
