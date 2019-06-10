package lct3AWT;

public class PitcherDTO extends HumanDTO{
	private int win;
	private int lose;
	private double defenceRate;
	
	public PitcherDTO() { }
	
	public PitcherDTO(int num, String name, int age, double height, int win, int lose, double defenceR) { 
	super(num, name, age, height);
	this.win = win;
	this.lose = lose;
	double dfcOrHitRate = ((win + lose) == 0) ? 0.0 : ((double) win) / (win + lose);
	this.defenceRate = (Math.round(dfcOrHitRate*100))/100.0; 
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getDefenceRate() {
		double ddd = ((win + lose) == 0) ? 0.0 : ((double) win) / (win + lose);

		return (Math.round(ddd*100))/100.0; 
	}

	public void setDefenceRate(double defenceRate) {
		this.defenceRate = defenceRate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		double dfcOrHitRate = ((getWin() + getLose()) == 0) ? 0.0 : ((double) getWin()) / (getWin() + getLose());
		return "PitcherDTO [num=" + super.getNum() + ", name=" + super.getName() + ", age=" + super.getAge() + ", height=" + super.getHeight()
		+ ", win=" + this.win + ", lose=" + this.lose + ", defenceRate=" + (Math.round(dfcOrHitRate*100))/100.0 +"]";
	}
}
