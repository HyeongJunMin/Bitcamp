package work1BaseballTeamManagement;

public class BatterDTO extends HumanDTO{
	private int swing;
	private int hit;
	private double hitRate;
	
	public BatterDTO () { }
	public BatterDTO(int num, String name, int age, double height, int swing, int hit, double hitR) {
		super(num, name, age, height);
		this.swing = swing;
		this.hit = hit;
		this.hitRate = Math.round( ( ((double)hit) / ( swing + hit ) )*100 ) /100;
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
		double bb = ( Math.round( ( getHit() / ( (getSwing()*1.0)  ) )*100.0 ) / 100.0 );
		return bb;
	}
	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}
	@Override
	public String toString() {
		double bb = ( Math.round( ( getHit() / ( (getSwing()*1.0) ) )*100.0 ) / 100.0 );
		return "BatterDTO [num=" + getNum() + ", name=" + getName() + ", age=" + getAge() + ", height=" + getHeight() +
				 ", swing=" + this.swing +  ", hit=" + this.hit + ", hitRate=" + bb  + "]"; 
	}
	//(Math.round( ( getHit() / ( (getSwing()*1.0) + getHit() ) )*100 ) /100)
}
