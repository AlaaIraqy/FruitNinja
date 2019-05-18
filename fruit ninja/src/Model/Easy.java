package Model;

public class Easy implements IGameStrategy{
    private double speed = 0.2;
    private double falling = 400;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getFalling() {
		return falling;
	}
	public void setFalling(int falling) {
		this.falling = falling;
	}
	public void updateSpeed() {
		speed += falling / 4000;
	}
    
}
