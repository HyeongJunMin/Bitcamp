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
		//�Ʊ�� �Ȱ��� �ν��Ͻ��� �Ѿ��
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
