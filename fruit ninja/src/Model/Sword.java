package Model;

public class Sword {
	
private Sword() {
	
}
public static Sword getInstance() {
	return NewSingltonHolder.INSTANCE;
}
private static class NewSingltonHolder{
	private static final Sword INSTANCE = new Sword();
}
private double positionX;
private double positionY;
public double getPositionX() {
	return positionX;
}
public void setPositionX(double positionX) {
	this.positionX = positionX;
}
public double getPositionY() {
	return positionY;
}
public void setPositionY(double positionY) {
	this.positionY = positionY;
}

}
