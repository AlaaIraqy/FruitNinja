package Model;
import java.awt.image.BufferedImage;

public abstract class Fruit implements GameObject {

	private double Xlocation;
	private double Ylocation;
	private int MinHeight;
	private int InitialVelocity;
	private int FallingVelocity;
     boolean valid=false;
	 boolean cutFlag=true;
	 Sword swrd = Sword.getInstance();
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
	public void move(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage[] getBufferedImages() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setXlocation(double Xlocation) {
		this.Xlocation = Xlocation;
	}
	public void setYlocation(double  Ylocation) {
		this.Ylocation = Ylocation;
	}
	public void slice() {
   	 
   	 if( cutFlag&&( (getXlocation() > swrd.getPositionX()-80 )&& (getXlocation() < swrd.getPositionX()+100 ) )&&
   			 ( (getYlocation() > swrd.getPositionY()-80) && (getYlocation()< swrd.getPositionY()+100 ) ) )	{
   		
   		 cutFlag = false;
   		 valid = true;
    }

}
	public void setCutFlag(boolean  flag) {
		cutFlag=flag;
	}
}
