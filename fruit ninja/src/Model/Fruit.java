package Model;
import java.awt.image.BufferedImage;

public abstract class Fruit implements GameObject {

	private int Xlocation;
	private int Ylocation;
	private int MinHeight;
	private int InitialVelocity;
	private int FallingVelocity;
	
//	public ENUM getObjectType(int x) {
//		
//		if(x==1)
//			return ENUM.APPLE;
//		else if(x==2)
//			return ENUM.BANANA;
//		else if(x==3)
//			return ENUM.BASHA;
//		else if(x==5)
//			return ENUM.BOOM;
//		else if(x==6)
//			return ENUM.PEACH;
//		else if(x==7)
//			return ENUM.SANDIA;
//		else if(x==8)
//			return ENUM.SWORD;
//		else
//			return null;
//		
//	}

	@Override
	public int getXlocation() {
		// TODO Auto-generated method stub
		return Xlocation;
	}

	@Override
	public int getYlocation() {
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
		return InitialVelocity;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return FallingVelocity;
	}

	@Override
	public Boolean isSliced() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage[] getBufferedImages() {
		// TODO Auto-generated method stub
		return null;
	}
}
