package review190603;

public class Batter extends Human {
	
	private int bat;
	private int hit;
	private double hitAvg;
	
	public Batter() {
	}

	public Batter(int number, String name, int age, double height, 
				int bat, int hit, double hitAvg) {
		super(number, name, age, height);
		this.bat = bat;
		this.hit = hit;
		this.hitAvg = hitAvg;
	}

	public int getBat() {
		return bat;
	}

	public void setBat(int bat) {
		this.bat = bat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitAvg() {
		return hitAvg;
	}

	public void setHitAvg(double hitAvg) {
		this.hitAvg = hitAvg;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + bat + "-" + hit + "-" + hitAvg;
	}

}





