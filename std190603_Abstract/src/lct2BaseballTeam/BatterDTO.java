package lct2BaseballTeam;

public class BatterDTO extends HumanDTO{
	private int swing;
	private int hit;
	private double hitRate;
	
	public BatterDTO () { }
	public BatterDTO(int num, String name, int age, double height, int swing, int hit, double hitR) {
		super(num, name, age, height);
		this.swing = swing;
		this.hit = hit;
		this.hitRate = hitRate;
	}	
	
	public int getSwing() {
		return swing;
	}
	public void setSwing(int swing) {
		this.swing = swing;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getHitRate() {
		return hitRate;
	}
	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}
	@Override
	public String toString() {
		return "BatterDTO [num=" + getNum() + ", name=" + getName() + ", age=" + getAge() + ", height=" + getHeight() +
				 ", swing=" + this.swing +  ", hit=" + this.hit + ", hitRate=" + this.hitRate + "]"; 
	}
}
