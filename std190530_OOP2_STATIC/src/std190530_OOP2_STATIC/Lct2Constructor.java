package std190530_OOP2_STATIC;

public class Lct2Constructor {
	public static void main(String[] args) {
		Lct2Constructor l = new Lct2Constructor('c');
		
	}
	
	
	//������
	public Lct2Constructor(){
		System.out.println("empty");
	}
	
	public Lct2Constructor(int i){
		this();
		System.out.println("int i");
	}
	
	public Lct2Constructor(char c){
		this(1);//ù��° �ٿ��� �ۼ� ����
		System.out.println("int c");
	}
}
