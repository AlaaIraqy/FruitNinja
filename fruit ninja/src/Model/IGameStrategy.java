package Model;

public interface IGameStrategy {
	public double getSpeed();
	public void setSpeed(double speed);
	public double getFalling();
	public void setFalling(int falling);
	public void updateSpeed();
}
