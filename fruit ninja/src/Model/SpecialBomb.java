package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpecialBomb extends Boom{
	private GameObject Boom;
	public SpecialBomb (GameObject Boom){
		this.Boom=Boom;
	}
	public BufferedImage[] getBufferedImages() {
			BufferedImage[] arr = new BufferedImage[5];
			BufferedImage img = null;
	for(int i=1;i<3;i++) {
			arr[i] = Boom.getBufferedImages()[i];	
			System.out.println("hey");
	}
	File file =  new File("bomb.png");
	
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
           arr[0]=img;
			return arr;
	}
}
