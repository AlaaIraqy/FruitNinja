package Model;


public class Arcade implements IGameStrategy {
	 private double speed = 0.5;
	    private double falling = 200;
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
			speed += falling / 2000;

			
		}
	
}
