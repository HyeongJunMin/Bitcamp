package dto;

public class StudentDto {
	//Data Transfer Object
	//객체 별 데이터 관리 클래스
	
	private int number;
	private String name;
	private int korScore;
	private int engScore;
	private int mthScore;
	
	public StudentDto() {
		
	}
	
	public StudentDto(int number, String name, int korScore, int engScore, int mthScore) {
		super();
		this.number = number;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mthScore = mthScore;
	}

	@Override
	public String toString() {
		return "StudentDto [number=" + number + ", name=" + name + ", korScore=" + korScore + ", engScore=" + engScore
				+ ", mthScore=" + mthScore + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMthScore() {
		return mthScore;
	}

	public void setMthScore(int mthScore) {
		this.mthScore = mthScore;
	}
}
