package Model;

public class Medium implements IGameStrategy{
	   private double speed = 0.3;
	    private double falling = 300;
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
			speed += falling / 3000;
		}
}
