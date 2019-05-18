package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpecialFruit extends Fruit {
	private GameObject Fruit;
	public SpecialFruit (GameObject Fruit){
		this.Fruit=Fruit;
	}
	public BufferedImage[] getBufferedImages() {
			BufferedImage[] arr = new BufferedImage[5];
			BufferedImage img = null;
	for(int i=0;i<3;i++) {
			arr[i] = Fruit.getBufferedImages()[i];		
	}
	File file =  new File("effect.png");
	
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
           arr[3]=img;
			return arr;
	}
}

