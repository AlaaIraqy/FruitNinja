package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class Banana extends Fruit {
	 public BufferedImage[] getBufferedImages() {
			BufferedImage[] arr = new BufferedImage[5];

			BufferedImage img = null;
	for(int i=0;i<3;i++) {
			File file =  new File("C:\\Users\\PC castle\\git\\mivomikha\\fruit ninja\\src\\banana-"+i+".png");
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
}
