package blackjackGameCanSave;

public class Player {
	private int num;
	private String id;
	private String pw;
	private String name;
	private int deposit;
	private int cnt;
	private int wins;
	private double winRate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
	
	public Player() {
		
	}
	public Player(int num, String id, String pw, String name, int deposit, int cnt, int wins, double winRate) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.deposit = deposit;
		this.cnt = cnt;
		this.wins = wins;
		this.winRate = Math.round(winRate*10)/10;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	@Override
	public String toString() {
		return "Player [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", deposit=" + deposit + ", cnt="
				+ cnt + ", wins=" + wins + ", winRate=" + (Math.round(  (this.wins / (this.cnt*1.0) )*100 ))/100.0 + "]";
	}
	
		
	
}
