package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class Boom implements GameObject {
	private double Xlocation;
	private double Ylocation;
	private int MinHeight=600;
     boolean valid=false;
	 boolean cutFlag=true;
	 Sword swrd = Sword.getInstance();
	@Override
	public double getXlocation() {
		// TODO Auto-generated method stub
		return Xlocation;
	}

	@Override
	public double getYlocation() {
		// TODO Auto-generated method stub
		return Ylocation;
	}

	@Override
	public int getMinHeight() {
		// TODO Auto-generated method stub
		return MinHeight;
	}

	@Override
	public int getInitialVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isSliced() {
		// TODO Auto-generated method stub
		return valid;
	}

	@Override
	public Boolean hasMovedOffScreen() {
		if(getYlocation() > getMinHeight() ) {
			return true;
		}
		
		return false;		
	}

	@Override
	public void slice() {
	 	 if( cutFlag&&( (getXlocation() > swrd.getPositionX()-80 )&& (getXlocation() < swrd.getPositionX()+100 ) )&&
	   			 ( (getYlocation() > swrd.getPositionY()-80) && (getYlocation()< swrd.getPositionY()+100 ) ) )	{
	   		
	   		 cutFlag = false;
	   		 valid = true;
	    }

	}

	@Override
	public void move(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage[] getBufferedImages() {
BufferedImage[] arr = new BufferedImage[5];
		

for(int i=0;i<3;i++) {
	BufferedImage img =null ;
	File file =  new File("boom-"+i+".png");
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

	@Override
	public void setXlocation(double xlocation) {
		this.Xlocation = xlocation;
		
	}

	@Override
	public void setYlocation(double ylocation) {
		this.Ylocation = ylocation;
		
	}

	@Override
	public void setCutFlag(boolean flag) {
		cutFlag = flag;
		
	}

}
