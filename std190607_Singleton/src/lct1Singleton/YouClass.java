package lct1Singleton;

public class YouClass {
	private int youNum;
	private String yName;
	
	public YouClass() {  }
	
	public int getYouNum() {
		return youNum;
	}
	public void setYouNum(int youNum) {
		this.youNum = youNum;
	}
	
	public void youMethod() {
		//아까랑 똑같은 인스턴스가 넘어옴
		youNum = SingletonClass.num;
	}
	
	public void youMethod2() {
		yName = SingletonClass.name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "younum : "+this.youNum + "\tyouname : " + this.yName;
	}
}
