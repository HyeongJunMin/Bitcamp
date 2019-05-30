package std190530_OOP2_STATIC;

public class Lct2Constructor {
	public static void main(String[] args) {
		Lct2Constructor l = new Lct2Constructor('c');
		
	}
	
	
	//생성자
	public Lct2Constructor(){
		System.out.println("empty");
	}
	
	public Lct2Constructor(int i){
		this();
		System.out.println("int i");
	}
	
	public Lct2Constructor(char c){
		this(1);//첫번째 줄에만 작성 가능
		System.out.println("int c");
	}
}
